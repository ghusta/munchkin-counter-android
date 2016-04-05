package com.datarockets.mnchkn.store;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SettingsServiceImpl implements SettingsService {
    private static SettingsServiceImpl instance;

    private static final String IS_ONBOARDING_SEEN = "is_onboarding_seen";

    private SharedPreferences preferences;
    private SharedPreferences.Editor preferencesEditor;

    private SettingsServiceImpl(Context context) {
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static SettingsServiceImpl getInstance(Context context) {
        if (instance == null) {
            instance = new SettingsServiceImpl(context);
        }
        return instance;
    }

    @Override
    public boolean checkIsUserSeenOnboarding() {
        return preferences.getBoolean(IS_ONBOARDING_SEEN, false);
    }

    public void setOnboardingSeen() {
        preferencesEditor = preferences.edit();
        preferencesEditor.putBoolean(IS_ONBOARDING_SEEN, true);
        preferencesEditor.apply();
    }

}
