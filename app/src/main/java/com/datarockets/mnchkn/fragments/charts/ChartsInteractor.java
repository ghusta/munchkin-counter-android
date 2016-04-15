package com.datarockets.mnchkn.fragments.charts;

import com.datarockets.mnchkn.models.Player;

import java.util.ArrayList;

import lecho.lib.hellocharts.model.LineChartData;

public interface ChartsInteractor {

    interface OnChartLoadedListener {
        void showPlayers(ArrayList<Player> players);
    }

    LineChartData loadLineChartData(int type);
    void loadPlayers(int type, OnChartLoadedListener listener);

}
