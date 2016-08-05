package com.datarockets.mnchkn.activities.dashboard;

import android.content.Context;

import com.datarockets.mnchkn.models.Player;
import com.datarockets.mnchkn.store.GameService;
import com.datarockets.mnchkn.store.GameServiceImpl;
import com.datarockets.mnchkn.store.PlayerService;
import com.datarockets.mnchkn.store.PlayerServiceImpl;
import com.datarockets.mnchkn.store.SettingsService;
import com.datarockets.mnchkn.store.SettingsServiceImpl;

public class DashboardInteractorImpl implements DashboardInteractor {

    private PlayerService mPlayerService;
    private GameService mGameService;
    private SettingsService mSettingsService;

    public DashboardInteractorImpl(Context context) {
        mPlayerService = PlayerServiceImpl.getInstance(context);
        mGameService = GameServiceImpl.getInstance(context);
        mSettingsService = SettingsServiceImpl.getInstance(context);
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
