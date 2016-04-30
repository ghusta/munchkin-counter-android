package com.datarockets.mnchkn.activities.players;

import com.datarockets.mnchkn.models.Player;

import java.util.List;

public interface PlayersListView {
    void addPlayerToList(Player player);
    void deletePlayerFromList(int position);
    void setPlayersList(List<Player> players);
    void showAddNewPlayerDialog();
    void launchDashboard();
    void showStartContinueDialog();
    void showWarning();
}