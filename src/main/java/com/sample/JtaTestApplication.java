package com.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JtaTestApplication {

    public static final String DESTINATION = "messages";

	public static void main(String[] args) {
		SpringApplication.run(JtaTestApplication.class, args);
	}
}
