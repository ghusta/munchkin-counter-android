package com.datarockets.mnchkn.activities.dashboard.di

import com.datarockets.mnchkn.activities.dashboard.DashboardActivity
import com.datarockets.mnchkn.activities.dashboard.DashboardPresenter
import com.datarockets.mnchkn.di.ActivityScope
import com.datarockets.mnchkn.di.AppComponent

import dagger.Component

@ActivityScope
@Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(DashboardModule::class))
interface DashboardComponent {
    fun inject(dashboardActivity: DashboardActivity)
    val dashboardPresenter: DashboardPresenter
}
