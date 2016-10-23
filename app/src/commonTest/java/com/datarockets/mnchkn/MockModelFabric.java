package com.datarockets.mnchkn;

import com.datarockets.mnchkn.data.model.GameStep;
import com.datarockets.mnchkn.data.model.Player;

public class MockModelFabric {

    public static Player newPlayer() {
        Player player = new Player();
        player.setId(0);
        player.setName("Custom Player");
        return player;
    }

    public static GameStep newStep() {
        GameStep gameStep = new GameStep();
        gameStep.setPlayerId(1);
        gameStep.setPlayerLevel(1);
        gameStep.setPlayerLevel(1);
        return gameStep;
    }

}
