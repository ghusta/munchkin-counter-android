package com.datarockets.mnchkn.injection.module

import android.content.Context
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import com.datarockets.mnchkn.injection.ActivityContext
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private val mActivity: AppCompatActivity) {

    @Provides
    fun providesActivity(): AppCompatActivity {
        return mActivity
    }

    @Provides
    @ActivityContext
    fun providesContext(): Context {
        return mActivity
    }

    @Provides
    fun providesFragmentManager(): FragmentManager {
        return mActivity.supportFragmentManager
    }

}