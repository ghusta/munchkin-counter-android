package com.datarockets.mnchkn.fragments.charts;

import android.content.Context;

import com.datarockets.mnchkn.store.GameService;
import com.datarockets.mnchkn.store.GameServiceImpl;
import com.datarockets.mnchkn.store.PlayerService;
import com.datarockets.mnchkn.store.PlayerServiceImpl;

import lecho.lib.hellocharts.model.LineChartData;

public class ChartsInteractorImpl implements ChartsInteractor {

    private GameService mGameService;
    private PlayerService mPlayerService;

    public ChartsInteractorImpl(Context context) {
        mGameService = GameServiceImpl.getInstance(context);
        mPlayerService = PlayerServiceImpl.getInstance(context);
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
