package com.eureka.client.cleintservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CleintServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CleintServiceApplication.class, args);
	}

}
