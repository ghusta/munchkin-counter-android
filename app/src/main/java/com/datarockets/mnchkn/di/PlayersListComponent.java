package com.datarockets.mnchkn.di;

import com.datarockets.mnchkn.activities.players.PlayersListActivity;
import com.datarockets.mnchkn.activities.players.PlayersListPresenter;

import dagger.Component;

@ActivityScope
@Component(dependencies = AppComponent.class, modules = PlayersListModule.class)
public interface PlayersListComponent {
    void inject(PlayersListActivity activity);
    PlayersListPresenter getPlayersListPresenter();
}
