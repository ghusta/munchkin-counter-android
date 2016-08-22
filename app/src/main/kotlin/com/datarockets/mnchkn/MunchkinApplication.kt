package com.datarockets.mnchkn

import android.app.Application
import android.content.Context

import com.datarockets.mnchkn.di.AppComponent
import com.datarockets.mnchkn.di.AppModule
import com.datarockets.mnchkn.di.DaggerAppComponent
import com.mixpanel.android.mpmetrics.MixpanelAPI

class MunchkinApplication : Application() {

    lateinit var appComponent: AppComponent

    private var mMixpanel: MixpanelAPI? = null

    override fun onCreate() {
        super.onCreate()
        setUpGraph()
    }

    val mixpanel: MixpanelAPI
        @Synchronized get() {
            if (mMixpanel == null) {
                mMixpanel = MixpanelAPI.getInstance(this, BuildConfig.MIXPANEL_API_KEY)
            }
            return mMixpanel!!
        }

    private fun setUpGraph() {
        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
        appComponent.inject(this)
    }

    companion object {
        operator fun get(context: Context): MunchkinApplication {
            return context.applicationContext as MunchkinApplication
        }
    }

}
