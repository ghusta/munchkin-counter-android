package com.datarockets.mnchkn.store;

import android.content.Context;

import com.datarockets.mnchkn.models.Player;
import com.datarockets.mnchkn.utils.ColorUtil;
import com.datarockets.mnchkn.utils.LogUtil;

import java.util.ArrayList;

public class PlayerServiceImpl implements PlayerService {
    private static PlayerServiceImpl instance;

    public static final String TAG = LogUtil.makeLogTag(PlayerServiceImpl.class);

    private MunchkinDatabaseHelper playerDatabase;

    private PlayerServiceImpl(Context context) {
        playerDatabase = MunchkinDatabaseHelper.getInstance(context);
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
        player.setLevelScore(1);
        player.setStrengthScore(1);
        player.setColor(ColorUtil.generatePlayerAvatarColor());
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
    public Player updatePlayer(Player player) {
        return playerDatabase.updatePlayer(player);
    }

    @Override
    public void clearPlayersStats() {
        playerDatabase.clearPlayersStats();
    }

    @Override
    public ArrayList<Player> getPlayersList() {
        return playerDatabase.getPlayers();
    }

    @Override
    public ArrayList<Player> getPlayersListByCategory(int type) {
        return playerDatabase.getPlayersByScore(type);
    }

}
