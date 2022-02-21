package com.example.customer.Entity;

import com.example.customer.Model.Account;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.Set;
@Document(collection = "customer_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    enum accountType {
        current,
        cash,
        instant,
        fixed,
    }
     enum customerType{
        individual,
         joint,
     }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @NotBlank(message = "Name cannot be blank")
    private String customerFirstName;
    private String customerMiddleName;
    private String customerLastName;
    private String customerCity;
    private Date createdDate;
    private Boolean isActive;
    @Enumerated(EnumType.STRING)
    private accountType accountType;
    @Enumerated(EnumType.STRING)
    private customerType customerType;
    @OneToMany(mappedBy = "accounts", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Account> accounts;
}
