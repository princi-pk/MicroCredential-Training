package com.bankmanagementsystem.loginRegistration.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.stereotype.Component;

@Component
@Document
public class Customer {

	@Id
	private int userId;
	private String name;
	private String password;
	private String address;
	private String country;
	private String state;
	private String email;
	private String panNumber;
	private long contactNumber;
	private Date dateOfBirth;
	private String typeOfAccount;

	public Customer() {
		super();
	}

	public Customer(int userId, String name, String password, String address, String country, String state,
			String email, String panNumber, long contactNumber, Date dateOfBirth, String typeOfAccount) {
		super();
		this.userId = userId;
		this.name = name;
		this.password = password;
		this.address = address;
		this.country = country;
		this.state = state;
		this.email = email;
		this.panNumber = panNumber;
		this.contactNumber = contactNumber;
		this.dateOfBirth = dateOfBirth;
		this.typeOfAccount = typeOfAccount;
	}

	public int getUserId() {
		return userId;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public String getAddress() {
		return address;
	}

	public String getCountry() {
		return country;
	}

	public String getState() {
		return state;
	}

	public String getEmail() {
		return email;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public long getContactNumber() {
		return contactNumber;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public String getTypeOfAccount() {
		return typeOfAccount;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public void setTypeOfAccount(String typeOfAccount) {
		this.typeOfAccount = typeOfAccount;
	}

	@Override
	public String toString() {
		return "Customer [userId=" + userId + ", name=" + name + ", password=" + password + ", address=" + address
				+ ", country=" + country + ", state=" + state + ", email=" + email + ", panNumber=" + panNumber
				+ ", contactNumber=" + contactNumber + ", dateOfBirth=" + dateOfBirth + ", typeOfAccount="
				+ typeOfAccount + "]";
	}

}
