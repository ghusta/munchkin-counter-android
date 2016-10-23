package com.datarockets.mnchkn.ui.charts

import com.datarockets.mnchkn.data.DataManager
import com.datarockets.mnchkn.data.model.Player
import com.datarockets.mnchkn.ui.base.Presenter
import java.util.*

class ChartsPresenterImpl(private val mDataManager: DataManager) : Presenter<ChartsView> {

    private var mChartsView: ChartsView? = null

    override fun attachView(mvpView: ChartsView) {
        mChartsView = mvpView
    }

    override fun detachView() {
        mChartsView = null
    }

    fun showPlayers(players: ArrayList<Player>) {
        if (mChartsView != null) {
            mChartsView!!.showPlayersList(players)
        }
    }

    fun loadPlayersList(type: Int) {
        if (mChartsView != null) {
//            mChartsInteractor.loadPlayers(type, this)
        }
    }
//
    fun loadChartData(type: Int)  {
//      return mChartsInteractor.loadLineChartData(type)
    }

}
