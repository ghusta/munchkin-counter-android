package com.datarockets.mnchkn.activities.dashboard;

public interface DashboardPresenter {
    void deletePlayerListItem(int index);
    void onResume();
    void onDestroy();
}