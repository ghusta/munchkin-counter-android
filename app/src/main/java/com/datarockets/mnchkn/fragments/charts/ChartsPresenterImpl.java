package com.datarockets.mnchkn.fragments.charts;

import android.content.Context;

import com.datarockets.mnchkn.models.Player;

import java.util.ArrayList;

import lecho.lib.hellocharts.model.LineChartData;

public class ChartsPresenterImpl implements ChartsPresenter,
        ChartsInteractor.OnChartLoadedListener {

    ChartsView chartsView;
    ChartsInteractorImpl interactor;

    public ChartsPresenterImpl(ChartsView chartsView, Context context) {
        this.chartsView = chartsView;
        this.interactor = new ChartsInteractorImpl(context);
    }

    @Override
    public void showPlayers(ArrayList<Player> players) {
        if (chartsView != null) {
            chartsView.showPlayersList(players);
        }
    }

    @Override
    public void loadPlayersList(int type) {
        if (chartsView != null) {
            interactor.loadPlayers(type, this);
        }
    }

    @Override
    public LineChartData loadChartData(int type) {
        return interactor.loadLineChartData(type);
    }

    @Override
    public void onDestroy() {
        if (chartsView != null) {
            chartsView = null;
        }
    }

}
