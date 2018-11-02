package com.geektech.architectureexample.data;

import com.geektech.architectureexample.data.user.UserService;
import com.geektech.architectureexample.data.user.UserServiceContract;

// Created by askar on 11/2/18.
public class ServiceProvider {
    public static UserServiceContract getUserService(){
        return new UserService();
    }
}
