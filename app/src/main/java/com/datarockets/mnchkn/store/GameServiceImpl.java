package com.datarockets.mnchkn.store;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.PreferenceManager;

import com.datarockets.mnchkn.models.GameStep;
import com.datarockets.mnchkn.models.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;

public class GameServiceImpl implements GameService {
    private static GameServiceImpl instance;

    private static final String IS_GAME_STARTED = "is_game_started";

    private MunchkinDatabaseHelper database;
    private SharedPreferences preferences;
    private SharedPreferences.Editor preferencesEditor;
    private Map<Player, List<GameStep>> gameStepsMap;

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

    @Override
    public void insertStep(Player player) {
        GameStep gameStep = new GameStep();
        gameStep.setPlayerId(player.getId());
        gameStep.setPlayerLevel(player.getLevelScore());
        gameStep.setPlayerStrength(player.getStrengthScore());
        database.insertStep(gameStep);
    }

    @Override
    public void createPlayerIdGameStepsMap() {
        List<Player> playersList = database.getPlayers();
        List<GameStep> gameSteps = database.getGameSteps();

        Map<Player, List<GameStep>> playerGameStepsMap = new HashMap<>();
        for (Player player : playersList) {
            List<GameStep> playerSteps = new ArrayList<>();
            for (GameStep step : gameSteps) {
                if (step.getPlayerId() == player.getId()) {
                    playerSteps.add(step);
                }
            }
            playerGameStepsMap.put(player, playerSteps);
        }
        gameStepsMap = playerGameStepsMap;
    }

    @Override
    public Map<Player, List<GameStep>> getScoresChartData() {
        return gameStepsMap;
    }

    @Override
    public LineChartData createScoresChartData(int type, Map<Player, List<GameStep>> playerGameStepsMap) {
        List<Line> playersLines = new ArrayList<>();
        List<String> playerColors = new ArrayList<>();

        for (Player player : playerGameStepsMap.keySet()) {
            String color = player.getColor();
            playerColors.add(color);
        }

        for (List<GameStep> gameSteps : playerGameStepsMap.values()) {
            List<PointValue> pointValues = new ArrayList<>();
            for (int i = 0; i < gameSteps.size(); i++) {
                switch (type) {
                    case 0:
                        pointValues.add(new PointValue(i, gameSteps.get(i).getPlayerLevel()));
                        break;
                    case 1:
                        pointValues.add(new PointValue(i, gameSteps.get(i).getPlayerStrength()));
                        break;
                    case 2:
                        pointValues.add(new PointValue(i, gameSteps.get(i).getPlayerLevel() + gameSteps.get(i).getPlayerStrength()));
                        break;
                }
            }
            Line line = new Line();
            line.setValues(pointValues);
            line.setHasPoints(false);
            line.setCubic(true);
            playersLines.add(line);
        }

        for (int i = 0; i < playersLines.size(); i++) {
            playersLines.get(i).setColor(Color.parseColor(playerColors.get(i)));
        }

        LineChartData lineChartData = new LineChartData(playersLines);
        lineChartData.setAxisXBottom(new Axis());
        lineChartData.setAxisYLeft(new Axis().setHasLines(true));
        return lineChartData.setLines(playersLines);
    }

    @Override
    public void clearSteps() {
        database.clearSteps();
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
