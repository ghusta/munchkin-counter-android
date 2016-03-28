package com.datarockets.mnchkn.fragments.charts;

import android.content.Context;

import com.datarockets.mnchkn.store.GameServiceImpl;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.Line;

public class ChartsInteractorImpl implements ChartsInteractor {

    private GameServiceImpl gameService;

    public ChartsInteractorImpl(Context context) {
        gameService = GameServiceImpl.getInstance(context.getApplicationContext());
    }

    @Override
    public List<Line> loadChartData(int type, OnChartLoadedListener listener) {
        return new ArrayList<Line>();
    }

}
