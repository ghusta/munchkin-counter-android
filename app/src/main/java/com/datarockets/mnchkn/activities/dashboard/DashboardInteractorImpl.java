package com.datarockets.mnchkn.activities.dashboard;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.datarockets.mnchkn.models.Player;
import com.datarockets.mnchkn.store.PlayerServiceImpl;

public class DashboardInteractorImpl implements DashboardInteractor {

    private static final String IS_GAME_STARTED = "game_started";

    private PlayerServiceImpl playerService;

    public DashboardInteractorImpl(Context context) {
        playerService = PlayerServiceImpl.getInstance(context);
    }

    @Override
    public boolean isGameStarted(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getBoolean(IS_GAME_STARTED, false);
    }

    @Override
    public int countPlayers(OnLoadPlayerListener listener) {
        return playerService.getPlayersList().size();
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
    public void updatePlayer(Player player, int position, OnLoadPlayerListener listener) {
        listener.onPlayerUpdated(playerService.updatePlayer(player), position);
    }


}
