package com.geektech.astudy.injection.component;

import com.geektech.astudy.injection.module.BasicModule;
import com.geektech.astudy.presentation.main.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by askar on 11/22/18
 * with Android Studio
 */
@Singleton
@Component(modules = {BasicModule.class})
public interface BasicComponent {
    void inject(MainActivity mainActivity);
}
