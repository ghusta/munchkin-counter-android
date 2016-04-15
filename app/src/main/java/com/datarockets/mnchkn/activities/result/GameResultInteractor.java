package com.datarockets.mnchkn.activities.result;

public interface GameResultInteractor {

    interface OnResultsLoaded {
        void notifyChartDataPrepared();
    }

    void loadGameResults(OnResultsLoaded listener);
    void clearSteps();
    void clearPlayerStats();

}
