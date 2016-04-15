package com.datarockets.mnchkn.activities.result;

import android.content.Context;

import com.datarockets.mnchkn.store.GameServiceImpl;
import com.datarockets.mnchkn.store.PlayerServiceImpl;

public class GameResultInteractorImpl implements GameResultInteractor {

    private GameServiceImpl gameService;
    private PlayerServiceImpl playerService;

    public GameResultInteractorImpl(Context context) {
        gameService = GameServiceImpl.getInstance(context.getApplicationContext());
        playerService = PlayerServiceImpl.getInstance(context.getApplicationContext());
    }

    @Override
    public void loadGameResults(OnResultsLoaded listener) {
        gameService.createPlayerIdGameStepsMap();
        listener.notifyChartDataPrepared();
    }

    @Override
    public void clearSteps() {
        gameService.clearSteps();
    }

    @Override
    public void clearPlayerStats() {
        playerService.clearPlayersStats();
    }

}
