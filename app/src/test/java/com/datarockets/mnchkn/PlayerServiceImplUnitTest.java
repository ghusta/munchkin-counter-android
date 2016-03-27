package com.datarockets.mnchkn;


import com.datarockets.mnchkn.activities.dashboard.DashboardActivity;
import com.datarockets.mnchkn.models.Player;
import com.datarockets.mnchkn.store.PlayerServiceImpl;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import java.util.ArrayList;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class PlayerServiceImplUnitTest {

    @Test
    public void addNewPlayer() {
        String desiredName = "Dzmitry";
        DashboardActivity activity = Robolectric.setupActivity(DashboardActivity.class);
        PlayerServiceImpl playerService = PlayerServiceImpl.getInstance(activity.getApplicationContext());
        playerService.addPlayer(desiredName);
        ArrayList<Player> players = playerService.getPlayersList();
        Assert.assertEquals(desiredName, players.get(0).name);
    }

}
