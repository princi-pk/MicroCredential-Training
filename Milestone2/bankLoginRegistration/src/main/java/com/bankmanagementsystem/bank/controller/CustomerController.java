package com.bankmanagementsystem.bank.controller;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankmanagementsystem.bank.model.Customer;
import com.bankmanagementsystem.bank.model.UserLogin;
import com.bankmanagementsystem.bank.service.FirebaseService;

@RestController
public class CustomerController {

	private static Logger logger = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	private FirebaseService service;

	@PostMapping("/register")
	public String newCustomerRegister(@RequestBody Customer customer) throws ExecutionException, InterruptedException {
		logger.info("START: Registration process");
		String msg1 = service.saveUserDetails(customer);
		logger.debug(msg1);
		logger.info("END: Registration process");
		return msg1;
	}
	

	@GetMapping("/register/{userId}")
	public String getCustomerDetail(@PathVariable String userId) throws ExecutionException, InterruptedException {
		logger.info("START: Getting specific customer detail");
		if (service.getCustomerDetailsByUserId(userId) == null) {
			logger.debug("User does not exist with entered user id");
			return"User does not exist with entered user id";
		} else {
			logger.debug("Account detail of given customer: {}", service.getCustomerDetailsByUserId(userId));
			logger.info("END: Getting specific customer detail");
			return "Account detail of given customer: "+ service.getCustomerDetailsByUserId(userId);
		}
	}

	
	@GetMapping("/register")
	public List<Customer> getAllCustomer() throws ExecutionException, InterruptedException {
		logger.info("START: Process of displaying details of all customers");
		logger.debug("Account details of all users: {}", service.getAllCustomerDetails());
		logger.info("END: Process of displaying details of all customers");
		return service.getAllCustomerDetails();
	}

	
	@PutMapping("/update/{userId}")
	public String updateDetails(@RequestBody Customer customer, @PathVariable String userId)
			throws ExecutionException, InterruptedException {
		logger.info("START: Process of updating details");
		String msg1 = service.updateCustomer(customer, userId);
		logger.debug(msg1);
		logger.info("END: Process of updating details");
		return msg1;
	} 
	

	@PostMapping("/login")
	public String loginExistingCustomers(@RequestBody UserLogin user, Customer customer)
			throws InterruptedException, ExecutionException {
		logger.info("START: Login process");
		String msg2 = service.loginCustomer(customer, user);
		logger.debug(msg2);
		logger.info("END: Login process");
		return msg2;
	}
	

}
