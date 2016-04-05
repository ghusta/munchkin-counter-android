package com.datarockets.mnchkn.activities.onboard;

public interface OnboardPresenter {
    void checkIsUserSeenOnboarding();
    void setOnboardingSeen();
    void onDestroy();
}
