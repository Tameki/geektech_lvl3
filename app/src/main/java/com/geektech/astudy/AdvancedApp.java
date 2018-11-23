package com.geektech.astudy;

import android.app.Application;

import com.geektech.astudy.injection.component.AppComponent;
import com.geektech.astudy.injection.component.BasicComponent;
import com.geektech.astudy.injection.component.DaggerAppComponent;
import com.geektech.astudy.injection.component.DaggerBasicComponent;
import com.geektech.astudy.injection.module.AppModule;
import com.geektech.astudy.injection.module.BasicModule;
import io.realm.Realm;

// Created by askar on 11/6/18.
public class AdvancedApp extends Application{

    private AppComponent appComponent;
    private BasicComponent basicComponent;
    private static AdvancedApp instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        Realm.init(this);

        initDagger();

    }

    private void initDagger(){
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(instance))
                .build();

        basicComponent = DaggerBasicComponent.builder()
                .basicModule(new BasicModule())
                .build();
    }

    public AppComponent component(){
        return appComponent;
    }

    public BasicComponent basicComponent(){
        return basicComponent;
    }
}
