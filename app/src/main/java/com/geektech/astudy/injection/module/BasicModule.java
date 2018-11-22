package com.geektech.astudy.injection.module;

import com.geektech.astudy.model.ConstValues;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by askar on 11/22/18
 * with Android Studio
 */
@Module
public class BasicModule {
    @Singleton
    @Provides
    public ConstValues provideConstValues(){
        return new ConstValues();
    }
}
