package com.geektech.architectureexample.data.user;

import com.geektech.architectureexample.model.LoginEntity;

// Created by askar on 11/2/18.
public class UserRepository implements UserDataSource {

    private UserDataSource mLocalDataSource;
    private UserDataSource mRemoteDataSource;

    public UserRepository(
            UserDataSource localDataSource,
            UserDataSource remoteDataSource
    ){
        this.mLocalDataSource = localDataSource;
        this.mRemoteDataSource = remoteDataSource;
    }

    //region Static

    private static UserRepository INSTANCE;

    public static UserDataSource getInstance(
            UserDataSource localDataSource,
            UserDataSource remoteDataSource
    ){
        if (INSTANCE == null) {
            INSTANCE = new UserRepository(localDataSource, remoteDataSource);
        }

        return INSTANCE;
    }

    //endregion

    @Override
    public void checkLogin(LoginEntity loginData, CheckLoginCallback callback) {
        if (mLocalDataSource != null) {
            mLocalDataSource.checkLogin(loginData, callback);
        }
    }
}
