package com.datarockets.mnchkn.store;

import com.datarockets.mnchkn.models.GameStep;
import com.datarockets.mnchkn.models.Player;

import java.util.List;
import java.util.Map;

import lecho.lib.hellocharts.model.LineChartData;

public interface GameService {
    void insertStep(Player player);
    void clearSteps();
    void createPlayerIdGameStepsMap();
    Map<Player, List<GameStep>> getScoresChartData();
    LineChartData createScoresChartData(int type, Map<Player, List<GameStep>> playerGameStepsMap);
    void setGameStatus(boolean status);
}
