package com.datarockets.mnchkn.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.datarockets.mnchkn.MunchkinApplication;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

public class BaseActivity extends AppCompatActivity {

    MunchkinApplication application;
    Tracker tracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        application = (MunchkinApplication) getApplication();
        tracker = application.getDefaultTracker();
    }

    public void trackCurrentActivity(String activityName) {
        tracker.setScreenName(activityName);
        tracker.send(new HitBuilders.ScreenViewBuilder().build());
    }

    public void trackClick(String category, String action) {
        tracker.send(new HitBuilders.EventBuilder(category, action).build());
    }

}
