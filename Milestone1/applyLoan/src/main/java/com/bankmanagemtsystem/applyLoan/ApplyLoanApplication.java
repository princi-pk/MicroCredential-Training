package com.bankmanagemtsystem.applyLoan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ApplyLoanApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApplyLoanApplication.class, args);
	}

}
