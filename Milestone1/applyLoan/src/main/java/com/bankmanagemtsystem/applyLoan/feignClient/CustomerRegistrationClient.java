package com.bankmanagemtsystem.applyLoan.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.bankmanagemtsystem.applyLoan.model.UserLogin;

@FeignClient(name = "login-registration", url = "http://localhost:9095")
public interface CustomerRegistrationClient {

	@PostMapping("/login")
	public String loginExistingUser(@RequestBody UserLogin user);

}