package com.datarockets.mnchkn.activities;

import android.content.Intent;
import android.os.Bundle;

import com.datarockets.mnchkn.R;
import com.datarockets.mnchkn.activities.onboard.OnboardActivity;
import com.datarockets.mnchkn.di.AppComponent;
import com.datarockets.mnchkn.utils.LogUtil;

public class SplashScreen extends BaseActivity {

    public static final String TAG = LogUtil.makeLogTag(SplashScreen.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

    }

    @Override
    protected void setUpActivityComponent(AppComponent appComponent) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        super.trackWithProperties("Current activity", "Activity name", TAG);
        Intent intent = new Intent(this, OnboardActivity.class);
        startActivity(intent);
        finish();
    }
}
