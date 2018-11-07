package com.geektech.astudy.domain.login;

import com.geektech.astudy.model.LoginEntity;
import com.geektech.core.callback.BaseCallback;

// Created by askar on 11/2/18.
public interface LoginUseCases {
    void checkLogin(LoginEntity loginEntity, UCCheckLoginCallback callback);

    abstract class UCCheckLoginCallback implements BaseCallback<Boolean> {
        @Override
        public void onFail(String message) {

        }
    }
}
