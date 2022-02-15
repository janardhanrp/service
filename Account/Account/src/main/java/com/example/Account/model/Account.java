package com.example.Account.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.Id;

@Entity
@Table(name="account")
@Data
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String accId;
    private int accountNumber;
    private String ifsc;

    public Account(String accId, int accountNumber, String ifsc) {
        this.accId=accId;
        this.accountNumber=accountNumber;
        this.ifsc=ifsc;
    }


}
