package com.example.customer.Model;

import com.example.customer.Entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "account_details")
public class Account {


    private int accountId;

    private  int customerId;

    private AccountType accountType;

    private String accountName;
    private Date createdDate;

    private Double accountBalance;
    public Account(int customerId, AccountType accountType, String accountName, Date createdDate, Double accountBalance) {
        this.customerId = customerId;
        this.accountType = accountType;
        this.accountName = accountName;
        this.createdDate = createdDate;
        this.accountBalance = accountBalance;
    }
}
