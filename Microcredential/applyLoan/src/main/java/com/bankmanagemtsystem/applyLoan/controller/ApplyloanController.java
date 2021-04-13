package com.bankmanagemtsystem.applyLoan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bankmanagemtsystem.applyLoan.model.LoanDetails;
import com.bankmanagemtsystem.applyLoan.repository.LoanRepository;



@RestController
public class ApplyloanController {
	
	@Autowired
	private LoanRepository repo;
	
	@PostMapping("/applyLoan")
	public String saveUser(@RequestBody LoanDetails loandetails) {
			repo.save(loandetails);
			return "Loan details of customer saved Successfully";		
	}

	@GetMapping("/applyLoan")
	public List<LoanDetails> getAllUsers() {
		return repo.findAll();
	}
		
/*	@GetMapping("/applyLoan")
	public String registration(@ModelAttribute("loanInput") LoanDetails loanDetails) {
		return "loanDetails";
	}*/
	//Name, Username, Password, Address, State, Country, Email Address, PAN, Contact No, DOB, Account Type
}
