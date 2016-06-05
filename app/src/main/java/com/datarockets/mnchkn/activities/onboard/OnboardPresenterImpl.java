package com.datarockets.mnchkn.activities.onboard;

import android.content.Context;

public class OnboardPresenterImpl implements OnboardPresenter,
        OnboardInteractorImpl.OnFinishedChecking {

    private OnboardView mOnboardView;
    private OnboardInteractor mOnboardInteractor;

    public OnboardPresenterImpl(OnboardView onboardView, Context context) {
        this.mOnboardView = onboardView;
        this.mOnboardInteractor = new OnboardInteractorImpl(context);
    }

    @Override
    public void checkIsUserSeenOnboarding() {
        if (mOnboardView != null) {
            mOnboardInteractor.isUserSeenOnboarding(this);
        }
    }

    @Override
    public void setOnboardingSeen() {
        if (mOnboardView != null) {
            mOnboardInteractor.setOnboardingSeen();
        }
    }

    @Override
    public void onDestroy() {
        if (mOnboardView != null) {
            mOnboardView = null;
        }
    }

    @Override
    public void shouldShowOnboarding(boolean value) {
        if (mOnboardView != null && !value) {
            mOnboardView.openPlayersActivity();
        }
    }
}
