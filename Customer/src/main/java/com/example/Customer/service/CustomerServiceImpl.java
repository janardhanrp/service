package com.example.Customer.service;

import com.example.Customer.model.Customer;
import com.example.Customer.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService{

@Autowired
CustomerRepository customerRepository;

    @Override
    public ResponseEntity<Customer> addCustomer(Customer customer) {
        Customer _customer = null;
        try {
            _customer = customerRepository.save(new Customer(customer.getCustId(), customer.getName(), customer.getAccountNumber(), customer.getPhoneNumber(), customer.getAccountType()));
            return new ResponseEntity<Customer>(_customer, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<Customer>(_customer, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
