package com.geektech.astudy.data.user.local;

import com.geektech.astudy.data.user.UserBaseDataSource;
import com.geektech.astudy.data.user.UserDataSource;
import com.geektech.astudy.model.LoginEntity;

// Created by askar on 11/6/18.
public class UserLocalDataSource extends UserBaseDataSource {
    private String USERNAME = "Tameki";
    private String PASSWORD = "123456789";

    //region Static

    private static UserLocalDataSource INSTANCE;

    public static UserDataSource getInstance(){
        if (INSTANCE == null) {
            INSTANCE = new UserLocalDataSource();
        }

        return INSTANCE;
    }

    //endregion


    //region Contract

    @Override
    public void checkLogin(LoginEntity loginData, DSCheckLoginCallback callback) {
        callback.onSuccess(
                USERNAME.equals(loginData.name) &&
                        PASSWORD.equals(loginData.password)
        );
    }

    @Override
    public LoginEntity getLoginData() {
        return new LoginEntity(USERNAME, PASSWORD, "");
    }

    //endregion
}
