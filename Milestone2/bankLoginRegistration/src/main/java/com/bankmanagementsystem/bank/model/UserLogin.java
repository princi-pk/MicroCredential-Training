package com.bankmanagementsystem.bank.model;

public class UserLogin {

	
	private String userId;
	private String password;

	public UserLogin() {
		super();
	}

	public UserLogin(String userId, String password) {
		super();
		this.userId = userId;
		this.password = password;
	}

	public String getUserId() {
		return userId;
	}

	public String getPassword() {
		return password;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserLogin [userId=" + userId + ", password=" + password + "]";
	}

}
