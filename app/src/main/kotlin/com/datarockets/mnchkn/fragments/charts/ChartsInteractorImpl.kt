package com.datarockets.mnchkn.fragments.charts

import android.content.Context
import com.datarockets.mnchkn.MunchkinApplication
import com.datarockets.mnchkn.activities.BaseInteractor
import com.datarockets.mnchkn.store.GameService
import com.datarockets.mnchkn.store.PlayerService
import lecho.lib.hellocharts.model.LineChartData
import javax.inject.Inject

class ChartsInteractorImpl(context: Context) : BaseInteractor(context), ChartsInteractor {

    @Inject
    lateinit var mGameService: GameService
    @Inject
    lateinit var mPlayerService: PlayerService

    override fun setUpComponent(context: Context) {
        MunchkinApplication.get(context).appComponent.inject(this)
    }

    override fun loadLineChartData(type: Int): LineChartData {
        return mGameService.createScoresChartData(type, mGameService.scoresChartData)
    }

    override fun loadPlayers(type: Int, listener: ChartsInteractor.OnChartLoadedListener) {
        listener.showPlayers(mPlayerService.getPlayersList(type))
    }

}
