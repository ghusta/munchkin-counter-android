package com.datarockets.mnchkn.fragments.players.di;

import com.datarockets.mnchkn.di.ActivityScope;
import com.datarockets.mnchkn.di.AppComponent;
import com.datarockets.mnchkn.fragments.players.PlayerFragment;

import dagger.Component;

@ActivityScope
@Component(dependencies = AppComponent.class, modules = PlayerModule.class)
public interface PlayerComponent {
    void inject(PlayerFragment playerFragment);
}
