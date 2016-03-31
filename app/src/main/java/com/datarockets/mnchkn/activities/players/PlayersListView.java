package com.datarockets.mnchkn.activities.players;

import com.datarockets.mnchkn.models.Player;

import java.util.ArrayList;

public interface PlayersListView {
    void addPlayerToList(Player player);
    void deletePlayerFromList(int position);
    void setPlayersList(ArrayList<Player> players);
    void showAddNewPlayerDialog();
    void launchDashboard();
    void showStartContinueDialog();
    void showWarning();
}