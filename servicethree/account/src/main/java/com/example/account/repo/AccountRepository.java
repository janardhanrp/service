package com.example.account.repo;

import com.example.account.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface AccountRepository extends JpaRepository<Account,Integer> {
    List<Account> findAllByCustomerId(Integer id);
}
