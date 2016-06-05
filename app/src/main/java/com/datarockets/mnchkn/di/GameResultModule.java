package com.datarockets.mnchkn.di;

import android.content.Context;

import com.datarockets.mnchkn.activities.result.GameResultPresenter;
import com.datarockets.mnchkn.activities.result.GameResultPresenterImpl;
import com.datarockets.mnchkn.activities.result.GameResultView;

import dagger.Module;
import dagger.Provides;

@Module
public class GameResultModule {

    private GameResultView mGameResultView;
    private Context mContext;

    public GameResultModule(GameResultView gameResultView, Context context) {
        this.mGameResultView = gameResultView;
        this.mContext = context;
    }

    @Provides
    GameResultView provideView() {
        return mGameResultView;
    }

    @Provides
    GameResultPresenter provideGameResultPresenter() {
        return new GameResultPresenterImpl(mGameResultView, mContext);
    }

}
