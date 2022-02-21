package com.example.customer.Service;

import com.example.customer.Entity.Customer;
import com.example.customer.Repo.CustomerRepository;
import com.example.customer.exception.CustomerNotActiveException;
import com.example.customer.exception.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerRepository customerRepo;

    @Override
    public List<Customer> getCustomer() {
        return customerRepo.findAll();
    }

    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepo.save(customer);
    }

    @Override
    public Optional<Customer> findById(Integer id)  {
        Optional<Customer> customer= customerRepo.findById(id);
        if(!customer.isPresent()) {
            throw new CustomerNotFoundException("Please check customer id");
        }
        if(customer.get().getIsActive()!=false) {
            throw new CustomerNotActiveException("Please check customer id");
        }

        return customer;
    }
}
