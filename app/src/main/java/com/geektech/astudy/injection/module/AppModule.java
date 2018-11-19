package com.geektech.astudy.injection.module;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by askar on 11/19/18
 * with Android Studio
 */

@Module
public class AppModule {
    private Application app;
    public AppModule(Application application) {
        app = application;
    }
    @Singleton
    @Provides
    public Application provideApplication() {
        return app;
    }
}
