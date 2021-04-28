package com.bankmanagemtsystem.applyLoan.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankmanagemtsystem.applyLoan.feignClient.CustomerRegistrationClient;
import com.bankmanagemtsystem.applyLoan.model.LoanDetails;
import com.bankmanagemtsystem.applyLoan.model.UserLogin;
import com.bankmanagemtsystem.applyLoan.repository.LoanRepository;

@Service
public class LoanService {

	@Autowired
	private CustomerRegistrationClient client;

	@Autowired
	private LoanRepository repo;

	private static Logger logger = LoggerFactory.getLogger(LoanService.class);

	public String loanservice(LoanDetails loandetails, UserLogin user) {
		logger.info("START");
		user.setUserId(loandetails.getUserId());
		user.setPassword(loandetails.getPassword());
		String str = client.loginExistingUser(user);
		if (str.equalsIgnoreCase("Login successful")) {
			repo.save(loandetails);
			logger.info("END");
			return "Loan details of customer saved successfully";
		}
		logger.info("END");
		return "User not found";
	}
}
