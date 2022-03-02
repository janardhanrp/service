package com.example.customer.Service;

import com.example.customer.Entity.Customer;
import com.example.customer.Model.Account;
import com.example.customer.Model.RequiredResponse;
import com.example.customer.exception.CustomerNotActiveException;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    public List<Customer> getCustomer();

    public RequiredResponse addCustomer(Customer customer);



    //Optional<Customer> findById(Integer id);
  //  List<Account> findAllByCustomerId(Integer id);
    public RequiredResponse findByCustomerId(Integer id);
}
