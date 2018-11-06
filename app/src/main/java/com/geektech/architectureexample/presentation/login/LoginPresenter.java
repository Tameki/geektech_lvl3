package com.geektech.architectureexample.presentation.login;

import android.util.Log;

import com.geektech.architectureexample.domain.login.LoginUseCases;
import com.geektech.architectureexample.model.LoginEntity;

// Created by askar on 11/2/18.
public class LoginPresenter implements LoginContract.Presenter{
    private LoginContract.View mView = null;
    private LoginUseCases mLoginUseCases;

    public LoginPresenter(LoginUseCases loginUseCases){
        mLoginUseCases = loginUseCases;
    }

    @Override
    public void attachView(LoginContract.View view) {
        mView = view;
        view.attachPresenter(this);
    }

    @Override
    public void detachView() {
        mView = null;
    }

    @Override
    public void onLoginClick(String name, String password) {
        if (mView != null && mLoginUseCases != null) {
            LoginEntity loginEntity = new LoginEntity(name, password, "");
            mLoginUseCases.checkLogin(loginEntity, new LoginUseCases.UCCheckLoginCallback(){
                @Override
                public void onSuccess(Boolean result) {
                    if (result){
                        mView.onLoginSuccess();
                        mView.finishView();
                    } else {
                        mView.onLoginFailure("Name or password is incorrect!");
                    }
                }

                @Override
                public void onFail(String message) {
                    Log.d("ololo", message);
                    super.onFail(message);
                }
            });
        }
    }
}
