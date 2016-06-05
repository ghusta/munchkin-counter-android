package com.datarockets.mnchkn;

import android.app.Application;
import android.content.Context;

import com.datarockets.mnchkn.di.AppComponent;
import com.datarockets.mnchkn.di.AppModule;
import com.datarockets.mnchkn.di.DaggerAppComponent;
import com.mixpanel.android.mpmetrics.MixpanelAPI;


public class MunchkinApplication extends Application {

    private static final String PROJECT_TOKEN = BuildConfig.MIXPANEL_API_KEY;

    private MixpanelAPI mMixpanel;

    private AppComponent mComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        setupGraph();
    }

    private void setupGraph() {
        mComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
        mComponent.inject(this);
    }

    public synchronized MixpanelAPI getMixpanel() {
        if (mMixpanel == null) {
            mMixpanel = MixpanelAPI.getInstance(this, PROJECT_TOKEN);
        }
        return mMixpanel;

    }

    public AppComponent component() {
        return mComponent;
    }

    public static MunchkinApplication get(Context context) {
        return (MunchkinApplication) context.getApplicationContext();
    }

}
