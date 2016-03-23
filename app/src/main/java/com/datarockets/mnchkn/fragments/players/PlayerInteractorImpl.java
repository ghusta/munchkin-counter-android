package com.datarockets.mnchkn.fragments.players;

import com.datarockets.mnchkn.models.Player;
import com.datarockets.mnchkn.store.PlayerServiceImpl;

public class PlayerInteractorImpl implements PlayerInteractor {

    PlayerServiceImpl playerService;

    public PlayerInteractorImpl() {
        playerService = PlayerServiceImpl.getInstance();
    }

    @Override
    public Player loadPlayerData(int index) {
        return playerService.getPlayer(index);
    }

}
