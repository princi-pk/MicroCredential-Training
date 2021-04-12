package com.bankmanagemtsystem.applyLoan.model;


import java.util.Date;

import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.stereotype.Component;

@Component
@Document
public class LoanDetails {
	//Name, Username, Password, Address, State, Country, Email Address, PAN, Contact No, DOB, Account Type
//Loan Type, Loan Amount, Date, Rate of Interest and Duration of Loan.
	private String loanType;
	private double loanAmount;
	private Date date;
	private float interestRate;
	private int duration;
	
	public String getLoanType() {
		return loanType;
	}
	public double getLoanAmount() {
		return loanAmount;
	}
	public Date getDate() {
		return date;
	}
	public float getInterestRate() {
		return interestRate;
	}
	public int getDuration() {
		return duration;
	}
	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}
	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public void setInterestRate(float interestRate) {
		this.interestRate = interestRate;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	@Override
	public String toString() {
		return "LoanDetails [loanType=" + loanType + ", loanAmount=" + loanAmount + ", date=" + date + ", interestRate="
				+ interestRate + ", duration=" + duration + "]";
	}
	
	


}
