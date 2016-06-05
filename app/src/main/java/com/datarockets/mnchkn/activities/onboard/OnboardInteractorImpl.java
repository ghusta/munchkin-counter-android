package com.datarockets.mnchkn.activities.onboard;

import android.content.Context;

import com.datarockets.mnchkn.store.SettingsService;
import com.datarockets.mnchkn.store.SettingsServiceImpl;

public class OnboardInteractorImpl implements OnboardInteractor {

    private SettingsService mSettingsService;

    public OnboardInteractorImpl(Context context) {
        mSettingsService = SettingsServiceImpl.getInstance(context);
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
