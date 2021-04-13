package com.bankmanagemtsystem.customerRegistration.repository;

import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

import com.bankmanagemtsystem.customerRegistration.model.Customer;


public interface CustomerRepository extends CouchbaseRepository<Customer, Integer>{
}
