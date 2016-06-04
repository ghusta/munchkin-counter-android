package com.datarockets.mnchkn.fragments.charts;

import lecho.lib.hellocharts.model.LineChartData;

public interface ChartsPresenter {
    void loadPlayersList(int type);
    LineChartData loadChartData(int type);
    void onDestroy();
}
