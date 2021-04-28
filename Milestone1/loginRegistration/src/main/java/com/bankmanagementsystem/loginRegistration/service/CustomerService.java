package com.bankmanagementsystem.loginRegistration.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankmanagementsystem.loginRegistration.model.Customer;
import com.bankmanagementsystem.loginRegistration.repository.CustomerRepository;

@Service
public class CustomerService {

	private static Logger logger = LoggerFactory.getLogger(CustomerService.class);

	@Autowired
	CustomerRepository custRepo;

	public String customerAlreadyRegistered(Customer customer) {
		logger.info("START");
		boolean p = custRepo.findById(customer.getUserId()).isPresent();
		if (p) {
			logger.info("END");
			return customer.getName() + ", your account already exists";
		}
		custRepo.save(customer);
		logger.info("END");
		return customer.getName() + ", your account is registered successfully";
	}

	public String userIdAndPasswordIsCorrect(Customer customer, int id, String pass) {
		logger.info("START");
		if (customer.getUserId() == id && customer.getPassword().equals(pass)) {
			logger.info("END");
			return "Login successful";
		} else {
			logger.info("END");
			return "Incorrect password";
		}
	}

	public String updateAccount(Customer newcustomer, Customer oldcustomer) {
		logger.info("START");
		if (oldcustomer.getUserId() == newcustomer.getUserId()) {
			oldcustomer.setName(newcustomer.getName());
			oldcustomer.setEmail(newcustomer.getEmail());
			oldcustomer.setAddress(newcustomer.getAddress());
			oldcustomer.setContactNumber(newcustomer.getContactNumber());
			oldcustomer.setCountry(newcustomer.getCountry());
			oldcustomer.setPanNumber(newcustomer.getPanNumber());
			oldcustomer.setPassword(newcustomer.getPassword());
			oldcustomer.setState(newcustomer.getState());
			oldcustomer.setTypeOfAccount(newcustomer.getTypeOfAccount());
			logger.info("END");
			return newcustomer.getName() + ", your account details are updated successfully";
		} else {
			logger.warn("User id doesn't match");
			return "User id doesn't match";
		}
	}

}
