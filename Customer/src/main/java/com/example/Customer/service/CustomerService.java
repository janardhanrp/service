package com.example.Customer.service;

import com.example.Customer.model.Customer;
import org.springframework.http.ResponseEntity;

public interface CustomerService {






    ResponseEntity<Customer> addCustomer(Customer customer);
       // return customerRepository.save(new Customer(customer.getCustId(),customer.getName(),customer.getAccountNumber(),customer.getPhoneNumber(), customer.getAccountType());



//
//    @Override
//    public Optional<Book> getBookByName(String name) {
//        return bookRepo.findByName(name);
//    }
//
//
//
//    @Override
//    public Optional<Book> getBookByAuthor(String name) {
//        return bookRepo.findByAuthor(name);
//    }
//
//
//
//    @Override
//    public List<Book> getAllBooks() {
//        return bookRepo.findAll();
//    }
}
