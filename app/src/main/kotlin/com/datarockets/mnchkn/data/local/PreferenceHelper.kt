package com.datarockets.mnchkn.data.local

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import android.util.Log
import com.datarockets.mnchkn.injection.ApplicationContext
import com.datarockets.mnchkn.utils.LogUtil
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PreferenceHelper
@Inject constructor(@ApplicationContext mContext: Context) {

    private val mPref: SharedPreferences

    init {
        mPref = PreferenceManager.getDefaultSharedPreferences(mContext)
    }

    fun clear() {
        mPref.edit().clear().apply()
    }

    fun isUserSeenOnboarding(): Boolean {
        return mPref.getBoolean(IS_ONBOARDING_SEEN, false)
    }

    fun setOnboardingSeen() {
        mPref.edit().putBoolean(IS_ONBOARDING_SEEN, true).apply()
    }

    fun isWakeLockActive(): Boolean = mPref.getBoolean(IS_WAKELOCK_ACTIVE, false)

    fun setWakeLockActive(isActive: Boolean) {
        mPref.edit().putBoolean(IS_WAKELOCK_ACTIVE, isActive).apply()
    }

    fun isGameStarted(): Boolean = mPref.getBoolean(IS_GAME_STARTED, false)

    fun setGameStatus(status: Boolean) {
        mPref.edit().putBoolean(IS_GAME_STARTED, status).apply()
    }

    companion object {

        private val IS_ONBOARDING_SEEN = "is_onboarding_seen"
        private val IS_WAKELOCK_ACTIVE = "is_wakelock_active"
        private val IS_GAME_STARTED = "is_game_started"
    }

}