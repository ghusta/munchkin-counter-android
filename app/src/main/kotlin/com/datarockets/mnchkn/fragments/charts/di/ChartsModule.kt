package com.datarockets.mnchkn.fragments.charts.di

import com.datarockets.mnchkn.di.ActivityScope
import com.datarockets.mnchkn.fragments.charts.ChartsInteractor
import com.datarockets.mnchkn.fragments.charts.ChartsPresenter
import com.datarockets.mnchkn.fragments.charts.ChartsPresenterImpl
import com.datarockets.mnchkn.fragments.charts.ChartsView

import dagger.Module
import dagger.Provides

@Module class ChartsModule(private val mChartsView: ChartsView) {

    @ActivityScope @Provides
    fun providesChartsView(): ChartsView {
        return mChartsView
    }

    @ActivityScope @Provides
    fun providesChartsPresenter(chartsView: ChartsView,
                                chartsInteractor: ChartsInteractor): ChartsPresenter {
        return ChartsPresenterImpl(chartsView, chartsInteractor)
    }

}
