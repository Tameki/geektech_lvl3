package com.geektech.architectureexample.data;

import com.geektech.architectureexample.data.messages.MessagesDataSource;
import com.geektech.architectureexample.data.messages.MessagesRepository;
import com.geektech.architectureexample.data.user.UserRepository;
import com.geektech.architectureexample.data.user.UserDataSource;
import com.geektech.architectureexample.data.user.local.UserLocalDataSource;
import com.geektech.architectureexample.data.user.remote.UserRemoteDataSource;

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
