package com.bankmanagementsystem.loanApply.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;

import com.bankmanagementsystem.loanApply.model.LoanDetails;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;

@Service
public class FirebaseService {

	private static final String COLLECTION_NAME = "loanApplication";

	public String saveLoanDetails(LoanDetails loan)
			throws ExecutionException, InterruptedException {

		Firestore dbFirestore = FirestoreClient.getFirestore();
		dbFirestore.collection(COLLECTION_NAME).document(loan.getUserId()).set(loan);
		return "Loan details saved successfully for user id: "+loan.getUserId();
	}

	public List<LoanDetails> getAllLoanDetails() throws InterruptedException, ExecutionException {
		Firestore dbFirestore = FirestoreClient.getFirestore();

		Iterable<DocumentReference> documentReference = dbFirestore.collection(COLLECTION_NAME).listDocuments();
		Iterator<DocumentReference> iterator = documentReference.iterator();

		List<LoanDetails> loanList = new ArrayList<>();
		LoanDetails loanDetails = null;

		while (iterator.hasNext()) {
			DocumentReference dr1 = iterator.next();
			ApiFuture<DocumentSnapshot> future = dr1.get();
			DocumentSnapshot document = future.get();

			loanDetails = document.toObject(LoanDetails.class);
			loanList.add(loanDetails);
		}
		return loanList;
	}
}
