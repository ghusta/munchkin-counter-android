package com.datarockets.mnchkn.activities.result;

import lecho.lib.hellocharts.model.LineChartData;

public interface GameResultInteractor {

    interface OnResultsLoaded {
        void setLevelScoresChartData(LineChartData scoresChartData);
        void setStrengthScoresChartData(LineChartData strengthScoresChartData);
        void setSummaryScoresChartData(LineChartData summaryScoresChartData);
    }

    void loadGameResults(OnResultsLoaded listener);
    void clearSteps();

}
