package com.datarockets.mnchkn.activities.onboard

interface OnboardInteractor {

    interface OnFinishedChecking {
        fun shouldShowOnboarding(value: Boolean)
    }

    fun isUserSeenOnboarding(listener: OnFinishedChecking)
    fun setOnboardingSeen()
}
