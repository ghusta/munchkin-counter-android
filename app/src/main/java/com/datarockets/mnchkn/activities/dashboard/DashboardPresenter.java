package com.datarockets.mnchkn.activities.dashboard;

public interface DashboardPresenter {
    void addNewPlayer(String name);
    void deletePlayerListItem(int index);
    void onResume();
    void onDestroy();
}
