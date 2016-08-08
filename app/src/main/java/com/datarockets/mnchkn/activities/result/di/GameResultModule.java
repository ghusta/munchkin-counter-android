package com.datarockets.mnchkn.activities.result.di;

import com.datarockets.mnchkn.activities.result.GameResultInteractor;
import com.datarockets.mnchkn.activities.result.GameResultPresenter;
import com.datarockets.mnchkn.activities.result.GameResultPresenterImpl;
import com.datarockets.mnchkn.activities.result.GameResultView;
import com.datarockets.mnchkn.di.ActivityScope;

import dagger.Module;
import dagger.Provides;

@Module
public class GameResultModule {

    private GameResultView mGameResultView;

    public GameResultModule(GameResultView gameResultView) {
        this.mGameResultView = gameResultView;
    }

    @ActivityScope
    @Provides
    public GameResultView providesGameResultView() {
        return mGameResultView;
    }

    @ActivityScope
    @Provides
    public GameResultPresenter providesGameResult(GameResultView gameResultView,
                                                  GameResultInteractor gameResultInteractor) {
        return new GameResultPresenterImpl(gameResultView, gameResultInteractor);
    }

}
