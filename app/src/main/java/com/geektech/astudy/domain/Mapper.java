package com.geektech.astudy.domain;

import com.geektech.astudy.data.messages.model.RMessage;
import com.geektech.astudy.model.Message;

// Created by askar on 11/16/18.
public class Mapper {
    public static Message fromRMessage(RMessage rMessage) {
        return new Message(
                rMessage.getId(),
                rMessage.getContentType(),
                rMessage.getContent(),
                rMessage.getCreatedAt()
        );
    }

    public static RMessage toRMessage(Message message) {
        return new RMessage(
                message.getId(),
                message.getContentType(),
                message.getContent(),
                message.getCreatedAt()
        );
    }
}
