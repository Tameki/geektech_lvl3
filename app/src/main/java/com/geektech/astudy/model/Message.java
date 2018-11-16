package com.geektech.astudy.model;

// Created by askar on 11/16/18.
public class Message {
    private long id;

    private String contentType;

    private String content;

    private long createdAt;

    public Message(){
        this.id = 0;
        this.contentType = "default";
        this.content = "content";
        this.createdAt = 0L;
    }

    public Message(long id, String type, String content, long createdAt){
        this.id = id;
        this.contentType = type;
        this.content = content;
        this.createdAt = createdAt;
    }

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
}
