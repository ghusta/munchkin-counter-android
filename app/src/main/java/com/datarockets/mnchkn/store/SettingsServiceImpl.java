package com.datarockets.mnchkn.store;

import android.content.Context;
import android.content.SharedPreferences;

import com.datarockets.mnchkn.MunchkinApplication;

import javax.inject.Inject;

public class SettingsServiceImpl implements SettingsService {

    private static final String IS_ONBOARDING_SEEN = "is_onboarding_seen";
    private static final String IS_WAKELOCK_ACTIVE = "is_wakelock_active";

    @Inject
    SharedPreferences mPreferences;
    @Inject
    SharedPreferences.Editor mPreferencesEditor;

    public SettingsServiceImpl(Context context) {
        MunchkinApplication.get(context).getAppComponent().inject(this);
    }

    @Override
    public boolean checkIsUserSeenOnboarding() {
        return mPreferences.getBoolean(IS_ONBOARDING_SEEN, false);
    }

    @Override
    public void setOnboardingSeen() {
        mPreferencesEditor.putBoolean(IS_ONBOARDING_SEEN, true);
        mPreferencesEditor.apply();
    }

    @Override
    public boolean isWakeLockActive() {
        return mPreferences.getBoolean(IS_WAKELOCK_ACTIVE, false);
    }

    @Override
    public void setWakeLock(boolean isActive) {
        mPreferencesEditor.putBoolean(IS_WAKELOCK_ACTIVE, isActive);
        mPreferencesEditor.apply();
    }

}
