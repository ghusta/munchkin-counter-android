package com.datarockets.mnchkn.fragments.players;

import android.content.Context;

import com.datarockets.mnchkn.models.Player;

public class PlayerPresenterImpl implements PlayerPresenter {

    PlayerView playerView;

    public PlayerPresenterImpl(PlayerView playerView) {
        this.playerView = playerView;
    }

}
