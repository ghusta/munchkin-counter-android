package com.datarockets.mnchkn.di;

import com.datarockets.mnchkn.activities.dashboard.DashboardActivity;
import com.datarockets.mnchkn.activities.dashboard.DashboardPresenter;

import dagger.Component;

@ActivityScope
@Component(dependencies = AppComponent.class, modules = DashboardModule.class)
public interface DashboardComponent {
    void inject(DashboardActivity activity);
    DashboardPresenter getDashboardPresenter();
}
