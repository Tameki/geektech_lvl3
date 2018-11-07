package com.geektech.architectureexample;

import android.app.Application;

import io.realm.Realm;

// Created by askar on 11/6/18.
public class ArchitectureExampleApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
    }
}
