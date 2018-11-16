package com.geektech.astudy.fcm;

import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

// Created by askar on 11/16/18.
public class FCMService extends FirebaseMessagingService {


    @Override
    public void onNewToken(String s) {
        Log.d("ololo", "New firebase token - " + s);
        super.onNewToken(s);
    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
    }
}
