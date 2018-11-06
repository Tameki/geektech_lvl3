package com.geektech.core.callback;

// Created by askar on 11/6/18.
public interface BaseCallback<T> {
    void onSuccess(T result);

    void onFail(String message);
}
