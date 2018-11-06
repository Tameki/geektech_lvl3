package com.geektech.architectureexample.domain;

import com.geektech.architectureexample.domain.login.LoginInteractor;
import com.geektech.architectureexample.domain.login.LoginUseCases;

// Created by askar on 11/6/18.
public class UseCaseProvider {
    public static LoginUseCases getLoginUseCase(){
        return new LoginInteractor();
    }
}
