package com.geektech.architectureexample.data.user.remote;

import com.geektech.architectureexample.data.user.UserBaseDataSource;
import com.geektech.architectureexample.data.user.UserDataSource;

// Created by askar on 11/6/18.
public class UserRemoteDataSource extends UserBaseDataSource {

    //region Static

    private static UserRemoteDataSource INSTANCE;

    public static UserDataSource getInstance(){
        if (INSTANCE == null) {
            INSTANCE = new UserRemoteDataSource();
        }

        return INSTANCE;
    }

    //endregion
}
