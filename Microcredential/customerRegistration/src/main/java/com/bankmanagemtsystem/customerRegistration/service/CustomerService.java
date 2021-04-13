package com.bankmanagemtsystem.customerRegistration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankmanagemtsystem.customerRegistration.model.Customer;
import com.bankmanagemtsystem.customerRegistration.model.UserLogin;
import com.bankmanagemtsystem.customerRegistration.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository custRepo;
	
	public boolean customerAlreadyRegistered(Customer customer) {
		boolean p=custRepo.findById(customer.getUserId()).isPresent();
		if(p) {
			System.out.println(customer.getUserId());
			return true;
		}
		return false;
	}
	
	public boolean userIdAndPasswordIsCorrect(UserLogin userLogin) {
		int id=userLogin.getUserId();
		String pass=userLogin.getPassword();
		List<Customer> listOfCustomers=custRepo.findAll();
		for(Customer c : listOfCustomers) {
			if(c.getUserId()==id && c.getPassword().equals(pass)) {
				return true;
			}
		}
		return false;
	}
}
