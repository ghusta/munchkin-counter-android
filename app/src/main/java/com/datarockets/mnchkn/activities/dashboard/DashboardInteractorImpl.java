package com.datarockets.mnchkn.activities.dashboard;

import com.datarockets.mnchkn.store.PlayerServiceImpl;

public class DashboardInteractorImpl implements DashboardInteractor {

    PlayerServiceImpl playerService;

    public DashboardInteractorImpl() {
        playerService = PlayerServiceImpl.getInstance();
    }

    @Override
    public void loadPlayersList(OnLoadPlayerListener listener) {
        listener.onFinished(playerService.getPlayersList());
    }

    @Override
    public void addPlayer(String name, OnLoadPlayerListener listener) {
        listener.onFinished(playerService.addPlayer(name));
    }

    @Override
    public void deletePlayer(int index, OnLoadPlayerListener listener) {
        listener.onFinished(playerService.deletePlayer(index));
    }

}
