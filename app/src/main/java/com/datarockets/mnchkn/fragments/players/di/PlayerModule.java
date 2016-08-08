package com.datarockets.mnchkn.fragments.players.di;

import com.datarockets.mnchkn.di.ActivityScope;
import com.datarockets.mnchkn.fragments.players.PlayerInteractor;
import com.datarockets.mnchkn.fragments.players.PlayerPresenter;
import com.datarockets.mnchkn.fragments.players.PlayerPresenterImpl;
import com.datarockets.mnchkn.fragments.players.PlayerView;

import dagger.Module;
import dagger.Provides;

@Module
public class PlayerModule {

    private PlayerView mPlayerView;

    public PlayerModule(PlayerView playerView) {
        this.mPlayerView = playerView;
    }

    @ActivityScope
    @Provides
    public PlayerView providesPlayerView() {
        return mPlayerView;
    }

    @ActivityScope
    @Provides
    public PlayerPresenter providesPlayerPresenter(PlayerView playerView,
                                                   PlayerInteractor playerInteractor) {
        return new PlayerPresenterImpl(playerView, playerInteractor);
    }

}
