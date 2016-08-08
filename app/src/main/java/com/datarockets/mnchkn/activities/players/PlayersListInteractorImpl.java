package com.datarockets.mnchkn.activities.players;

import android.content.Context;

import com.datarockets.mnchkn.MunchkinApplication;
import com.datarockets.mnchkn.activities.BaseInteractor;
import com.datarockets.mnchkn.store.GameService;
import com.datarockets.mnchkn.store.PlayerService;
import com.datarockets.mnchkn.utils.LogUtil;

import javax.inject.Inject;

public class PlayersListInteractorImpl extends BaseInteractor implements PlayersListInteractor {

    private static final String TAG = LogUtil.makeLogTag(PlayersListInteractorImpl.class);

    @Inject
    PlayerService mPlayerService;
    @Inject
    GameService mGameService;

    public PlayersListInteractorImpl(Context context) {
        super(context);
    }

    @Override
    protected void setUpComponent(Context context) {
        MunchkinApplication.get(context).getAppComponent().inject(this);
    }

    @Override
    public void clearPlayersStats(OnFinishedListener listener) {
        mPlayerService.clearPlayersStats();
        listener.onPlayersLoaded(mPlayerService.getPlayersList());
    }

    @Override
    public void isGameStarted(OnFinishedListener listener) {
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