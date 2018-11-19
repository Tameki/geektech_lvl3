package com.geektech.astudy.injection.component;

import android.app.Application;

import com.geektech.astudy.injection.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by askar on 11/19/18
 * with Android Studio
 */
@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    Application application();
}
