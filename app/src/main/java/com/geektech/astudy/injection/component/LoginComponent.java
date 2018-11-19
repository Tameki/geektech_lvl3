package com.geektech.astudy.injection.component;

import com.geektech.astudy.injection.module.LoginModule;
import com.geektech.astudy.injection.scopes.ActivityScope;
import com.geektech.astudy.presentation.login.LoginFragment;

import dagger.Component;

/**
 * Created by askar on 11/19/18
 * with Android Studio
 */
@ActivityScope
@Component(dependencies = { AppComponent.class }, modules = {LoginModule.class})
public interface LoginComponent {
    void inject(LoginFragment fragment);
}
