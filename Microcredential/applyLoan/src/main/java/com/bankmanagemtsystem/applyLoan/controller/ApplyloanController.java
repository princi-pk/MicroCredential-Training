package com.bankmanagemtsystem.applyLoan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.bankmanagemtsystem.applyLoan.model.LoanDetails;



@Controller
public class ApplyloanController {
	
		
	@GetMapping("/applyLoan")
	public String registration(@ModelAttribute("loanInput") LoanDetails loanDetails) {
		return "loanDetails";
	}
	//Name, Username, Password, Address, State, Country, Email Address, PAN, Contact No, DOB, Account Type
}
