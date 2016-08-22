package com.datarockets.mnchkn.activities.dashboard.di

import com.datarockets.mnchkn.activities.dashboard.DashboardInteractor
import com.datarockets.mnchkn.activities.dashboard.DashboardPresenter
import com.datarockets.mnchkn.activities.dashboard.DashboardPresenterImpl
import com.datarockets.mnchkn.activities.dashboard.DashboardView
import com.datarockets.mnchkn.di.ActivityScope

import dagger.Module
import dagger.Provides

@Module class DashboardModule(private val mDashboardView: DashboardView) {

    @ActivityScope @Provides
    fun providesDashboardView(): DashboardView {
        return mDashboardView
    }

    @ActivityScope @Provides
    fun providesDashboardPresenter(dashboardView: DashboardView,
                                   dashboardInteractor: DashboardInteractor): DashboardPresenter {
        return DashboardPresenterImpl(dashboardView, dashboardInteractor)
    }

}
