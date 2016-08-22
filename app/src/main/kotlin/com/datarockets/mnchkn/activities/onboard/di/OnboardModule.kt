package com.datarockets.mnchkn.activities.onboard.di

import com.datarockets.mnchkn.activities.onboard.OnboardInteractor
import com.datarockets.mnchkn.activities.onboard.OnboardPresenter
import com.datarockets.mnchkn.activities.onboard.OnboardPresenterImpl
import com.datarockets.mnchkn.activities.onboard.OnboardView

import dagger.Module
import dagger.Provides

@Module
class OnboardModule(private val mOnboardView: OnboardView) {

    @Provides
    fun providesOnboardView(): OnboardView {
        return mOnboardView
    }

    @Provides
    fun providesOnboardPresenter(onboardView: OnboardView,
                                 onboardInteractor: OnboardInteractor): OnboardPresenter {
        return OnboardPresenterImpl(onboardView, onboardInteractor)
    }

}
