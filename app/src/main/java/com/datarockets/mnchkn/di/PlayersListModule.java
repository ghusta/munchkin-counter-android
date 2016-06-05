package com.datarockets.mnchkn.di;

import android.content.Context;

import com.datarockets.mnchkn.activities.players.PlayersListPresenter;
import com.datarockets.mnchkn.activities.players.PlayersListPresenterImpl;
import com.datarockets.mnchkn.activities.players.PlayersListView;

import dagger.Module;
import dagger.Provides;

@Module
public class PlayersListModule {

    private PlayersListView mPlayersListView;
    private Context mContext;

    public PlayersListModule(PlayersListView playersListView, Context context) {
        this.mPlayersListView = playersListView;
        this.mContext = context;
    }

    @Provides
    public PlayersListView playersView() {
        return mPlayersListView;
    }

    @Provides
    public PlayersListPresenter providePresenter() {
        return new PlayersListPresenterImpl(mPlayersListView, mContext);
    }

}
