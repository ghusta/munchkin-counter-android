package com.datarockets.mnchkn.fragments.players;

public class PlayerPresenterImpl implements PlayerPresenter {

    PlayerView playerView;

    public PlayerPresenterImpl(PlayerView playerView) {
        this.playerView = playerView;
    }

    @Override
    public void onViewCreated() {
        if (playerView != null) {

        }
    }



}
