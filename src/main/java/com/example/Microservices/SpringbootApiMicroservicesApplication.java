package com.example.Microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringbootApiMicroservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApiMicroservicesApplication.class, args);
	}

	@Bean
	
	public RestTemplate ReatTemplate() {
		return new RestTemplate();
	}
}
