package com.example.customer.Service;

import com.example.customer.Entity.Customer;
import com.example.customer.exception.CustomerNotActiveException;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    public List<Customer> getCustomer();

    public Customer addCustomer(Customer customer);



    Optional<Customer> findById(Integer id) throws CustomerNotActiveException;

}
