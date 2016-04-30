package com.datarockets.mnchkn.fragments.charts;

import android.content.Context;

import com.datarockets.mnchkn.store.GameServiceImpl;
import com.datarockets.mnchkn.store.PlayerServiceImpl;

import lecho.lib.hellocharts.model.LineChartData;

public class ChartsInteractorImpl implements ChartsInteractor {

    private GameServiceImpl gameService;
    private PlayerServiceImpl playerService;

    public ChartsInteractorImpl(Context context) {
        gameService = GameServiceImpl.getInstance(context);
        playerService = PlayerServiceImpl.getInstance(context);
    }

    @Override
    public LineChartData loadLineChartData(int type) {
        return gameService.createScoresChartData(type, gameService.getScoresChartData());
    }

    @Override
    public void loadPlayers(int type, OnChartLoadedListener listener) {
        listener.showPlayers(playerService.getPlayersList(type));
    }

}
