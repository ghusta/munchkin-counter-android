package com.datarockets.mnchkn.fragments.charts;

import android.content.Context;

import com.datarockets.mnchkn.models.Player;

import java.util.ArrayList;

import lecho.lib.hellocharts.model.LineChartData;

public class ChartsPresenterImpl implements ChartsPresenter,
        ChartsInteractor.OnChartLoadedListener {

    private ChartsView mChartsView;
    private ChartsInteractor mChartsInteractor;

    public ChartsPresenterImpl(ChartsView chartsView, Context context) {
        this.mChartsView = chartsView;
        this.mChartsInteractor = new ChartsInteractorImpl(context);
    }

    @Override
    public void showPlayers(ArrayList<Player> players) {
        if (mChartsView != null) {
            mChartsView.showPlayersList(players);
        }
    }

    @Override
    public void loadPlayersList(int type) {
        if (mChartsView != null) {
            mChartsInteractor.loadPlayers(type, this);
        }
    }

    @Override
    public LineChartData loadChartData(int type) {
        return mChartsInteractor.loadLineChartData(type);
    }

    @Override
    public void onDestroy() {
        if (mChartsView != null) {
            mChartsView = null;
        }
    }

}
