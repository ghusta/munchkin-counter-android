package com.datarockets.mnchkn.fragments.charts;

import com.datarockets.mnchkn.models.Player;

import java.util.ArrayList;

import lecho.lib.hellocharts.model.LineChartData;

public interface ChartsInteractor {

    interface OnChartLoadedListener {
        void showPlayers(ArrayList<Player> players);
        void setChartDataReady(LineChartData lineChartData);
    }

    void loadLineChartData(int type, OnChartLoadedListener listener);

}
