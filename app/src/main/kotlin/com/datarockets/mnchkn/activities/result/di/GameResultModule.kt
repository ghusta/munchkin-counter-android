package com.datarockets.mnchkn.activities.result.di

import com.datarockets.mnchkn.activities.result.GameResultInteractor
import com.datarockets.mnchkn.activities.result.GameResultPresenter
import com.datarockets.mnchkn.activities.result.GameResultPresenterImpl
import com.datarockets.mnchkn.activities.result.GameResultView
import com.datarockets.mnchkn.di.ActivityScope

import dagger.Module
import dagger.Provides

@Module class GameResultModule(private val mGameResultView: GameResultView) {

    @ActivityScope @Provides fun providesGameResultView(): GameResultView {
        return mGameResultView
    }

    @ActivityScope @Provides
    fun providesGameResult(gameResultView: GameResultView,
                           gameResultInteractor: GameResultInteractor): GameResultPresenter {
        return GameResultPresenterImpl(gameResultView, gameResultInteractor)
    }

}
