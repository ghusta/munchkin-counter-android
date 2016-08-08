package com.datarockets.mnchkn.di;

import com.datarockets.mnchkn.MunchkinApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private MunchkinApplication mApplication;

    public AppModule(MunchkinApplication application) {
        this.mApplication = application;
    }

    @Provides
    @Singleton
    public MunchkinApplication providesApplication() {
        return mApplication;
    }

}
