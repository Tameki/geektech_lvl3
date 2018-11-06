package com.geektech.architectureexample.domain.login;

import com.geektech.architectureexample.model.LoginEntity;

// Created by askar on 11/2/18.
public class LoginInteractor implements LoginUseCases {
    @Override
    public Boolean checkLogin(LoginEntity log) {
        return false;
    }
}
