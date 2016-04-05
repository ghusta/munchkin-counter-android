package com.datarockets.mnchkn.activities.onboard;

public interface OnboardInteractor {

    interface OnFinishedChecking {
        void shouldShowOnboarding(boolean value);
    }

    void isUserSeenOnboarding(OnFinishedChecking listener);
    void setOnboardingSeen();
}
