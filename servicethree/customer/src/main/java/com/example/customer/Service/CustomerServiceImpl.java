package com.example.customer.Service;

import com.example.customer.Entity.Customer;
import com.example.customer.Model.Account;
import com.example.customer.Model.AccountType;
import com.example.customer.Model.RequiredResponse;
import com.example.customer.Repo.CustomerRepository;
import com.example.customer.exception.CustomerAlredyExistsException;
import com.example.customer.exception.CustomerNotActiveException;
import com.example.customer.exception.CustomerNotFoundException;
import com.example.customer.fiegn.AccountFeignClient;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepo;

    @Autowired
    AccountFeignClient accountFeignClient;

    @Override
    public List<Customer> getCustomer() {
        return customerRepo.findAll();
    }

    @Override
    public RequiredResponse addCustomer(Customer customer) {

        if (customerRepo.findByCustomerId(customer.getCustomerId()).isPresent()) {
            throw new CustomerAlredyExistsException("Please check customer id");
        } else {
            RequiredResponse requiredResponse = new RequiredResponse();
            Customer customer1 = customerRepo.save(customer);
            Account account = new Account(customer1.getCustomerId(), AccountType.current, customer1.getCustomerFirstName() + "-Account", new Date(), 2000.0);

            Account savedAccount = accountFeignClient.addAccount(account).getBody();


            requiredResponse.setCustomer_model(customer1);
            List<Account> accounts = Arrays.asList(savedAccount);
            requiredResponse.setAccount_models(accounts);
            return requiredResponse;
        }

    }


    public Optional<Customer> findById(Integer id) {
        Optional<Customer> customer = customerRepo.findByCustomerId(id);
        if (!customer.isPresent()) {
            throw new CustomerNotFoundException("Please check customer id");
        }
        if (!customer.get().getIsActive()) {
            throw new CustomerNotActiveException("Please check customer id");
        }

        return customer;
    }
@Override
   public RequiredResponse findByCustomerId(Integer id){
       Optional<Customer> selectedCustomer = findById(id);
       RequiredResponse car = new RequiredResponse();
       try {
           ResponseEntity<List<Account>> accountResponse = accountFeignClient.getAccountsById(id);
           List<Account> retrievedAccounts = accountResponse.getBody();

           car.setAccount_models(retrievedAccounts);

           if (selectedCustomer.isPresent()) {
               car.setCustomer_model(selectedCustomer.get());
           } else {
               log.error("customer not found for id " + id);
               throw new CustomerNotFoundException("customer not found for the id " + id);
           }

           log.info("customer id " + id + " retrieved");
           return car;
       } catch (FeignException ex) {
           log.error(ex.getMessage());
           if (ex.status() == HttpStatus.NOT_FOUND.value()) {
               log.info("account service returned account not found");
               throw new CustomerNotFoundException("account not found for the customer");
           }
           throw ex;
       }

   catch (CustomerNotFoundException e) {
        log.error(e.getMessage());
        throw e;
    } catch (Exception e) {
        log.error(e.getMessage());
        return null;
    }
     }

}
