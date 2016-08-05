package com.datarockets.mnchkn.store;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SettingsServiceImpl implements SettingsService {
    private static SettingsServiceImpl instance;

    private static final String IS_ONBOARDING_SEEN = "is_onboarding_seen";
    private static final String IS_WAKELOCK_ACTIVE = "is_wakelock_active";

    private SharedPreferences mPreferences;
    private SharedPreferences.Editor mPreferencesEditor;

    private SettingsServiceImpl(Context context) {
        mPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        mPreferencesEditor = mPreferences.edit();
    }

    public static SettingsServiceImpl getInstance(Context context) {
        if (instance == null) {
            instance = new SettingsServiceImpl(context);
        }
        return instance;
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
