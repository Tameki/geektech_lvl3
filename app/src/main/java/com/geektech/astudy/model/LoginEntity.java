package com.geektech.astudy.model;

// Created by askar on 11/2/18.
public class LoginEntity {
    public String name;
    public String password;
    public String country;

    public LoginEntity(
            String name,
            String password,
            String country
    ){
        this.name = name;
        this.password = password;
        this.country = country;
    }
}
