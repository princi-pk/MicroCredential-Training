
package com.bankmanagemtsystem.applyLoan.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.stereotype.Component;

@Component
@Document
public class LoanDetails {
	
	@Id
	private int userId;
	private String password;

	private String loanType;
	private double loanAmount;
	private float interestRate;
	private int duration;

	public LoanDetails() {
		super();
	}

	public LoanDetails(int userId, String password, String loanType, double loanAmount, float interestRate,
			int duration) {
		super();
		this.userId = userId;
		this.password = password;
		this.loanType = loanType;
		this.loanAmount = loanAmount;
		this.interestRate = interestRate;
		this.duration = duration;
	}

	public int getUserId() {
		return userId;
	}

	public String getPassword() {
		return password;
	}

	public String getLoanType() {
		return loanType;
	}

	public double getLoanAmount() {
		return loanAmount;
	}

	public float getInterestRate() {
		return interestRate;
	}

	public int getDuration() {
		return duration;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public void setInterestRate(float interestRate) {
		this.interestRate = interestRate;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "LoanDetails [userId=" + userId + ", password=" + password + ", loanType=" + loanType + ", loanAmount="
				+ loanAmount + ", interestRate=" + interestRate + ", duration=" + duration + "]";
	}

}
