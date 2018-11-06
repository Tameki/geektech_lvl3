package com.geektech.architectureexample.data.user.local;

import com.geektech.architectureexample.data.user.UserBaseDataSource;
import com.geektech.architectureexample.data.user.UserDataSource;
import com.geektech.architectureexample.model.LoginEntity;

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

    //endregion


    @Override
    public void checkLogin(LoginEntity loginData, CheckLoginCallback callback) {
        callback.onSuccess(
                USERNAME.equals(loginData.name) &&
                        PASSWORD.equals(loginData.password)
        );
    }
}
