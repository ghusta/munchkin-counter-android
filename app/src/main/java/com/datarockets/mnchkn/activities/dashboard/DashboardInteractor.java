package com.datarockets.mnchkn.activities.dashboard;

import com.datarockets.mnchkn.models.Player;

import java.util.ArrayList;
import java.util.List;

public interface DashboardInteractor {

    interface OnLoadPlayerListener {
        void onFinished(ArrayList<Player> players);
    }

    void loadPlayersList(OnLoadPlayerListener listener);
    void deletePlayer(int index, OnLoadPlayerListener listener);
}