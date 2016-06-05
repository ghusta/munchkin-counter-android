package com.datarockets.mnchkn.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.datarockets.mnchkn.MunchkinApplication;
import com.datarockets.mnchkn.di.AppComponent;
import com.datarockets.mnchkn.utils.LogUtil;
import com.mixpanel.android.mpmetrics.MixpanelAPI;

import org.json.JSONException;
import org.json.JSONObject;

public abstract class BaseActivity extends AppCompatActivity {

    private static final String TAG = LogUtil.makeLogTag(BaseActivity.class);

    private MunchkinApplication mApplication;
    private MixpanelAPI mMixpanel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mApplication = (MunchkinApplication) getApplication();
        mMixpanel = mApplication.getMixpanel();
        setupComponent(MunchkinApplication.get(this).component());
    }

    public void trackWithProperties(String title, String propertyName, String propertyData) {
        JSONObject props = new JSONObject();
        try {
            props.put(propertyName, propertyData);
        } catch (JSONException e) {
            Log.e(TAG, "Error while trying to send tracked event");
        }
        mMixpanel.track(title, props);
    }

    public void trackWithoutProperties(String eventName) {
        mMixpanel.track(eventName);
    }

    protected abstract void setupComponent(AppComponent appComponent);

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMixpanel.flush();
    }
}
