package com.datarockets.mnchkn;


import com.datarockets.mnchkn.models.Player;
import com.datarockets.mnchkn.store.MunchkinDatabaseHelper;
import com.datarockets.mnchkn.store.PlayerServiceImpl;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import java.lang.reflect.Field;
import java.util.ArrayList;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class PlayerServiceImplUnitTest {

    @Test
    public void addPlayer() throws Exception {
        String name = "Alex";
        DashboardActivity activity = Robolectric.setupActivity(DashboardActivity.class);
        PlayerServiceImpl playerService = PlayerServiceImpl.getInstance(activity.getApplicationContext());
        playerService.addPlayer(name);
        ArrayList<Player> players = playerService.getPlayersList();
        Assert.assertEquals(name, players.get(0).getName());
        resetDatabase();
    }

    @Test
    public void deletePlayer() throws Exception {
        String name = "Alex";
        DashboardActivity activity = Robolectric.setupActivity(DashboardActivity.class);
        PlayerServiceImpl playerService = PlayerServiceImpl.getInstance(activity.getApplicationContext());
        Player savedPlayer = playerService.addPlayer(name);
        ArrayList<Player> players = playerService.getPlayersList();
        Assert.assertEquals(name, players.get(0).getName());
        playerService.deletePlayer(0, savedPlayer.getId());
        Assert.assertEquals(0, playerService.getPlayersList().size());
        resetDatabase();
    }

    private void resetDatabase() throws Exception {
        Field field = MunchkinDatabaseHelper.class.getDeclaredField("instance");
        field.setAccessible(true);
        field.set(null, null);
    }

}
