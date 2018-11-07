package com.geektech.astudy.data.user;

import com.geektech.astudy.model.LoginEntity;

// Created by askar on 11/6/18.
public abstract class UserBaseDataSource implements UserDataSource {
    @Override
    public void checkLogin(LoginEntity loginData, DSCheckLoginCallback callback) {

    }

    @Override
    public LoginEntity getLoginData() {
        return null;
    }
}
