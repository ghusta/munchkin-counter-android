package com.datarockets.mnchkn.fragments.charts;

import android.content.Context;

import com.datarockets.mnchkn.MunchkinApplication;
import com.datarockets.mnchkn.activities.BaseInteractor;
import com.datarockets.mnchkn.store.GameService;
import com.datarockets.mnchkn.store.PlayerService;

import javax.inject.Inject;

import lecho.lib.hellocharts.model.LineChartData;

public class ChartsInteractorImpl extends BaseInteractor implements ChartsInteractor {

    @Inject
    GameService mGameService;
    @Inject
    PlayerService mPlayerService;

    public ChartsInteractorImpl(Context context) {
        super(context);
    }

    @Override
    protected void setUpComponent(Context context) {
        MunchkinApplication.get(context).getAppComponent().inject(this);
    }

    @Override
    public LineChartData loadLineChartData(int type) {
        return mGameService.createScoresChartData(type, mGameService.getScoresChartData());
    }

    @Override
    public void loadPlayers(int type, OnChartLoadedListener listener) {
        listener.showPlayers(mPlayerService.getPlayersList(type));
    }

}
