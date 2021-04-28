package com.bankmanagemtsystem.applyLoan.repository;

import org.springframework.data.couchbase.repository.CouchbaseRepository;

import com.bankmanagemtsystem.applyLoan.model.LoanDetails;



public interface LoanRepository extends CouchbaseRepository<LoanDetails, Integer>{
}
