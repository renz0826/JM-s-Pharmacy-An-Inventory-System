package com.example.classes;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Customer extends Account {
    private List<Medicine> medicines;
    private double funds;
    
    @JsonCreator
    Customer(
        @JsonProperty("name") String name,
        @JsonProperty("username") String username,
        @JsonProperty("password") String password,
        @JsonProperty("medicines") List<Medicine> medicines,
        @JsonProperty("funds") double funds
    ) {
        super(name, username, password);
        this.medicines = medicines;
        this.funds = funds;
    }
}