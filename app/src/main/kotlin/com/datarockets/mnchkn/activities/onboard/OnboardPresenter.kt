package com.datarockets.mnchkn.activities.onboard

interface OnboardPresenter {
    fun checkIsUserSeenOnboarding()
    fun setOnboardingSeen()
    fun onDestroy()
}
