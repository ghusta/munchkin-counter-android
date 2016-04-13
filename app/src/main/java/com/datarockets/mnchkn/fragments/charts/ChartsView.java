package com.datarockets.mnchkn.fragments.charts;

import com.datarockets.mnchkn.models.Player;

import java.util.ArrayList;

import lecho.lib.hellocharts.model.LineChartData;

public interface ChartsView {
    void drawChart(LineChartData lineChartData);
    void showPlayersList(ArrayList<Player> players);
}
