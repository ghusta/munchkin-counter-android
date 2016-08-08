package com.datarockets.mnchkn.activities.players.di;

import com.datarockets.mnchkn.activities.players.PlayersListInteractor;
import com.datarockets.mnchkn.activities.players.PlayersListPresenter;
import com.datarockets.mnchkn.activities.players.PlayersListPresenterImpl;
import com.datarockets.mnchkn.activities.players.PlayersListView;

import dagger.Module;
import dagger.Provides;

@Module
public class PlayersListModule {

    private PlayersListView mPlayersListView;

    public PlayersListModule(PlayersListView playersListView) {
        this.mPlayersListView = playersListView;
    }

    @Provides
    public PlayersListView providesPlayerListView() {
        return mPlayersListView;
    }

    @Provides
    public PlayersListPresenter providesPlayersListPresenter(PlayersListView playersListView,
                                                             PlayersListInteractor interactor) {
        return new PlayersListPresenterImpl(playersListView, interactor);
    }

}
