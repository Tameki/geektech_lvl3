package com.geektech.astudy.data;

import com.geektech.astudy.data.beer.BeerDataSource;
import com.geektech.astudy.data.beer.BeerRepository;
import com.geektech.astudy.data.beer.local.BeerLocalDataSource;
import com.geektech.astudy.data.beer.remote.BeerRemoteDataSource;
import com.geektech.astudy.data.messages.MessagesDataSource;
import com.geektech.astudy.data.messages.MessagesRepository;
import com.geektech.astudy.data.messages.local.MessagesLocalDataSource;
import com.geektech.astudy.data.messages.remote.MessagesRemoteDataSource;
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
        return MessagesRepository.getInstance(
                MessagesLocalDataSource.getInstance(),
                MessagesRemoteDataSource.getInstance()
        );
    }

    public static BeerDataSource getBeerRepository(){
        return BeerRepository.getInstance(
                BeerLocalDataSource.getInstance(),
                BeerRemoteDataSource.getInstance()
        );
    }

}
