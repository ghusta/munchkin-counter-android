package com.datarockets.mnchkn.fragments.players;

import com.datarockets.mnchkn.models.Player;

public class PlayerPresenterImpl implements PlayerPresenter {

    PlayerView playerView;
    PlayerInteractor interactor;

    public PlayerPresenterImpl(PlayerView playerView) {
        this.playerView = playerView;
        this.interactor = new PlayerInteractorImpl();
    }

    @Override
    public Player loadPlayer(int index) {
        return interactor.loadPlayerData(index);
    }

}
