package com.supermonk.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@EnableCaching
@EnableAutoConfiguration
@EnableConfigurationProperties 
public class Application  {



	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		// @formatter:off
		return builder.routes().route("path_route",
				r -> r.path("/").uri("http://localhost:8301/"))
				.build();
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
