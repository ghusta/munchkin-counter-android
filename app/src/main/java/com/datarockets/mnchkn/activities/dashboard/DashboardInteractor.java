package com.datarockets.mnchkn.activities.dashboard;

import com.datarockets.mnchkn.models.Player;

import java.util.ArrayList;

public interface DashboardInteractor {

    interface OnLoadPlayerListener {
        void onFinished(ArrayList<Player> players);
        void onPlayerUpdated(Player player, int position);
    }

    void loadPlayersList(OnLoadPlayerListener listener);
    void updatePlayer(Player player, int position, OnLoadPlayerListener listener);
    void clearPlayersStats();
    void setGameFinished();
}
