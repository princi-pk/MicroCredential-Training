package com.bankmanagementsystem.bank.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

@Service
public class FirebaseInitialize {

	@PostConstruct
	public void initialize() {
		try {

			String path = "/Key/serviceAccountKey.json";
			InputStream in = this.getClass().getResourceAsStream(path);
			FirebaseOptions options = new FirebaseOptions.Builder().setCredentials(GoogleCredentials.fromStream(in))
					.build();
			FirebaseApp.initializeApp(options);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
