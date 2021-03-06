package com.geektech.astudy.presentation.login;

import com.geektech.core.mvp.BaseMVPContract;

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
