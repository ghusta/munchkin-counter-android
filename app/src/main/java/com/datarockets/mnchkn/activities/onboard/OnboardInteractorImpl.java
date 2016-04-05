package com.datarockets.mnchkn.activities.onboard;

import android.content.Context;

import com.datarockets.mnchkn.store.SettingsServiceImpl;

public class OnboardInteractorImpl implements OnboardInteractor {

    private SettingsServiceImpl settingsService;

    public OnboardInteractorImpl(Context context) {
        settingsService = SettingsServiceImpl.getInstance(context);
    }

    @Override
    public void isUserSeenOnboarding(OnFinishedChecking listener) {
        listener.shouldShowOnboarding(!settingsService.checkIsUserSeenOnboarding());
    }

    @Override
    public void setOnboardingSeen() {
        settingsService.setOnboardingSeen();
    }

}
