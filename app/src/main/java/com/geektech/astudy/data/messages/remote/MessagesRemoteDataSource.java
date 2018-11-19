package com.geektech.astudy.data.messages.remote;

import com.geektech.astudy.data.messages.MessagesDataSource;
import com.geektech.astudy.data.messages.model.RMessage;

// Created by askar on 11/7/18.
public class MessagesRemoteDataSource implements MessagesDataSource {

    //region Static

    private static MessagesDataSource INSTANCE;

    public static MessagesDataSource getInstance(){
        if (INSTANCE == null) {
            INSTANCE = new MessagesRemoteDataSource();
        }
        return INSTANCE;
    }

    //endregion


    @Override
    public void getMessages(MessagesCallback messagesCallback) {

    }

    @Override
    public void getMessage(long id, MessageCallback messageCallback) {

    }

    @Override
    public void addMessage(RMessage message) {

    }
}
