package com.datarockets.mnchkn.activities.dashboard.di;

import com.datarockets.mnchkn.activities.dashboard.DashboardActivity;
import com.datarockets.mnchkn.activities.dashboard.DashboardPresenter;
import com.datarockets.mnchkn.di.ActivityScope;
import com.datarockets.mnchkn.di.AppComponent;

import dagger.Component;

@ActivityScope
@Component(dependencies = AppComponent.class, modules = DashboardModule.class)
public interface DashboardComponent {
    void inject(DashboardActivity dashboardActivity);
    DashboardPresenter getDashboardPresenter();
}
