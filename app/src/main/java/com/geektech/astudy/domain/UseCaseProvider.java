package com.geektech.astudy.domain;

import com.geektech.astudy.data.RepositoryProvider;
import com.geektech.astudy.domain.login.LoginInteractor;
import com.geektech.astudy.domain.login.LoginUseCases;

// Created by askar on 11/6/18.
public class UseCaseProvider {
    public static LoginUseCases getLoginUseCase(){
        return new LoginInteractor(
                RepositoryProvider.getUserRepository()
        );
    }
}
