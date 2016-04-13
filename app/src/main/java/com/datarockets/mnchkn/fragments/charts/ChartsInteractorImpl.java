package com.datarockets.mnchkn.fragments.charts;

import android.content.Context;

import com.datarockets.mnchkn.store.GameServiceImpl;
import com.datarockets.mnchkn.store.PlayerServiceImpl;

public class ChartsInteractorImpl implements ChartsInteractor {

    private GameServiceImpl gameService;
    private PlayerServiceImpl playerService;

    public ChartsInteractorImpl(Context context) {
        gameService = GameServiceImpl.getInstance(context.getApplicationContext());
        playerService = PlayerServiceImpl.getInstance(context.getApplicationContext());
    }

    @Override
    public void loadLineChartData(int type, OnChartLoadedListener listener) {
        listener.setChartDataReady(gameService.createScoresChartData(type, gameService.createPlayerIdGameStepsMap()));
    }

}
