package com.supermonk.cloud;

import static org.springframework.cloud.gateway.support.ServerWebExchangeUtils.CLIENT_RESPONSE_ATTR;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.reactive.function.BodyExtractors;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

//@Component
public class RequestResponseFilter implements GatewayFilter, Ordered {

	private static final Logger logger = LoggerFactory.getLogger(RequestResponseFilter.class);

	private static final String COUNT_Start_TIME = "countStartTime";

//	    @Override
//	    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//	        exchange.getAttributes().put(COUNT_Start_TIME, System.currentTimeMillis());
//	        return chain.filter(exchange.mutate().build())
////	        		.then(
////	                Mono.fromRunnable(() -> {
////	                    Long startTime = exchange.getAttribute(COUNT_Start_TIME);
////	                    Long endTime=(System.currentTimeMillis() - startTime);
////	                    if (startTime != null) {
////	                        logger.info(exchange.getRequest().getURI().getRawPath() + ": " + endTime + "ms");
////	                    }
////	                    
////	                })
////	        )
//	        		;
//	    }

//	    return chain.filter(exchange.mutate().request(request).build());

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		// NOTICE: nothing in "pre" filter stage as CLIENT_RESPONSE_ATTR is not added
		// until the WebHandler is run
		exchange.getAttributes().put(COUNT_Start_TIME, System.currentTimeMillis());
		return chain.filter(exchange).then(Mono.defer(() -> {
			
			
			System.out.println(exchange.toString());
			ClientResponse clientResponse = exchange.getAttribute(CLIENT_RESPONSE_ATTR);
			if (clientResponse == null) {
				return Mono.empty();
			}
			logger.trace("WebClientWriteResponseFilter start");
			Long startTime = exchange.getAttribute(COUNT_Start_TIME);
			Long endTime = (System.currentTimeMillis() - startTime);
			if (startTime != null) {
				logger.info(exchange.getRequest().getURI().getRawPath() + ": " + endTime + "ms");
			}
			ServerHttpResponse response = exchange.getResponse();

			return response.writeWith(clientResponse.body(BodyExtractors.toDataBuffers())).log("webClient response");
		}));
	}

	@Override
	public int getOrder() {
		// TODO Auto-generated method stub
		return -1;
	}

}
