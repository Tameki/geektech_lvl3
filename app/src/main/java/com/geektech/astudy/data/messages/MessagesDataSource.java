package com.geektech.astudy.data.messages;

import com.geektech.astudy.data.messages.model.RMessage;
import com.geektech.core.callback.BaseCallback;

import java.util.List;

// Created by askar on 11/7/18.
public interface MessagesDataSource {

    void getMessages(MessagesCallback messagesCallback);

    void getMessage(long id, MessageCallback messageCallback);

    void addMessage(RMessage message);

    interface MessagesCallback extends BaseCallback<List<RMessage>> { }

    interface MessageCallback extends BaseCallback<RMessage>{}
}
