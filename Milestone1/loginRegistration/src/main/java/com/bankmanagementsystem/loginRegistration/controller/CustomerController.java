package com.bankmanagementsystem.loginRegistration.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bankmanagementsystem.loginRegistration.model.Customer;
import com.bankmanagementsystem.loginRegistration.model.UserLogin;
import com.bankmanagementsystem.loginRegistration.repository.CustomerRepository;
import com.bankmanagementsystem.loginRegistration.service.CustomerService;

@RestController
public class CustomerController {

	private static Logger logger = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	private CustomerRepository custRepo;

	@Autowired
	private CustomerService service;

	@PostMapping("/register")
	public String newCustomerRegister(@RequestBody Customer customer) {
		logger.info("START: Registration process");
		String msg1 = service.customerAlreadyRegistered(customer);
		logger.debug(msg1);
		logger.info("END: Registration process");
		return msg1;
	}

	@GetMapping("/register")
	public List<Customer> getAllUsersDetails() {
		logger.info("START: Process of displaying details of all users");
		logger.debug("Account details of all users: {}", custRepo.findAll());
		logger.info("END: Process of displaying details of all users");
		return custRepo.findAll();
	}

	@PostMapping("/login")
	public String loginExistingUser(@RequestBody UserLogin user, Customer customer) {
		logger.info("START: Login process");
		try {
			int id = user.getUserId();
			String pass = user.getPassword();
			customer = custRepo.findById(id).orElse(null);
			String msg2 = service.userIdAndPasswordIsCorrect(customer, id, pass);
			logger.debug(msg2);
			logger.info("END: Login process");
			return msg2;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("User id doesn't exist");
			logger.info("END: Login process");
			return "User id doesn't exist";
		}
	}

	@PutMapping("/update/{userId}")
	public String updateAccountDetails(@PathVariable(value = "userId") int userId,
			@RequestBody Customer updatedCustomer) {
		logger.info("START: Process of updating account details");
		try {
			Customer oldcustomer = custRepo.findById(userId).orElse(null);
			String m = service.updateAccount(updatedCustomer, oldcustomer);
			custRepo.save(updatedCustomer);
			logger.info("END: Process of updating account details");
			return m;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("User id " + userId + " doesn't exist");
			logger.info("END: Process of updating account details");
			return "User id " + userId + " doesn't exist";
		}
	}

}
