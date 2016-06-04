package com.datarockets.mnchkn.activities.players;

import android.content.Context;

import com.datarockets.mnchkn.store.GameServiceImpl;
import com.datarockets.mnchkn.store.PlayerServiceImpl;
import com.datarockets.mnchkn.utils.LogUtil;

public class PlayersListInteractorImpl implements PlayersListInteractor {

    private static final String TAG = LogUtil.makeLogTag(PlayersListInteractorImpl.class);

    private PlayerServiceImpl mPlayerService;
    private GameServiceImpl mGameService;

    public PlayersListInteractorImpl(Context context) {
        this.mPlayerService = PlayerServiceImpl.getInstance(context);
        this.mGameService = GameServiceImpl.getInstance(context);
    }

    @Override
    public void clearPlayersStats(OnFinishedListener listener) {
        mPlayerService.clearPlayersStats();
        listener.onPlayersLoaded(mPlayerService.getPlayersList());
    }

    @Override
    public void isGameStarted(Context context, OnFinishedListener listener) {
        listener.onGameStarted(mGameService.isGameStarted());
    }

    @Override
    public void checkIsEnoughPlayer(OnFinishedListener listener) {
        listener.onPlayersCountChecked(mPlayerService.getPlayersList().size() >= 2);
    }

    @Override
    public void getPlayers(OnFinishedListener listener) {
        listener.onPlayersLoaded(mPlayerService.getPlayersList());
    }

    @Override
    public void addPlayer(String name, OnFinishedListener listener) {
        listener.onPlayerAdded(mPlayerService.addPlayer(name));
    }

    @Override
    public void deletePlayer(int position, long id, OnFinishedListener listener) {
        listener.onPlayerDeleted(mPlayerService.deletePlayer(position, id));
    }

    @Override
    public void setGameStatus(boolean started) {
        mGameService.setGameStatus(started);
    }

    @Override
    public void clearGameSteps() {
        mGameService.clearSteps();
    }

}