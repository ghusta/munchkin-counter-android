package com.datarockets.mnchkn.activities.dashboard;

import android.content.Context;

import com.datarockets.mnchkn.models.Player;

import java.util.ArrayList;
import java.util.List;

public interface DashboardInteractor {

    interface OnLoadPlayerListener {
        void onFinished(ArrayList<Player> players);
        void onPlayerAdded(Player player);
        void onPlayerDeleted(int position);
        void onPlayerUpdated(Player player, int position);
    }

    boolean isGameStarted(Context context);
    void loadPlayersList(OnLoadPlayerListener listener);
    void addPlayer(String name, OnLoadPlayerListener listener);
    void deletePlayer(int position, long id, OnLoadPlayerListener listener);
    void updatePlayer(Player player, int position, OnLoadPlayerListener listener);
}
