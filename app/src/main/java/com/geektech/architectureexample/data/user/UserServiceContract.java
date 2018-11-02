package com.geektech.architectureexample.data.user;

import com.geektech.architectureexample.model.LoginEntity;

// Created by askar on 11/2/18.
public interface UserServiceContract {
    Boolean checkLogin(LoginEntity loginData);
}
