package com.bankmanagemtsystem.applyLoan.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bankmanagemtsystem.applyLoan.model.LoanDetails;
import com.bankmanagemtsystem.applyLoan.model.UserLogin;
import com.bankmanagemtsystem.applyLoan.repository.LoanRepository;
import com.bankmanagemtsystem.applyLoan.service.LoanService;

@RestController
public class ApplyloanController {

	@Autowired
	private LoanRepository repo;

	@Autowired
	private LoanService service;

	private static Logger logger = LoggerFactory.getLogger(ApplyloanController.class);

	@PostMapping("/applyLoan")
	public String applyLoanForRegisteredUsers(@RequestBody LoanDetails loandetails, UserLogin user) {
		logger.info("START: Loan application process");
		String msg1 = service.loanservice(loandetails, user);
		logger.debug(msg1);
		logger.info("END: Loan application process");
		return msg1;
	}

	@GetMapping("/applyLoan")
	public List<LoanDetails> getLoanDetailsOfAllUsers() {
		logger.info("START: Process of displaying loan details of users");
		logger.debug("Loan details of all users: " + repo.findAll());
		logger.info("END: Process of displaying loan details of users");
		return repo.findAll();
	}

}
