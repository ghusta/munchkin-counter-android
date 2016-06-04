package com.datarockets.mnchkn.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.datarockets.mnchkn.MunchkinApplication;
import com.mixpanel.android.mpmetrics.MixpanelAPI;

import org.json.JSONException;
import org.json.JSONObject;

public class BaseActivity extends AppCompatActivity {

    private MunchkinApplication mApplication;
    private MixpanelAPI mMixpanel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mApplication = (MunchkinApplication) getApplication();
        mMixpanel = mApplication.getMixpanel();
    }

    public void trackWithProperties(String title, String propertyName, String propertyData) {
        JSONObject props = new JSONObject();
        try {
            props.put(propertyName, propertyData);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        mMixpanel.track(title, props);
    }

    public void trackWithoutProperties(String eventName) {
        mMixpanel.track(eventName);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMixpanel.flush();
    }
}
