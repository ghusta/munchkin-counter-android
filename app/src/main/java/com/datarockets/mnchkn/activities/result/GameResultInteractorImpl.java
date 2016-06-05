package com.datarockets.mnchkn.activities.result;

import android.content.Context;

import com.datarockets.mnchkn.store.GameService;
import com.datarockets.mnchkn.store.GameServiceImpl;
import com.datarockets.mnchkn.store.PlayerService;
import com.datarockets.mnchkn.store.PlayerServiceImpl;

public class GameResultInteractorImpl implements GameResultInteractor {

    private GameService mGameService;
    private PlayerService mPlayerService;

    public GameResultInteractorImpl(Context context) {
        mGameService = GameServiceImpl.getInstance(context.getApplicationContext());
        mPlayerService = PlayerServiceImpl.getInstance(context.getApplicationContext());
    }

    @Override
    public void loadGameResults(OnResultsLoaded listener) {
        mGameService.createPlayerIdGameStepsMap();
        listener.notifyChartDataPrepared();
    }

    @Override
    public void clearSteps() {
        mGameService.clearSteps();
    }

    @Override
    public void clearPlayerStats() {
        mPlayerService.clearPlayersStats();
    }

}
