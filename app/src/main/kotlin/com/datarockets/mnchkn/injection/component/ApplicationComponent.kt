package com.datarockets.mnchkn.injection.component

import android.app.Application
import android.content.Context
import com.datarockets.mnchkn.MunchkinApplication
import com.datarockets.mnchkn.data.DataManager
import com.datarockets.mnchkn.data.local.DatabaseHelper
import com.datarockets.mnchkn.data.local.PreferenceHelper
import com.datarockets.mnchkn.injection.ApplicationContext
import com.datarockets.mnchkn.injection.module.ApplicationModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {
    fun inject(munchkinApplication: MunchkinApplication)

    @ApplicationContext fun context(): Context

    fun application(): Application
    fun dataManager(): DataManager
    fun databaseHelper(): DatabaseHelper
    fun preferenceHelper(): PreferenceHelper
}