package com.datarockets.mnchkn.di;

import android.content.Context;

import com.datarockets.mnchkn.activities.dashboard.DashboardPresenter;
import com.datarockets.mnchkn.activities.dashboard.DashboardPresenterImpl;
import com.datarockets.mnchkn.activities.dashboard.DashboardView;

import dagger.Module;
import dagger.Provides;

@Module
public class DashboardModule {

    private DashboardView mDashboardView;
    private Context mContext;

    public DashboardModule(DashboardView dashboardView, Context context) {
        this.mDashboardView = dashboardView;
        this.mContext = context;
    }

    @Provides DashboardView provideView() {
        return mDashboardView;
    }

    @Provides
    DashboardPresenter provideDashboardPresenter() {
        return new DashboardPresenterImpl(mDashboardView, mContext);
    }

}
