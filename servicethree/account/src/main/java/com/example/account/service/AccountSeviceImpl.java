package com.example.account.service;

import com.example.account.model.Account;
import com.example.account.repo.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountSeviceImpl implements AccountService{
    @Autowired
    private AccountRepository  repository;




        @Override
        public List<Account> getAllAccount() {
            return (List<Account>)repository.findAll();
        }


    @Override
    public Account addAccount(Account account) {
        return repository.save(account);
    }
    @Override
    public Account findById(Integer id) {
        return repository.findById(id).get();
    }
    public List<Account> getAccountsById(Integer id){
            return repository.findAllByCustomerId(id);
    }


}
