package com.datarockets.mnchkn.fragments.charts;

import java.util.List;

import lecho.lib.hellocharts.model.Line;

public interface ChartsInteractor {
    interface OnChartLoadedListener {
        void showChart();
    }
    List<Line> loadChartData(int type, OnChartLoadedListener listener);
}
