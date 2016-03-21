package com.datarockets.mnchkn.activities.dashboard;

import com.datarockets.mnchkn.models.Player;

import java.util.List;

public interface DashboardInteractor {

    interface OnLoadPlayerListener {
        void onFinished(List<Player> players);
    }

    void loadPlayersList(OnLoadPlayerListener listener);
}
