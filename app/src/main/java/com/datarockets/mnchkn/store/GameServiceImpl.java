package com.datarockets.mnchkn.store;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.datarockets.mnchkn.models.Player;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;

public class GameServiceImpl implements GameService {
    private static GameServiceImpl instance;

    private static final String IS_GAME_STARTED = "is_game_started";

    private MunchkinDatabaseHelper database;
    private SharedPreferences preferences;
    private SharedPreferences.Editor preferencesEditor;

    private GameServiceImpl(Context context) {
        database = MunchkinDatabaseHelper.getInstance(context);
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
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

    public void setGameStatus(boolean status) {
        preferencesEditor = preferences.edit();
        preferencesEditor.putBoolean(IS_GAME_STARTED, status);
        preferencesEditor.apply();
    }

    public boolean getGameStatus() {
        return preferences.getBoolean(IS_GAME_STARTED, false);
    }

}
