package com.datarockets.mnchkn.activities.result.di;

import com.datarockets.mnchkn.activities.result.GameResultActivity;
import com.datarockets.mnchkn.di.ActivityScope;
import com.datarockets.mnchkn.di.AppComponent;

import dagger.Component;

@ActivityScope
@Component(dependencies = AppComponent.class, modules = GameResultModule.class)
public interface GameResultComponent {
    void inject(GameResultActivity activity);
}
