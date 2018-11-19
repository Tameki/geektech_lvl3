package com.geektech.astudy.presentation.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.geektech.astudy.AdvancedApp;
import com.geektech.astudy.injection.component.DaggerLoginComponent;
import com.geektech.astudy.injection.module.LoginModule;

import javax.inject.Inject;

/**
 * Created by askar on 11/19/18
 * with Android Studio
 */
public class LoginActivity extends AppCompatActivity {

    @Inject
    LoginContract.Presenter mPresenter = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LoginFragment fragment = LoginFragment.getInstance();

        getSupportFragmentManager()
                .beginTransaction()
                .add(android.R.id.content, fragment)
                .commit();

        DaggerLoginComponent.builder()
                .appComponent(((AdvancedApp) getApplicationContext()).component())
                .loginModule(new LoginModule(fragment))
                .build()
                .inject(fragment);
    }
}
