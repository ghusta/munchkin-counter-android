package com.datarockets.mnchkn.di

import android.content.Context
import com.datarockets.mnchkn.MunchkinApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module class AppModule(private val mApplication: MunchkinApplication) {

    @Provides @Singleton
    fun providesApplication(): MunchkinApplication {
        return mApplication
    }

    @Provides @Singleton
    fun providesContext(): Context {
        return mApplication.applicationContext
    }

}
