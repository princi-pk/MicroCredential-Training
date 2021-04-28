package com.bankmanagementsystem.loginRegistration.repository;

import org.springframework.data.couchbase.repository.CouchbaseRepository;

import com.bankmanagementsystem.loginRegistration.model.Customer;

public interface CustomerRepository extends CouchbaseRepository<Customer, Integer> {
}
