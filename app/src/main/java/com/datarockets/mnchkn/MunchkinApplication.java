package com.datarockets.mnchkn;

import android.app.Application;

import com.mixpanel.android.mpmetrics.MixpanelAPI;

public class MunchkinApplication extends Application {

    private MixpanelAPI mixpanel;
    private static final String PROJECT_TOKEN = BuildConfig.MIXPANEL_API_KEY;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public synchronized MixpanelAPI getMixpanel() {
        if (mixpanel == null) {
            mixpanel = MixpanelAPI.getInstance(this, PROJECT_TOKEN);
        }
        return mixpanel;

    }

}
