package com.geektech.architectureexample.domain.login;

import com.geektech.architectureexample.data.user.UserDataSource;
import com.geektech.architectureexample.model.LoginEntity;

// Created by askar on 11/2/18.
public class LoginInteractor implements LoginUseCases {

    public LoginInteractor(UserDataSource userDataSource){
        this.mUserDataSource = userDataSource;
    }

    private UserDataSource mUserDataSource;

    @Override
    public void checkLogin(LoginEntity loginEntity, UCCheckLoginCallback callback) {
        LoginEntity currentUserData = mUserDataSource.getLoginData();

        if (currentUserData != null) {
            callback.onSuccess(
                    loginEntity.name.equals(currentUserData.name) &&
                    loginEntity.password.equals(currentUserData.password)
            );
        } else {
            callback.onFail("User data is empty!");
        }
    }
}
