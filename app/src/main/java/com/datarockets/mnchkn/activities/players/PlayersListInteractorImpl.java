package com.datarockets.mnchkn.activities.players;

import android.content.Context;

import com.datarockets.mnchkn.store.GameServiceImpl;
import com.datarockets.mnchkn.store.PlayerServiceImpl;
import com.datarockets.mnchkn.utils.LogUtil;

public class PlayersListInteractorImpl implements PlayersListInteractor {

    private static final String TAG = LogUtil.makeLogTag(PlayersListInteractorImpl.class);

    private PlayerServiceImpl playerService;
    private GameServiceImpl gameService;

    public PlayersListInteractorImpl(Context context) {
        this.playerService = PlayerServiceImpl.getInstance(context);
        this.gameService = GameServiceImpl.getInstance(context);
    }

    @Override
    public void clearPlayersStats(OnFinishedListener listener) {
        playerService.clearPlayersStats();
        listener.onPlayersLoaded(playerService.getPlayersList());
    }

    @Override
    public void isGameStarted(Context context, OnFinishedListener listener) {
        listener.onGameStarted(gameService.getGameStatus());
    }

    @Override
    public void checkIsEnoughPlayer(OnFinishedListener listener) {
        listener.onPlayersCountChecked(playerService.getPlayersList().size() >= 2);
    }

    @Override
    public void getPlayers(OnFinishedListener listener) {
        listener.onPlayersLoaded(playerService.getPlayersList());
    }

    @Override
    public void addPlayer(String name, OnFinishedListener listener) {
        listener.onPlayerAdded(playerService.addPlayer(name));
    }

    @Override
    public void deletePlayer(int position, long id, OnFinishedListener listener) {
        listener.onPlayerDeleted(playerService.deletePlayer(position, id));
    }

    @Override
    public void setGameStatus(boolean started) {
        gameService.setGameStatus(started);
    }

    @Override
    public void clearGameSteps() {
        gameService.clearSteps();
    }

}