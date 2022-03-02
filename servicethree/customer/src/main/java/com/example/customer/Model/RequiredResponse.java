package com.example.customer.Model;

import com.example.customer.Entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequiredResponse {
    private List<Account> account_models;
    private Customer customer_model;


}
