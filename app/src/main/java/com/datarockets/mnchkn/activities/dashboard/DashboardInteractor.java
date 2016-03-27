package com.datarockets.mnchkn.activities.dashboard;

import com.datarockets.mnchkn.models.Player;

import java.util.ArrayList;
import java.util.List;

public interface DashboardInteractor {

    interface OnLoadPlayerListener {
        void onFinished(ArrayList<Player> players);
        void onPlayerAdded(Player player);
        void onPlayerDeleted(int position);
    }

    void loadPlayersList(OnLoadPlayerListener listener);
    void addPlayer(String name, OnLoadPlayerListener listener);
    void deletePlayer(int position, long id, OnLoadPlayerListener listener);
    void updatePlayer(int index, int level, int strength, OnLoadPlayerListener listener);
}
