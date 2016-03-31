package com.datarockets.mnchkn.activities.dashboard;

import android.content.Context;

import com.datarockets.mnchkn.models.Player;
import com.datarockets.mnchkn.store.GameServiceImpl;
import com.datarockets.mnchkn.store.PlayerServiceImpl;

public class DashboardInteractorImpl implements DashboardInteractor {

    private PlayerServiceImpl playerService;
    private GameServiceImpl gameService;

    public DashboardInteractorImpl(Context context) {
        playerService = PlayerServiceImpl.getInstance(context);
        gameService = GameServiceImpl.getInstance(context);
    }

    @Override
    public void loadPlayersList(OnLoadPlayerListener listener) {
        listener.onFinished(playerService.getPlayersList());
    }

    @Override
    public void updatePlayer(Player player, int position, OnLoadPlayerListener listener) {
        listener.onPlayerUpdated(playerService.updatePlayer(player), position);
    }

    @Override
    public void clearPlayersStats() {
        playerService.clearPlayersStats();
    }

    @Override
    public void setGameFinished() {
        gameService.setGameStatus(false);
    }


}
