package com.datarockets.mnchkn.activities.dashboard;

import com.datarockets.mnchkn.models.Player;

public interface DashboardPresenter {
    void checkIsGameStarted();
    void checkIsEnoughPlayers();
    void addNewPlayer(String name);
    void deletePlayerListItem(int position, long id);
    void updatePlayerListItem(Player player, int position);
    void onResume();
    void onDestroy();
}
