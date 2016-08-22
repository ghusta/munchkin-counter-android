package com.datarockets.mnchkn.fragments.players.di

import com.datarockets.mnchkn.di.ActivityScope
import com.datarockets.mnchkn.fragments.players.PlayerInteractor
import com.datarockets.mnchkn.fragments.players.PlayerPresenter
import com.datarockets.mnchkn.fragments.players.PlayerPresenterImpl
import com.datarockets.mnchkn.fragments.players.PlayerView

import dagger.Module
import dagger.Provides

@Module class PlayerModule(private val mPlayerView: PlayerView) {

    @ActivityScope @Provides
    fun providesPlayerView(): PlayerView {
        return mPlayerView
    }

    @ActivityScope @Provides
    fun providesPlayerPresenter(playerView: PlayerView,
                                playerInteractor: PlayerInteractor): PlayerPresenter {
        return PlayerPresenterImpl(playerView, playerInteractor)
    }

}
