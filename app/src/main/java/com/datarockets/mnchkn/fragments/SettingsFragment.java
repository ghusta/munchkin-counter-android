package com.datarockets.mnchkn.fragments;

import android.os.Bundle;
import android.preference.PreferenceFragment;

import com.datarockets.mnchkn.R;

public class SettingsFragment extends PreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }
}
