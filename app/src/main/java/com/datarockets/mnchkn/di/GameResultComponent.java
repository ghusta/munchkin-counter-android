package com.datarockets.mnchkn.di;

import com.datarockets.mnchkn.activities.result.GameResultActivity;
import com.datarockets.mnchkn.activities.result.GameResultPresenter;

import dagger.Component;

@ActivityScope
@Component(dependencies = AppComponent.class, modules = GameResultModule.class)
public interface GameResultComponent {
    void inject(GameResultActivity activity);
    GameResultPresenter getGameResultPresenter();
}
