package com.example.classes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Admin extends Account {
    
    @JsonCreator
    Admin(
        @JsonProperty("name") String name,
        @JsonProperty("username") String username,
        @JsonProperty("password") String password) {
        super(name, username, password);
    }
}
