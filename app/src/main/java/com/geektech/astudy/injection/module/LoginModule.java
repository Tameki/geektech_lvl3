package com.geektech.astudy.injection.module;

import com.geektech.astudy.domain.UseCaseProvider;
import com.geektech.astudy.domain.login.LoginUseCases;
import com.geektech.astudy.injection.scopes.ActivityScope;
import com.geektech.astudy.presentation.login.LoginContract;

import dagger.Module;
import dagger.Provides;

/**
 * Created by askar on 11/19/18
 * with Android Studio
 */
@Module
public class LoginModule {
    private LoginContract.View mView;
    public LoginModule(LoginContract.View view) {
        mView = view;
    }

    @ActivityScope
    @Provides
    public LoginContract.View provideLoginView() {
        return mView;
    }

    @ActivityScope
    @Provides
    public LoginUseCases provideLoginUseCase() {
        return UseCaseProvider.getLoginUseCase();
    }
}
