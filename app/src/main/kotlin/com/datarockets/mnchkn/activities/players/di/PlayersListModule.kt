package com.datarockets.mnchkn.activities.players.di

import com.datarockets.mnchkn.activities.players.PlayersListInteractor
import com.datarockets.mnchkn.activities.players.PlayersListPresenter
import com.datarockets.mnchkn.activities.players.PlayersListPresenterImpl
import com.datarockets.mnchkn.activities.players.PlayersListView

import dagger.Module
import dagger.Provides

@Module class PlayersListModule(private val mPlayersListView: PlayersListView) {

    @Provides
    fun providesPlayerListView(): PlayersListView {
        return mPlayersListView
    }

    @Provides
    fun providesPlayersListPresenter(playersListView: PlayersListView,
                                     interactor: PlayersListInteractor): PlayersListPresenter {
        return PlayersListPresenterImpl(playersListView, interactor)
    }

}
