package com.loanvalidationservice.loanvalidationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDiscoveryClient
public class LoanvalidationserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoanvalidationserviceApplication.class, args);
	}

}
