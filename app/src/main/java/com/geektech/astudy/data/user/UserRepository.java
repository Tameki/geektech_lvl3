package com.geektech.astudy.data.user;

import com.geektech.astudy.model.LoginEntity;

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

    //region Contract

    @Override
    public void checkLogin(LoginEntity loginData, DSCheckLoginCallback callback) {
        if (mLocalDataSource != null) {
            mLocalDataSource.checkLogin(loginData, callback);
        }
    }

    @Override
    public LoginEntity getLoginData() {
        if (mLocalDataSource != null) {
            return mLocalDataSource.getLoginData();
        }

        return null;
    }

    //endregion
}
