package com.datarockets.mnchkn.store;

import android.content.Context;

import com.datarockets.mnchkn.models.Player;
import com.datarockets.mnchkn.utils.LogUtil;

import java.util.ArrayList;

public class PlayerServiceImpl implements PlayerService {
    private static PlayerServiceImpl instance;

    public static final String TAG = LogUtil.makeLogTag(PlayerServiceImpl.class);

    PlayerDatabaseHelper playerDatabase;

    private PlayerServiceImpl(Context context) {
        playerDatabase = PlayerDatabaseHelper.getInstance(context);
    }

    public static PlayerServiceImpl getInstance(Context context) {
        if (instance == null) {
            instance = new PlayerServiceImpl(context);
        }
        return instance;
    }

    @Override
    public ArrayList<Player> addPlayer(String name) {
        Player player = new Player();
        player.name = name;
        player.levelScore = 0;
        player.strengthScore = 0;
        playerDatabase.addPlayer(player);
        return getPlayersList();
    }

    @Override
    public ArrayList<Player> deletePlayer(int index) {
        playerDatabase.deletePlayer(index);
        return (ArrayList<Player>) playerDatabase.getPlayers();
    }

    @Override
    public ArrayList<Player> updatePlayer(int index, Player player) {
        playerDatabase.updatePlayer(index, player);
        return (ArrayList<Player>)playerDatabase.getPlayers();
    }

    @Override
    public ArrayList<Player> getPlayersList() {
        return (ArrayList<Player>) playerDatabase.getPlayers();
    }


}
