package com.example.Account.controller;

import com.example.Account.model.Account;
import com.example.Account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    AccountService accountService;

    @PostMapping("/add")
    public Account  addAccount(@RequestBody Account account){
        Account add=accountService.addAccount(account);

          return add;

    }

    @GetMapping("/view")
    public List<Account> getAccount(){
        List<Account> bookList =accountService.getAccount();

             return bookList;




    }

}
