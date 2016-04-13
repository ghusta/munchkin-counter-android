package com.datarockets.mnchkn.activities.result;

import lecho.lib.hellocharts.model.LineChartData;

public interface GameResultView {
    void showProgressBar();
    void hideProgressBar();
    void sendLevelScoresChartData(LineChartData levelScoresChartData);
    void sendStrengthScoresChartData(LineChartData strengthScoresChartData);
    void sendSummaryScoresChartData(LineChartData summaryScoresChartData);
}
