package com.example.customer.controller;

import com.example.customer.Entity.Customer;
import com.example.customer.Model.Account;
import com.example.customer.Model.RequiredResponse;
import com.example.customer.Service.CustomerServiceImpl;
import com.example.customer.exception.CustomerNotFoundException;
import com.example.customer.fiegn.AccountFeignClient;
import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/customer")
public class CustomerController {

  // private static Logger log = (Logger) LoggerFactory.getLogger(CustomerController.class);
    @Autowired
    private CustomerServiceImpl customerServices;

//    @Autowired
//    private RestTemplate restTemplate;

//    @Autowired
//    AccountFeignClient accountFeignClient;

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAllCustomer(){
        List<Customer> list=customerServices.getCustomer();

        return new ResponseEntity<List<Customer>>(list, HttpStatus.OK);
    }

    @PostMapping("/add")
    public  ResponseEntity<RequiredResponse> addCustomer(@Valid @RequestBody Customer customer){
        RequiredResponse  requiredResponse=customerServices.addCustomer(customer);

        return new ResponseEntity<RequiredResponse>(requiredResponse,HttpStatus.CREATED);

    }
    @GetMapping("/id/accountids/{id}")
    public ResponseEntity<RequiredResponse> getAccountsById(@PathVariable("id") Integer id){

        return new ResponseEntity<RequiredResponse>(customerServices.findByCustomerId(id),HttpStatus.OK);

    }



    @GetMapping("/id/{id}")
    public ResponseEntity<Customer> getById(@PathVariable("id") Integer id){
        Optional<Customer> one= customerServices.findById(id);
        return  new ResponseEntity<Customer>(one.get(),HttpStatus.OK);
    }
    @GetMapping("/id/ids/{id}")
    public ResponseEntity<RequiredResponse> getAllDataBasedOnCentreId(@PathVariable("id") Integer id){
        RequiredResponse requiredResponse=new RequiredResponse();
//        Logger log;
//        log.info("In get resource");

        Optional<Customer> cus= customerServices.findById(id); //mongo
        requiredResponse.setCustomer_model(cus.get());

        // Account accounts=  restTemplate.getForObject("http://ACCOUNT-SERVICE/account/id/"+id, Account.class);
        //  Account accounts=  restTemplate.getForObject("http://127.0.0.1:8082/account/id/"+id, Account.class);
       // List<Account> accounts =accountFeignClient.getAccountsById(id).getBody();

    //    requiredResponse.setAccount_models(accounts);
        return new ResponseEntity<RequiredResponse>(requiredResponse, HttpStatus.OK);
    }



}
