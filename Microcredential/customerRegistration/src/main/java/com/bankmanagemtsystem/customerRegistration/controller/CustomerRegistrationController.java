
package com.bankmanagemtsystem.customerRegistration.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bankmanagemtsystem.customerRegistration.model.Customer;
import com.bankmanagemtsystem.customerRegistration.model.UserLogin;
import com.bankmanagemtsystem.customerRegistration.repository.CustomerRepository;
import com.bankmanagemtsystem.customerRegistration.service.CustomerService;

@RestController
public class CustomerRegistrationController {
	
	@Autowired
	private CustomerRepository repo;

	@Autowired
	private CustomerService service;
	
	@PostMapping("/login")
	public String loginExistingCustomer(@RequestBody UserLogin user) {
		boolean userExists = service.userIdAndPasswordIsCorrect(user);
		if(userExists) {
			return "Login successful";
		}
		else {
			return "Incorrect password";
		}
	}
	
	@PostMapping("/register")
	public String saveUser(@RequestBody Customer customer) {
		boolean flag=service.customerAlreadyRegistered(customer);
		if(flag!=true) {
			repo.save(customer);
			return "User Saved Successfully";
		}
		else{
			return "User already exists";
		}
	}

	@GetMapping("/register")
	public List<Customer> getAllUsers() {
		return repo.findAll();
	}
	
	@PutMapping("/update/{userId}")
	public String updateAccountDetails(@PathVariable(value="userId") int userId, @RequestBody Customer updatedCustomer) {
		Boolean isPresent=repo.findById(userId).isPresent();
		if(isPresent) {
			service.updateAccount(updatedCustomer, userId);
			repo.save(updatedCustomer);
			return "Account details updated";
		}
		return "User not found";
	}
	
	
/*	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}
	
	@GetMapping("/registration")
	public String registration(@ModelAttribute("customerInput") Customer customer) {
		return "customerDetails";
	}*/
	//Name, Username, Password, Address, State, Country, Email Address, PAN, Contact No, DOB, Account Type
}
