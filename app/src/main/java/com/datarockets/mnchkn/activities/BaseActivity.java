package com.datarockets.mnchkn.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.datarockets.mnchkn.MunchkinApplication;
import com.mixpanel.android.mpmetrics.MixpanelAPI;

import org.json.JSONException;
import org.json.JSONObject;

public class BaseActivity extends AppCompatActivity {

    private MunchkinApplication application;
    private MixpanelAPI mixpanel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        application = (MunchkinApplication) getApplication();
        mixpanel = application.getMixpanel();
    }

    public void trackCurrentActivity(String activityName) {
        JSONObject props = new JSONObject();
        try {
            props.put("Activity name", activityName);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        mixpanel.track("Current Activity", props);
    }

    public void trackUserTap(String category, String action) {
        JSONObject props = new JSONObject();
        try {
            props.put("Category", category);
            props.put("Action", action);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        mixpanel.track("User tap", props);
    }

    public void startTrackTimeEvent(String eventName) {
        mixpanel.timeEvent(eventName);
    }

    public void stopTrackTimeEvent(String eventName) {
        mixpanel.track(eventName);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mixpanel.flush();
    }
}
