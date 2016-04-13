package com.datarockets.mnchkn.activities.result;

import android.content.Context;

import com.datarockets.mnchkn.models.GameStep;
import com.datarockets.mnchkn.models.Player;
import com.datarockets.mnchkn.store.GameServiceImpl;

import java.util.List;
import java.util.Map;

public class GameResultInteractorImpl implements GameResultInteractor {

    private GameServiceImpl gameService;

    public GameResultInteractorImpl(Context context) {
        gameService = GameServiceImpl.getInstance(context.getApplicationContext());
    }

    @Override
    public void loadGameResults(OnResultsLoaded listener) {
        Map<Player, List<GameStep>> gameSteps = gameService.createPlayerIdGameStepsMap();
        listener.setLevelScoresChartData(gameService.createScoresChartData(0, gameSteps));
        listener.setStrengthScoresChartData(gameService.createScoresChartData(1, gameSteps));
        listener.setSummaryScoresChartData(gameService.createScoresChartData(2, gameSteps));
    }

    @Override
    public void clearSteps() {
        gameService.clearSteps();
    }

}
