package com.datarockets.mnchkn;

import android.app.Application;
import android.content.Context;

import com.datarockets.mnchkn.di.AppComponent;
import com.datarockets.mnchkn.di.AppModule;
import com.datarockets.mnchkn.di.DaggerAppComponent;
import com.mixpanel.android.mpmetrics.MixpanelAPI;

public class MunchkinApplication extends Application {

    private AppComponent mAppComponent;
    private MixpanelAPI mMixpanel;

    @Override
    public void onCreate() {
        super.onCreate();
        setUpGraph();
    }

    public synchronized MixpanelAPI getMixpanel() {
        if (mMixpanel == null) {
            mMixpanel = MixpanelAPI.getInstance(this, BuildConfig.MIXPANEL_API_KEY);
        }
        return mMixpanel;
    }

    private void setUpGraph() {
        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
        mAppComponent.inject(this);
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }


    public static MunchkinApplication get(Context context) {
        return (MunchkinApplication) context.getApplicationContext();
    }

}
