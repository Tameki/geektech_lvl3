package com.geektech.architectureexample.data.messages.model;

import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

// Created by askar on 11/7/18.
public class RMessage extends RealmObject {
    @PrimaryKey
    private long id;

    private String contentType;

    private String content;

    private long createdAt;

    //region Constructors

    public RMessage(){
        this.id = 0;
        this.contentType = "default";
        this.content = "content";
        this.createdAt = 0L;
    }

    public RMessage(long id, String type, String content, long createdAt){
        this.id = id;
        this.contentType = type;
        this.content = content;
        this.createdAt = createdAt;
    }

    //endregion

    //region Getters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    //endregion


    @Override
    public String toString() {
        return id + " " + contentType + " " + content + " " + new Date(createdAt);
    }
}
