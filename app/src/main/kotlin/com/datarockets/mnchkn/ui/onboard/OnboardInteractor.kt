package com.datarockets.mnchkn.ui.onboard

interface OnboardInteractor {

    interface OnFinishedChecking {
        fun shouldShowOnboarding(value: Boolean)
    }

    fun isUserSeenOnboarding(listener: OnFinishedChecking)
    fun setOnboardingSeen()
}
