package com.datarockets.mnchkn.store;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SettingsServiceImpl implements SettingsService {
    private static SettingsServiceImpl instance;

    private static final String IS_ONBOARDING_SEEN = "is_onboarding_seen";

    private SharedPreferences mPreferences;
    private SharedPreferences.Editor mPreferencesEditor;

    private SettingsServiceImpl(Context context) {
        mPreferences = PreferenceManager.getDefaultSharedPreferences(context);
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

    public void setOnboardingSeen() {
        mPreferencesEditor = mPreferences.edit();
        mPreferencesEditor.putBoolean(IS_ONBOARDING_SEEN, true);
        mPreferencesEditor.apply();
    }

}
