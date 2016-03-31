package com.datarockets.mnchkn.activities.dashboard;

import com.datarockets.mnchkn.models.Player;

public interface DashboardPresenter {
    void updatePlayerListItem(Player player, int position);
    void onResume();
    void onDestroy();
    void setGameFinished();
}
