package com.datarockets.mnchkn.activities.onboard.di;

import com.datarockets.mnchkn.activities.onboard.OnboardInteractor;
import com.datarockets.mnchkn.activities.onboard.OnboardPresenter;
import com.datarockets.mnchkn.activities.onboard.OnboardPresenterImpl;
import com.datarockets.mnchkn.activities.onboard.OnboardView;

import dagger.Module;
import dagger.Provides;

@Module
public class OnboardModule {

    private OnboardView mOnboardView;

    public OnboardModule(OnboardView onboardView) {
        this.mOnboardView = onboardView;
    }

    @Provides
    public OnboardView providesOnboardView() {
        return mOnboardView;
    }

    @Provides
    public OnboardPresenter providesOnboardPresenter(OnboardView onboardView,
                                                     OnboardInteractor onboardInteractor) {
        return new OnboardPresenterImpl(onboardView, onboardInteractor);
    }

}
