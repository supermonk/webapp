package com.supermonk.cloud;

//@Component
public class RequestResponseFilter  {
//	implements GatewayFilter, Ordered {
}
//
//	private static final Logger logger = LoggerFactory.getLogger(RequestResponseFilter.class);
//
//	private static final String COUNT_Start_TIME = "countStartTime";
//
//	    @Override
//	    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//	        exchange.getAttributes().put(COUNT_Start_TIME, System.currentTimeMillis());
//	        return chain.filter(exchange).then(
//	                Mono.fromRunnable(() -> {
//	                    Long startTime = exchange.getAttribute(COUNT_Start_TIME);
//	                    Long endTime=(System.currentTimeMillis() - startTime);
//	                    if (startTime != null) {
//	                        logger.info(exchange.getRequest().getURI().getRawPath() + ": " + endTime + "ms");
//	                    }
//	                })
//	        );
//	    }
//
//	    @Override
//	    public int getOrder() {
//	        return Ordered.LOWEST_PRECEDENCE;
//	    }
//	}

