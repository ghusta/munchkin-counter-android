package com.datarockets.mnchkn.di;

import com.datarockets.mnchkn.MunchkinApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private MunchkinApplication mMunchkinApplication;

    public AppModule(MunchkinApplication application) {
        mMunchkinApplication = application;
    }

    @Provides
    @Singleton
    public MunchkinApplication provideApplication() {
        return mMunchkinApplication;
    }

}
