package com.datarockets.mnchkn.activities.dashboard;

public interface DashboardPresenter {
    void addNewPlayer(String name);
    void deletePlayerListItem(int position, long id);
    void updatePlayerListItem(int index, int currentLevel, int currentStrength);
    void onResume();
    void onDestroy();
}
