package com.datarockets.mnchkn.activities.dashboard;

import com.datarockets.mnchkn.models.Player;

import java.util.List;

public interface DashboardView {
    void showDiceRollResultDialog();
    void finishGame();
    void setItems(List<Player> players);
    void openSettingsActivity();
    void showConfirmFinishGameDialog();
    void showAddNewPlayerDialog();
}
