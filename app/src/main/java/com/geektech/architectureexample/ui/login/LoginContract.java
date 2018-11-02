package com.geektech.architectureexample.ui.login;

import com.geektech.core.BaseMVPContract;

// Created by askar on 11/2/18.
public interface LoginContract {
    interface View extends BaseMVPContract.View<Presenter> {
        void onLoginSuccess();

        void onLoginFailure(String message);
    }

    interface Presenter extends BaseMVPContract.Presenter<View>{
        void onLoginClick(String name, String password);
    }
}
