package com.datarockets.mnchkn.ui.onboard

interface OnboardPresenter {
    fun checkIsUserSeenOnboarding()
    fun setOnboardingSeen()
    fun onDestroy()
}
