package com.datarockets.mnchkn.activities.dashboard;

import android.content.Context;

import com.datarockets.mnchkn.models.Player;
import com.datarockets.mnchkn.store.PlayerServiceImpl;

public class DashboardInteractorImpl implements DashboardInteractor {

    PlayerServiceImpl playerService;

    public DashboardInteractorImpl(Context context) {
        playerService = PlayerServiceImpl.getInstance(context);
    }

    @Override
    public void loadPlayersList(OnLoadPlayerListener listener) {
        listener.onFinished(playerService.getPlayersList());
    }

    @Override
    public void addPlayer(String name, OnLoadPlayerListener listener) {
        listener.onPlayerAdded(playerService.addPlayer(name));
    }

    @Override
    public void deletePlayer(int position, long id, OnLoadPlayerListener listener) {
        listener.onPlayerDeleted(playerService.deletePlayer(position, id));
    }

    @Override
    public void updatePlayer(int index, int level, int strength, OnLoadPlayerListener listener) {
        Player player = new Player();
        player.levelScore = level;
        player.strengthScore = strength;
        listener.onFinished(playerService.updatePlayer(index, player));
    }


}
