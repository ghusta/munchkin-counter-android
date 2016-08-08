package com.datarockets.mnchkn.activities.onboard;

import android.content.Context;

import com.datarockets.mnchkn.store.SettingsServiceImpl;

public class OnboardInteractorImpl implements OnboardInteractor {

    private SettingsServiceImpl mSettingsService;

    public OnboardInteractorImpl(Context context) {
        mSettingsService = new SettingsServiceImpl(context);
    }

    @Override
    public void isUserSeenOnboarding(OnFinishedChecking listener) {
        listener.shouldShowOnboarding(!mSettingsService.checkIsUserSeenOnboarding());
    }

    @Override
    public void setOnboardingSeen() {
        mSettingsService.setOnboardingSeen();
    }

}
