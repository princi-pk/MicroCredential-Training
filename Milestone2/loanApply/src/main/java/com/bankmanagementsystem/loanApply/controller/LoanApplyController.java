package com.bankmanagementsystem.loanApply.controller;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bankmanagementsystem.loanApply.model.LoanDetails;
import com.bankmanagementsystem.loanApply.service.FirebaseService;

@RestController
public class LoanApplyController {

	@Autowired
	private FirebaseService service;

	private static Logger logger = LoggerFactory.getLogger(LoanApplyController.class);

	@PostMapping("/applyLoan")
	public String applyLoanForRegisteredUsers(@RequestBody LoanDetails loandetails)
			throws ExecutionException, InterruptedException {
		logger.info("START: Loan application process");
		String msg1 = service.saveLoanDetails(loandetails);
		logger.debug(msg1);
		logger.info("END: Loan application process");
		return msg1;
	}

	@GetMapping("/applyLoan")
	public List<LoanDetails> getLoanDetailsOfAllUsers() throws InterruptedException, ExecutionException {
		logger.info("START: Process of displaying loan details of users");
		logger.debug("Loan details of all users: " + service.getAllLoanDetails());
		logger.info("END: Process of displaying loan details of users");
		return service.getAllLoanDetails();
	}

}
