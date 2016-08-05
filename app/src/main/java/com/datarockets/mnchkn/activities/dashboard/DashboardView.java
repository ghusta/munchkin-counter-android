package com.datarockets.mnchkn.activities.dashboard;

import com.datarockets.mnchkn.models.Player;

import java.util.List;

public interface DashboardView {
    void finishGame();
    void setItems(List<Player> players);
    void showConfirmFinishGameDialog();
    void updatePlayerData(Player player, int position);
    void keepScreenOn(boolean keepActive);
}
