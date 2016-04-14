package com.datarockets.mnchkn.activities.result;

import android.content.Context;

import com.datarockets.mnchkn.store.GameServiceImpl;

public class GameResultInteractorImpl implements GameResultInteractor {

    private GameServiceImpl gameService;

    public GameResultInteractorImpl(Context context) {
        gameService = GameServiceImpl.getInstance(context.getApplicationContext());
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

}
