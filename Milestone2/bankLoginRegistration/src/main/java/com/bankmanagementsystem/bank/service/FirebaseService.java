package com.bankmanagementsystem.bank.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;

import com.bankmanagementsystem.bank.model.Customer;
import com.bankmanagementsystem.bank.model.UserLogin;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;

@Service
public class FirebaseService {

	private static final String COLLECTION_NAME = "bankManagement";

	public String saveUserDetails(Customer customer) throws ExecutionException, InterruptedException {
		Firestore dbFirestore = FirestoreClient.getFirestore();

		DocumentReference documentReference = dbFirestore.collection(COLLECTION_NAME).document(customer.getUserId());
		ApiFuture<DocumentSnapshot> future = documentReference.get();
		DocumentSnapshot document = future.get();

		if (document.exists()) {
			return "Customer already exists with user id: " + customer.getUserId();
		} else {
			ApiFuture<WriteResult> collectionApiFuture = dbFirestore.collection(COLLECTION_NAME)
					.document(customer.getUserId()).set(customer);

			return "Your account is registered successfully with user id: " + customer.getUserId();
		}
	}

	
	public Customer getCustomerDetailsByUserId(String userId) throws InterruptedException, ExecutionException {
		Firestore dbFirestore = FirestoreClient.getFirestore();
		DocumentReference documentReference = dbFirestore.collection(COLLECTION_NAME).document(userId);
		ApiFuture<DocumentSnapshot> future = documentReference.get();
		DocumentSnapshot document = future.get();

		Customer customer = null;
		if (document.exists()) {
			customer = document.toObject(Customer.class);
			return customer;
		} else {
			return null;
		}
	}

	
	public List<Customer> getAllCustomerDetails() throws InterruptedException, ExecutionException {
		Firestore dbFirestore = FirestoreClient.getFirestore();

		Iterable<DocumentReference> documentReference = dbFirestore.collection(COLLECTION_NAME).listDocuments();
		Iterator<DocumentReference> iterator = documentReference.iterator();

		List<Customer> customerList = new ArrayList<>();
		Customer customer = null;

		while (iterator.hasNext()) {
			DocumentReference dr1 = iterator.next();
			ApiFuture<DocumentSnapshot> future = dr1.get();
			DocumentSnapshot document = future.get();

			customer = document.toObject(Customer.class);
			customerList.add(customer);
		}
		return customerList;
	}

	
	public String updateCustomer(Customer customer, String userId) throws ExecutionException, InterruptedException {
		Firestore dbFirestore = FirestoreClient.getFirestore();

		DocumentReference documentReference = dbFirestore.collection(COLLECTION_NAME).document(userId);
		ApiFuture<DocumentSnapshot> future = documentReference.get();
		DocumentSnapshot document = future.get();

		if (document.exists()) {
			if(!userId.equals(customer.getUserId())) {
				return "User id doesn't match";
			}else {
			ApiFuture<WriteResult> collectionApiFuture = dbFirestore.collection(COLLECTION_NAME)
					.document(customer.getUserId()).set(customer);
			return "Account details updated successfully for customer with user id: " + customer.getUserId();
			}
		} else {
			return "No user exists with entered user id";
		}
	}

	
	public String loginCustomer(Customer customer, UserLogin userlogin) throws InterruptedException, ExecutionException {
		String id = userlogin.getUserId();
		Firestore dbFirestore = FirestoreClient.getFirestore();

		DocumentReference documentReference = dbFirestore.collection(COLLECTION_NAME).document(id);
		ApiFuture<DocumentSnapshot> future = documentReference.get();
		DocumentSnapshot document = future.get();
		if (document.exists()) {
			customer = document.toObject(Customer.class);
			if(customer.getPassword().equals(userlogin.getPassword())){
				return "Login successful";
			}else {
				return "Incorrect password";
			}
		}else {
			return "User id entered does not exist";
		}
	}
}
