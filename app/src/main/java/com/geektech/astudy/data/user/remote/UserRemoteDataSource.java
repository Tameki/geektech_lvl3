package com.geektech.astudy.data.user.remote;

import com.geektech.astudy.data.user.UserBaseDataSource;
import com.geektech.astudy.data.user.UserDataSource;

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
