package com.bankmanagemtsystem.customerRegistration.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankmanagemtsystem.customerRegistration.repository.CustomerRepository;
import com.bankmanagemtsystem.customerRegistration.model.Customer;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository custRepo;
	
	public boolean customerAlreadyRegistered(Customer customer) {
		Optional<Customer> cust=custRepo.findById(customer.getUserId());
		if(cust!=null) {
			return true;
		}
		return false;
	}
}
