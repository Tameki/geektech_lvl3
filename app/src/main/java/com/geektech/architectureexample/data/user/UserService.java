package com.geektech.architectureexample.data.user;

import com.geektech.architectureexample.model.LoginEntity;

// Created by askar on 11/2/18.
public class UserService implements UserServiceContract {
    private String USERNAME = "Tameki";
    private String PASSWORD = "123456789";

    @Override
    public Boolean checkLogin(LoginEntity loginData) {
        return loginData.name.equals(USERNAME)
                && loginData.password.equals(PASSWORD);
    }
}
