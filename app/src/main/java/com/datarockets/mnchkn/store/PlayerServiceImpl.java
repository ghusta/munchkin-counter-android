package com.datarockets.mnchkn.store;

import com.datarockets.mnchkn.models.Player;

import java.util.ArrayList;

public class PlayerServiceImpl implements PlayerService {
    private static PlayerServiceImpl instance;

    ArrayList<Player> playersList;

    private PlayerServiceImpl() {
        playersList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Player player = new Player();
            player.name = "Player " + String.valueOf(i);
            player.strengthScore = i;
            player.levelScore = i;
            playersList.add(player);
        }
    }

    public static PlayerServiceImpl getInstance() {
        if (instance == null) {
            instance = new PlayerServiceImpl();
        }
        return instance;
    }

    @Override
    public void addPlayer(String name) {
        Player player = new Player();
        player.name = name;
        player.levelScore = 0;
        player.strengthScore = 0;
    }

    @Override
    public ArrayList<Player> deletePlayer(int index) {
        playersList.remove(index);
        return playersList;
    }

    @Override
    public ArrayList<Player> getPlayersList() {
        return playersList;
    }

}
