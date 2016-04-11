package com.datarockets.mnchkn.activities.result;

public interface GameResultPresenter {
    void loadPlayersStats(int type);
    void onResume();
    void onDestroy();
}
