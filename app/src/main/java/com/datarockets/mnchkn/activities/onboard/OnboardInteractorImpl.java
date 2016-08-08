package com.datarockets.mnchkn.activities.onboard;

import android.content.Context;

import com.datarockets.mnchkn.MunchkinApplication;
import com.datarockets.mnchkn.store.SettingsService;

import javax.inject.Inject;

public class OnboardInteractorImpl implements OnboardInteractor {

    @Inject
    SettingsService mSettingsService;

    public OnboardInteractorImpl(Context context) {
        MunchkinApplication.get(context).getAppComponent().inject(this);
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
