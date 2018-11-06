package com.geektech.architectureexample.domain.login;

import com.geektech.architectureexample.model.LoginEntity;

// Created by askar on 11/2/18.
public interface LoginUseCases {
    Boolean checkLogin(LoginEntity log);
}
