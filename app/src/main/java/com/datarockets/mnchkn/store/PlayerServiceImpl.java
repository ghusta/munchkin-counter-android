package com.datarockets.mnchkn.store;

import com.datarockets.mnchkn.models.Player;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class PlayerServiceImpl implements PlayerService {
    private static PlayerServiceImpl instance;

    ArrayList<Player> playersList;

    private PlayerServiceImpl() {
        playersList = new ArrayList<>();
    }

    public static PlayerServiceImpl getInstance() {
        if (instance == null) {
            instance = new PlayerServiceImpl();
        }
        return instance;
    }


    @Override
    public ArrayList<Player> addPlayer(String name) {
        Player player = new Player();
        player.name = name;
        player.levelScore = 0;
        player.strengthScore = 0;
        playersList.add(player);
        return playersList;
    }

    @Override
    public ArrayList<Player> deletePlayer(int index) {
        playersList.remove(index);
        return playersList;
    }

    @Override
    public Player getPlayer(int index) {
        return playersList.get(index);
    }

    @Override
    public ArrayList<Player> updatePlayer(int index, Player player) {
        playersList.get(index).setLevelScore(player.levelScore);
        playersList.get(index).setStrengthScore(player.strengthScore);
        return playersList;
    }

    @Override
    public ArrayList<Player> getPlayersList() {
        return playersList;
    }


}
