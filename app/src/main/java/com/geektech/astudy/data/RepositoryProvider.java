package com.geektech.astudy.data;

import com.geektech.astudy.data.messages.MessagesDataSource;
import com.geektech.astudy.data.messages.MessagesRepository;
import com.geektech.astudy.data.user.UserRepository;
import com.geektech.astudy.data.user.UserDataSource;
import com.geektech.astudy.data.user.local.UserLocalDataSource;
import com.geektech.astudy.data.user.remote.UserRemoteDataSource;

// Created by askar on 11/2/18.
public class RepositoryProvider {
    public static UserDataSource getUserRepository(){
        return UserRepository.getInstance(
                UserLocalDataSource.getInstance(),
                UserRemoteDataSource.getInstance()
        );
    }


    public static MessagesDataSource getMessagesRepository(){
        return MessagesRepository.getInstance();
    }

}
