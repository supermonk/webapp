package com.supermonk.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.RouteLocator;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@EnableEurekaServer
@SpringBootApplication
public class Application {
	
//	@Bean
//	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
//		// @formatter:off
//		return builder.routes().route("path_route", r -> r.host("http://localhost:8300")
//				.filters(f -> f.filter(new RequestResponseFilter())).uri("http://localhost:8301")).build();
//	}
	
	 public static void main(String[] args) {
	        SpringApplication.run(Application.class, args);
	    }

}
