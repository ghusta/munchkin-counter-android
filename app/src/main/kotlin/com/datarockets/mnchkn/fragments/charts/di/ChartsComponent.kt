package com.datarockets.mnchkn.fragments.charts.di

import com.datarockets.mnchkn.di.ActivityScope
import com.datarockets.mnchkn.di.AppComponent
import com.datarockets.mnchkn.fragments.charts.ChartsFragment

import dagger.Component

@ActivityScope
@Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(ChartsModule::class))
interface ChartsComponent {
    fun inject(chartsFragment: ChartsFragment)
}
