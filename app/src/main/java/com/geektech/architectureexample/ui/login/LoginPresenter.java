package com.geektech.architectureexample.ui.login;

import com.geektech.architectureexample.data.user.UserServiceContract;
import com.geektech.architectureexample.model.LoginEntity;

// Created by askar on 11/2/18.
public class LoginPresenter implements LoginContract.Presenter{
    private LoginContract.View mView = null;
    private UserServiceContract mUserService;

    public LoginPresenter(UserServiceContract userService){
        mUserService = userService;
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
        if (mView != null && mUserService != null) {
            if (mUserService.checkLogin(new LoginEntity(name, password, ""))){
                mView.onLoginSuccess();
                mView.finishView();
            } else {
                mView.onLoginFailure("Name or password is incorrect!");
            }
        }
    }
}
