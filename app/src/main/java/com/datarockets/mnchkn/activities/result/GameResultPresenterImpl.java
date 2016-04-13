package com.datarockets.mnchkn.activities.result;

import android.content.Context;

import lecho.lib.hellocharts.model.LineChartData;

public class GameResultPresenterImpl implements GameResultPresenter, GameResultInteractorImpl.OnResultsLoaded {

    GameResultView gameResultView;
    GameResultInteractorImpl interactor;

    public GameResultPresenterImpl(GameResultView gameResultView, Context context) {
        this.gameResultView = gameResultView;
        this.interactor = new GameResultInteractorImpl(context);
    }

    @Override
    public void onCreate() {
        if (gameResultView != null) {
            interactor.loadGameResults(this);
        }
    }

    @Override
    public void onDestroy() {
        if (gameResultView != null) {
            interactor.clearSteps();
            gameResultView = null;
        }
    }

    @Override
    public void setLevelScoresChartData(LineChartData scoresChartData) {
        if (gameResultView != null) {
            gameResultView.sendLevelScoresChartData(scoresChartData);
        }
    }

    @Override
    public void setStrengthScoresChartData(LineChartData strengthScoresChartData) {
        if (gameResultView != null) {
            gameResultView.sendStrengthScoresChartData(strengthScoresChartData);
        }
    }

    @Override
    public void setSummaryScoresChartData(LineChartData summaryScoresChartData) {
        if (gameResultView != null) {
            gameResultView.sendSummaryScoresChartData(summaryScoresChartData);
        }
    }

}
