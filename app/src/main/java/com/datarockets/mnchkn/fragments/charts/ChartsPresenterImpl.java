package com.datarockets.mnchkn.fragments.charts;

import android.content.Context;

public class ChartsPresenterImpl implements ChartsPresenter {

    ChartsView chartsView;
    ChartsInteractorImpl interactor;

    public ChartsPresenterImpl(ChartsView chartsView, Context context) {
        this.chartsView = chartsView;
        this.interactor = new ChartsInteractorImpl(context);
    }

    @Override
    public void loadChartData(int type) {

    }

    @Override
    public void onViewCreated() {
        if (chartsView != null) {

        }
    }

    @Override
    public void onDestroy() {
        if (chartsView != null) {
            chartsView = null;
        }
    }
}
