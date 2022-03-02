package com.example.account.service;

import com.example.account.model.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService {
    public List<Account> getAllAccount();

    public Account addAccount(Account account);
    public Account findById(Integer id);

    List<Account> getAccountsById(Integer id);
}
