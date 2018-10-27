package com.supermonk.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@EnableCaching
@EnableAutoConfiguration
@EnableConfigurationProperties
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
