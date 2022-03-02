package com.example.customer.fiegn;


import com.example.customer.Model.Account;
import com.example.customer.config.CustomerRetryClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "Account", configuration = CustomerRetryClientConfig.class,fallbackFactory = HystrixFallBackFactory.class)
//@FeignClient(name = "ACCOUNT-SERVICE", fallbackFactory = HystrixFallBackFactory.class)
public interface AccountFeignClient {

//    @GetMapping(value = "/account/id/{id}")
//    Account getIds(@PathVariable Integer id);
    @GetMapping(value = "/account/accounts/{id}")
   // public ResponseEntity<List<Account>> getAccountsById(@PathVariable("id") Integer id);
  //  @GetMapping("/accounts/{id}")
    public ResponseEntity<List<Account>> getAccountsById(@PathVariable("id") Integer id);
    @PostMapping(value="/account/add")
    ResponseEntity<Account> addAccount(@RequestBody Account account);
}
