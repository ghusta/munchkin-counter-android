package com.datarockets.mnchkn.activities.onboard;

import android.content.Context;

public class OnboardPresenterImpl implements OnboardPresenter,
        OnboardInteractorImpl.OnFinishedChecking {

    OnboardView onboardView;
    OnboardInteractorImpl interactor;

    public OnboardPresenterImpl(OnboardView onboardView, Context context) {
        this.onboardView = onboardView;
        this.interactor = new OnboardInteractorImpl(context);
    }

    @Override
    public void checkIsUserSeenOnboarding() {
        if (onboardView != null) {
            interactor.isUserSeenOnboarding(this);
        }
    }

    @Override
    public void setOnboardingSeen() {
        if (onboardView != null) {
            interactor.setOnboardingSeen();
        }
    }

    @Override
    public void onDestroy() {
        if (onboardView != null) {
            onboardView = null;
        }
    }

    @Override
    public void shouldShowOnboarding(boolean value) {
        if (onboardView != null && !value) {
            onboardView.openPlayersActivity();
        }
    }
}
