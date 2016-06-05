package com.datarockets.mnchkn.activities.result;

import android.content.Context;

public class GameResultPresenterImpl implements GameResultPresenter,
        GameResultInteractorImpl.OnResultsLoaded {

    private GameResultView mGameResultView;
    private GameResultInteractor mGameResultInteractor;

    public GameResultPresenterImpl(GameResultView gameResultView, Context context) {
        this.mGameResultView = gameResultView;
        this.mGameResultInteractor = new GameResultInteractorImpl(context);
    }


    @Override
    public void onCreate() {
        if (mGameResultView != null) {
            mGameResultInteractor.loadGameResults(this);
        }
    }

    @Override
    public void notifyChartDataPrepared() {
        if (mGameResultView != null) {
            mGameResultView.loadChartFragments();
        }
    }

    @Override
    public void onBackPressed() {
        if (mGameResultView != null) {
            mGameResultInteractor.clearSteps();
            mGameResultInteractor.clearPlayerStats();
        }
    }

    @Override
    public void onStop() {
        if (mGameResultView != null) {
            mGameResultInteractor.clearSteps();
            mGameResultInteractor.clearPlayerStats();
        }
    }

    @Override
    public void onDestroy() {
        if (mGameResultView != null) {
            mGameResultInteractor.clearSteps();
            mGameResultInteractor.clearPlayerStats();
            mGameResultView = null;
        }
    }

}
