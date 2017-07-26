package com.example.demo;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SoapSpringBootApplication {

	static final Logger logger = LogManager.getLogger(SoapSpringBootApplication.class.getName());

	public static void main(String[] args) {
		logger.info("entering application");
		SpringApplication.run(SoapSpringBootApplication.class, args);
	}
}
