package com.datarockets.mnchkn.store

import android.content.Context
import android.content.SharedPreferences

import com.datarockets.mnchkn.MunchkinApplication

import javax.inject.Inject

class SettingsServiceImpl(context: Context) : SettingsService {

    @Inject
    lateinit var mPreferences: SharedPreferences
    @Inject
    lateinit var mPreferencesEditor: SharedPreferences.Editor

    init {
        MunchkinApplication.get(context).appComponent.inject(this)
    }

    override fun checkIsUserSeenOnboarding(): Boolean {
        return mPreferences.getBoolean(IS_ONBOARDING_SEEN, false)
    }

    override fun setOnboardingSeen() {
        mPreferencesEditor.putBoolean(IS_ONBOARDING_SEEN, true)
        mPreferencesEditor.apply()
    }

    override val isWakeLockActive: Boolean
        get() = mPreferences.getBoolean(IS_WAKELOCK_ACTIVE, false)

    override fun setWakeLock(isActive: Boolean) {
        mPreferencesEditor.putBoolean(IS_WAKELOCK_ACTIVE, isActive)
        mPreferencesEditor.apply()
    }

    companion object {

        private val IS_ONBOARDING_SEEN = "is_onboarding_seen"
        private val IS_WAKELOCK_ACTIVE = "is_wakelock_active"
    }

}
