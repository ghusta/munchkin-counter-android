package com.datarockets.mnchkn

import android.app.Application
import android.content.Context
import com.datarockets.mnchkn.injection.component.ApplicationComponent
import com.datarockets.mnchkn.injection.component.DaggerApplicationComponent
import com.datarockets.mnchkn.injection.module.ApplicationModule
import com.mixpanel.android.mpmetrics.MixpanelAPI

class MunchkinApplication : Application() {

    lateinit var mApplicationComponent: ApplicationComponent

//    val mMixpanel: MixpanelAPI = MixpanelAPI.getInstance(this, BuildConfig.MIXPANEL_API_KEY)

    override fun onCreate() {
        super.onCreate()
        mApplicationComponent = DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this))
            .build()
        mApplicationComponent.inject(this)
    }

    fun getComponent() : ApplicationComponent = mApplicationComponent

    fun setComponent(applicationComponent: ApplicationComponent) {
        mApplicationComponent = applicationComponent
    }

    companion object {
        operator fun get(context: Context): MunchkinApplication {
            return context.applicationContext as MunchkinApplication
        }
    }

}
