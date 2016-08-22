package com.datarockets.mnchkn.activities.onboard

import android.content.Context

import com.datarockets.mnchkn.MunchkinApplication
import com.datarockets.mnchkn.store.SettingsService

import javax.inject.Inject

class OnboardInteractorImpl(context: Context) : OnboardInteractor {

    @Inject
    lateinit var mSettingsService: SettingsService

    init {
        MunchkinApplication.get(context).appComponent.inject(this)
    }

    override fun isUserSeenOnboarding(listener: OnboardInteractor.OnFinishedChecking) {
        listener.shouldShowOnboarding(!mSettingsService.checkIsUserSeenOnboarding())
    }

    override fun setOnboardingSeen() {
        mSettingsService.setOnboardingSeen()
    }

}
