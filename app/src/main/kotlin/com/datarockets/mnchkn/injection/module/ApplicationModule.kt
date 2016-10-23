package com.datarockets.mnchkn.injection.module

import android.app.Application
import android.content.Context
import com.datarockets.mnchkn.injection.ApplicationContext
import dagger.Module
import dagger.Provides

@Module
open class ApplicationModule(protected val mApplication: Application) {

    @Provides
    fun providesApplication() : Application = mApplication

    @Provides
    @ApplicationContext
    fun providesContext() : Context = mApplication

}