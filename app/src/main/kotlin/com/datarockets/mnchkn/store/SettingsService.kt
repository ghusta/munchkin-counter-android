package com.datarockets.mnchkn.store

interface SettingsService {
    fun checkIsUserSeenOnboarding(): Boolean
    fun setOnboardingSeen()
    val isWakeLockActive: Boolean
    fun setWakeLock(isActive: Boolean)
}
