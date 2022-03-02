package com.example.account.controller;

import com.example.account.execption.AccountNotFoundException;
import com.example.account.model.Account;
import com.example.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountServ;
    @PostMapping("/add")
    public ResponseEntity<Account> addAccount(@RequestBody Account account){
        Account account1=  accountServ.addAccount(account);
        return  new ResponseEntity<Account>(account1, HttpStatus.CREATED);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Account> getById(@PathVariable("id") Integer id){
        Account one= accountServ.findById(id);
//        log.info("account by Id: {}", id);
        return  new ResponseEntity<Account>(one,HttpStatus.OK);
    }
    @GetMapping("/accounts/{id}")
    public ResponseEntity<List<Account>> getAccountsById(@PathVariable("id") Integer id) {
        try {
          //  log.info("retrieving accounts by id - " + id);
            List<Account> allAccounts = accountServ.getAccountsById(id);

            if(allAccounts.isEmpty())
            {
           //     log.error("no account found for id - " + id);
                throw new AccountNotFoundException("no account found for id - " + id);
            }
          //  log.info("accounts retrieved for id - " + id);
            return new ResponseEntity<>(allAccounts, HttpStatus.OK);
        } catch (AccountNotFoundException e) {
          //  log.error(e.getMessage());
            throw e;
        } catch (Exception e) {
         //   log.error(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
