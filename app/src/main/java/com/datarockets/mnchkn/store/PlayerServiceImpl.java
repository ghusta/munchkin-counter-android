package com.datarockets.mnchkn.store;

import com.datarockets.mnchkn.models.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayerServiceImpl implements PlayerService {
    private static PlayerServiceImpl instance;
    private PlayerServiceImpl() {}

    List<Player> playersList = new ArrayList<>();

    public static PlayerServiceImpl getInstance() {
        if (instance == null) {
            instance = new PlayerServiceImpl();
        }
        return instance;
    }

    @Override
    public void addPlayer(String name) {
    }

    @Override
    public void deletePlayer(int index) {

    }

    @Override
    public List<Player> getPlayersList() {
        return playersList;
    }

}
