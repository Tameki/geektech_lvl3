package com.geektech.architectureexample.ui.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.geektech.architectureexample.data.ServiceProvider;

// Created by askar on 11/2/18.
public class LoginActivity extends AppCompatActivity {

    private LoginContract.Presenter mPresenter = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LoginFragment fragment = LoginFragment.getInstance();

        mPresenter = new LoginPresenter(
                ServiceProvider.getUserService()
        );

        mPresenter.attachView(fragment);

        getSupportFragmentManager()
                .beginTransaction()
                .add(android.R.id.content, fragment)
                .commit();
    }
}
