package com.supermonk.cloud.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	private static final Logger logger = LoggerFactory.getLogger(HelloWorldController.class);

	@GetMapping("/")
	public String home() {
		logger.info(" Request {}", "Hello World");
		return "Hello world";
	}

}