package com.example.customer.Model;

import com.example.customer.Entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequiredResponse {
    private Account account_model;
    private Customer customer_model;
}
