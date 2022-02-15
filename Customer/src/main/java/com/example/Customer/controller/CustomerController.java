package com.example.Customer.controller;

import com.example.Customer.model.Customer;
import com.example.Customer.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    RestTemplate restTemplate;


    @PostMapping("/createCustomer")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        try {
            Customer _customer = customerRepository.save(new Customer(customer.getCustId(), customer.getName(), customer.getAccountNumber(), customer.getPhoneNumber(), customer.getAccountType()));

            return new ResponseEntity<Customer>(_customer, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<Customer>((Customer) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        }
        @GetMapping("/getAccounts")
        public String getAccount(){
            return restTemplate.exchange("http://Account/account/view",
                    HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
                    }).getBody();
        }

}
