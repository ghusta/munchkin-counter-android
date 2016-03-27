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
    public Player addPlayer(String name) {
        Player player = new Player();
        player.setName(name);
        player.setLevelScore(0);
        player.setStrengthScore(0);
        long id = playerDatabase.addPlayer(player);
        player.setId(id);
        return player;
    }

    @Override
    public int deletePlayer(int position, long id) {
        playerDatabase.deletePlayer(id);
        return position;
    }

    @Override
    public ArrayList<Player> updatePlayer(int index, Player player) {
        playerDatabase.updatePlayer(index, player);
        return playerDatabase.getPlayers();
    }

    @Override
    public ArrayList<Player> getPlayersList() {
        return playerDatabase.getPlayers();
    }


}
