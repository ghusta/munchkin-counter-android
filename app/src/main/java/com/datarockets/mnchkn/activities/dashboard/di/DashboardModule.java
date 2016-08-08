package com.datarockets.mnchkn.activities.dashboard.di;

import com.datarockets.mnchkn.activities.dashboard.DashboardInteractor;
import com.datarockets.mnchkn.activities.dashboard.DashboardPresenter;
import com.datarockets.mnchkn.activities.dashboard.DashboardPresenterImpl;
import com.datarockets.mnchkn.activities.dashboard.DashboardView;
import com.datarockets.mnchkn.di.ActivityScope;

import dagger.Module;
import dagger.Provides;

@Module
public class DashboardModule {

    private DashboardView mDashboardView;

    public DashboardModule(DashboardView dashboardView) {
        this.mDashboardView = dashboardView;
    }

    @ActivityScope
    @Provides
    public DashboardView providesDashboardView() {
        return mDashboardView;
    }

    @ActivityScope
    @Provides
    public DashboardPresenter providesDashboardPresenter(DashboardView dashboardView,
                                                         DashboardInteractor dashboardInteractor) {
        return new DashboardPresenterImpl(dashboardView, dashboardInteractor);
    }

}
