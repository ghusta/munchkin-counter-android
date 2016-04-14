package com.datarockets.mnchkn.fragments.charts;

import com.datarockets.mnchkn.models.Player;

import java.util.ArrayList;

import lecho.lib.hellocharts.model.LineChartData;

public interface ChartsPresenter {
    ArrayList<Player> loadPlayers();
    LineChartData loadChartData(int type);
    void onDestroy();
}
