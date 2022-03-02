package com.example.customer.Repo;

import com.example.customer.Entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CustomerRepository extends MongoRepository<Customer,Integer> {
    Optional<Customer> findByCustomerId(Integer id);
}
