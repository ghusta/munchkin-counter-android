package com.datarockets.mnchkn.activities.result;

import android.content.Context;

import com.datarockets.mnchkn.MunchkinApplication;
import com.datarockets.mnchkn.activities.BaseInteractor;
import com.datarockets.mnchkn.store.GameService;
import com.datarockets.mnchkn.store.PlayerService;

import javax.inject.Inject;

public class GameResultInteractorImpl extends BaseInteractor implements GameResultInteractor {

    @Inject
    GameService mGameService;
    @Inject
    PlayerService mPlayerService;

    public GameResultInteractorImpl(Context context) {
        super(context);
    }

    @Override
    protected void setUpComponent(Context context) {
        MunchkinApplication.get(context).getAppComponent().inject(this);
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
