package com.datarockets.mnchkn.activities.dashboard;

import android.content.Context;

import com.datarockets.mnchkn.MunchkinApplication;
import com.datarockets.mnchkn.activities.BaseInteractor;
import com.datarockets.mnchkn.models.Player;
import com.datarockets.mnchkn.store.GameService;
import com.datarockets.mnchkn.store.PlayerService;
import com.datarockets.mnchkn.store.SettingsService;

import javax.inject.Inject;

public class DashboardInteractorImpl extends BaseInteractor implements DashboardInteractor {

    @Inject
    PlayerService mPlayerService;
    @Inject
    GameService mGameService;
    @Inject
    SettingsService mSettingsService;

    public DashboardInteractorImpl(Context context) {
        super(context);
    }

    @Override
    protected void setUpComponent(Context context) {
        MunchkinApplication.get(context).getAppComponent().inject(this);
    }

    @Override
    public void isScreenShouldBeOn(OnScreenStatusListener listener) {
        if (mSettingsService.isWakeLockActive()) {
            listener.onKeepScreenOn();
        } else {
            listener.onKeepScreenOff();
        }
    }

    @Override
    public void loadPlayersList(OnLoadPlayerListener listener) {
        listener.onFinished(mPlayerService.getPlayersList());
    }

    @Override
    public void updatePlayer(Player player, int position, OnLoadPlayerListener listener) {
        listener.onPlayerUpdated(mPlayerService.updatePlayer(player), position);
    }

    @Override
    public void insertStep(Player player) {
        mGameService.insertStep(player);
    }

    @Override
    public void clearPlayersStats() {
        mPlayerService.clearPlayersStats();
    }



    @Override
    public void setGameFinished() {
        mGameService.setGameStatus(false);
    }


}
