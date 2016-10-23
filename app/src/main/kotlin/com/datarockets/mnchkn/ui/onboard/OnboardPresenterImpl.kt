package com.datarockets.mnchkn.ui.onboard

class OnboardPresenterImpl(private var mOnboardView: OnboardView?,
                           private val mOnboardInteractor: OnboardInteractor)
: OnboardPresenter, OnboardInteractor.OnFinishedChecking {

    override fun checkIsUserSeenOnboarding() {
        if (mOnboardView != null) {
            mOnboardInteractor.isUserSeenOnboarding(this)
        }
    }

    override fun setOnboardingSeen() {
        if (mOnboardView != null) {
            mOnboardInteractor.setOnboardingSeen()
        }
    }

    override fun onDestroy() {
        if (mOnboardView != null) {
            mOnboardView = null
        }
    }

    override fun shouldShowOnboarding(value: Boolean) {
        if (!value) {
            mOnboardView?.openPlayersActivity()
        }
    }
}
