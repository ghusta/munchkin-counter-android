package com.datarockets.mnchkn.fragments.charts.di;

import com.datarockets.mnchkn.di.ActivityScope;
import com.datarockets.mnchkn.fragments.charts.ChartsInteractor;
import com.datarockets.mnchkn.fragments.charts.ChartsPresenter;
import com.datarockets.mnchkn.fragments.charts.ChartsPresenterImpl;
import com.datarockets.mnchkn.fragments.charts.ChartsView;

import dagger.Module;
import dagger.Provides;

@Module
public class ChartsModule {

    private ChartsView mChartsView;

    public ChartsModule(ChartsView chartsView) {
        this.mChartsView = chartsView;
    }

    @ActivityScope
    @Provides
    public ChartsView providesChartsView() {
        return mChartsView;
    }

    @ActivityScope
    @Provides
    public ChartsPresenter providesChartsPresenter(ChartsView chartsView,
                                                   ChartsInteractor chartsInteractor) {
        return new ChartsPresenterImpl(chartsView, chartsInteractor);
    }

}
