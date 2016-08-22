package com.datarockets.mnchkn.activities.result

import android.content.Context

import com.datarockets.mnchkn.MunchkinApplication
import com.datarockets.mnchkn.activities.BaseInteractor
import com.datarockets.mnchkn.store.GameService
import com.datarockets.mnchkn.store.PlayerService

import javax.inject.Inject

class GameResultInteractorImpl(context: Context) : BaseInteractor(context), GameResultInteractor {

    @Inject
    lateinit var mGameService: GameService
    @Inject
    lateinit var mPlayerService: PlayerService

    override fun setUpComponent(context: Context) {
        MunchkinApplication.get(context).appComponent.inject(this)
    }

    override fun loadGameResults(listener: GameResultInteractor.OnResultsLoaded) {
        mGameService.createPlayerIdGameStepsMap()
        listener.notifyChartDataPrepared()
    }

    override fun clearSteps() {
        mGameService.clearSteps()
    }

    override fun clearPlayerStats() {
        mPlayerService.clearPlayersStats()
    }

}
