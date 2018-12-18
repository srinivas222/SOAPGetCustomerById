package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:META-INF/spring/applicationContext.xml")

public class SoapSampleExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoapSampleExampleApplication.class, args);
	}
}
