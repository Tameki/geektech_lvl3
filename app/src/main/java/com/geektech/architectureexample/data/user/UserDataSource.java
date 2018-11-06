package com.geektech.architectureexample.data.user;

import com.geektech.architectureexample.model.LoginEntity;
import com.geektech.core.callback.BaseCallback;

// Created by askar on 11/2/18.
public interface UserDataSource {
    void checkLogin(LoginEntity loginData, CheckLoginCallback callback);

    abstract class CheckLoginCallback implements BaseCallback<Boolean>{
        @Override
        public void onFail(String message) {

        }
    }
}
