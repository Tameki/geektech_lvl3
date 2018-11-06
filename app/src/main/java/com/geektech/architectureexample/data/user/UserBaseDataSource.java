package com.geektech.architectureexample.data.user;

import com.geektech.architectureexample.model.LoginEntity;

// Created by askar on 11/6/18.
public abstract class UserBaseDataSource implements UserDataSource {
    @Override
    public void checkLogin(LoginEntity loginData, CheckLoginCallback callback) {

    }
}
