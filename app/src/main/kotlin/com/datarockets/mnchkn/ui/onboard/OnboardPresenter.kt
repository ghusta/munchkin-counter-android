package com.datarockets.mnchkn.ui.onboard

import com.datarockets.mnchkn.data.DataManager
import com.datarockets.mnchkn.ui.base.Presenter
import javax.inject.Inject

class OnboardPresenter
@Inject constructor(private val mDataManager: DataManager) : Presenter<OnboardView> {

    private var mOnboardView: OnboardView? = null

    override fun attachView(mvpView: OnboardView) {
        mOnboardView = mvpView
    }

    fun checkIsUserSeenOnboarding() {
        if (mDataManager.getPreferenceHelper().isUserSeenOnboarding()) {
            mOnboardView?.openPlayersActivity()
        }
    }

    fun setOnboardingSeen() {
        mDataManager.getPreferenceHelper().setOnboardingSeen()
    }

    override fun detachView() {
        mOnboardView = null
    }

}
