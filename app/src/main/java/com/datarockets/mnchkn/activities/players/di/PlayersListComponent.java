package com.datarockets.mnchkn.activities.players.di;

import com.datarockets.mnchkn.activities.players.PlayersListActivity;
import com.datarockets.mnchkn.activities.players.PlayersListPresenter;
import com.datarockets.mnchkn.di.ActivityScope;
import com.datarockets.mnchkn.di.AppComponent;

import dagger.Component;

@ActivityScope
@Component(dependencies = AppComponent.class, modules = PlayersListModule.class)
public interface PlayersListComponent {
    void inject(PlayersListActivity playersListActivity);
    PlayersListPresenter getPlayersListPresenter();
}