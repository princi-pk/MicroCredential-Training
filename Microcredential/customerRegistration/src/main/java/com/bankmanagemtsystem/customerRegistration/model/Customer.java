package com.bankmanagemtsystem.customerRegistration.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;
import org.springframework.stereotype.Component;


@Component
@Document
public class Customer {
	//Name, Username, Password, Address, State, Country, Email Address, PAN, Contact No, DOB, Account Type
	@Id
	private int userId;
	
	private String name;
	private String username;
	private String password;
	private String address;
	private String country;
	private String state;
	private String email;
	private String panNumber;
	private String contactNumber;
	private String typeOfAccount;
	
	public Customer() {
		super();
	}

	public Customer(int userId, String name, String username, String password, String address, String country,
			String state, String email, String panNumber, String contactNumber, String typeOfAccount) {
		super();
		this.userId = userId;
		this.name = name;
		this.username = username;
		this.password = password;
		this.address = address;
		this.country = country;
		this.state = state;
		this.email = email;
		this.panNumber = panNumber;
		this.contactNumber = contactNumber;
		this.typeOfAccount = typeOfAccount;
	}

	public int getUserId() {
		return userId;
	}

	public String getName() {
		return name;
	}

	public String getUsername() {
		return username;
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

	public String getContactNumber() {
		return contactNumber;
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

	public void setUsername(String username) {
		this.username = username;
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

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public void setTypeOfAccount(String typeOfAccount) {
		this.typeOfAccount = typeOfAccount;
	}

	@Override
	public String toString() {
		return "Customer [userId=" + userId + ", name=" + name + ", username=" + username + ", password=" + password
				+ ", address=" + address + ", country=" + country + ", state=" + state + ", email=" + email
				+ ", panNumber=" + panNumber + ", contactNumber=" + contactNumber + ", typeOfAccount=" + typeOfAccount
				+ "]";
	}
	



}
