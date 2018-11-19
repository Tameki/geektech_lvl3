package com.geektech.astudy.data.messages;

import com.geektech.astudy.data.messages.model.RMessage;

// Created by askar on 11/7/18.
public class MessagesRepository implements MessagesDataSource {

    //region Static

    private static MessagesRepository INSTANCE;

    public static MessagesDataSource getInstance(
            MessagesDataSource local,
            MessagesDataSource remote
    ){
        if (INSTANCE == null) {
            INSTANCE = new MessagesRepository(local, remote);
        }
        return INSTANCE;
    }

    //endregion

    private MessagesDataSource mLocal;
    private MessagesDataSource mRemote;

    private MessagesRepository(
            MessagesDataSource local,
            MessagesDataSource remote){
        this.mLocal = local;
        this.mRemote = remote;
    }

    //region Contract

    @Override
    public void getMessages(MessagesCallback messagesCallback) {
        if (mLocal != null) {
            mLocal.getMessages(messagesCallback);
        }
    }

    @Override
    public void getMessage(long id, MessageCallback messageCallback) {
        if (mLocal != null) {
            mLocal.getMessage(id, messageCallback);
        }
    }

    @Override
    public void addMessage(RMessage message) {
        if (mLocal != null) {
            mLocal.addMessage(message);
        }
    }

    //endregion
}
