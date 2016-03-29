package com.datarockets.mnchkn.store;

import android.content.Context;

import com.datarockets.mnchkn.models.Player;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;

public class GameServiceImpl implements GameService {
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
        return database.getLineChartData();
    }

}
