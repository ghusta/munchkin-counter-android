package com.datarockets.mnchkn.activities.settings;

import android.os.Bundle;
import android.preference.PreferenceActivity;

import com.datarockets.mnchkn.fragments.SettingsFragment;

public class SettingsActivity extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getFragmentManager().beginTransaction().replace(android.R.id.content, new SettingsFragment()).commit();
    }

}
