package com.example.customer.Repo;

import com.example.customer.Entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer,Integer> {
}
