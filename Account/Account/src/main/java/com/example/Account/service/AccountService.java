package com.example.Account.service;

import com.example.Account.model.Account;
import com.example.Account.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    private AccountRepository bookRepository;

    public List<Account> getAccount(){
        return bookRepository.findAll();
    }

    public Account addAccount(Account account){
        return  bookRepository.save(new Account(account.getAccId(),account.getAccountNumber(),account.getIfsc()));
    }

}
