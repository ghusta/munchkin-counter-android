package com.datarockets.mnchkn.store;

import android.content.Context;

import com.datarockets.mnchkn.models.Player;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;

public class GameServiceImpl {
    private static GameServiceImpl instance;

    private MunchkinDatabaseHelper database;

    private GameServiceImpl(Context context) {
        database = MunchkinDatabaseHelper.getInstance(context);
    }

    public static GameServiceImpl getInstance(Context context) {
        if (instance == null) {
            instance = new GameServiceImpl(context.getApplicationContext());
        }
        return instance;
    }

    public void insertStep(Player player) {

    }

    public LineChartData getPlayersData(int type) {
        List<PointValue> values = new ArrayList<>();
        List<Line> lines = new ArrayList<>();
        LineChartData data = new LineChartData(lines);
        return data;
    }

}
