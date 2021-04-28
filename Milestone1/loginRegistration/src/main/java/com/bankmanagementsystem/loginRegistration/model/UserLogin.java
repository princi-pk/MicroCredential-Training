package com.bankmanagementsystem.loginRegistration.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.stereotype.Component;

@Document
@Component
public class UserLogin {

	@Id
	private int userId;
	private String password;

	public UserLogin() {
		super();
	}

	public UserLogin(int userId, String password) {
		super();
		this.userId = userId;
		this.password = password;
	}

	public int getUserId() {
		return userId;
	}

	public String getPassword() {
		return password;
	}

	public void setUserId(int userId) {
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
