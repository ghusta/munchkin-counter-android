package com.datarockets.mnchkn.fragments.charts

import com.datarockets.mnchkn.models.Player

import java.util.ArrayList

import lecho.lib.hellocharts.model.LineChartData

class ChartsPresenterImpl(private var mChartsView: ChartsView?, private val mChartsInteractor: ChartsInteractor) : ChartsPresenter, ChartsInteractor.OnChartLoadedListener {

    override fun showPlayers(players: ArrayList<Player>) {
        if (mChartsView != null) {
            mChartsView!!.showPlayersList(players)
        }
    }

    override fun loadPlayersList(type: Int) {
        if (mChartsView != null) {
            mChartsInteractor.loadPlayers(type, this)
        }
    }

    override fun loadChartData(type: Int): LineChartData {
        return mChartsInteractor.loadLineChartData(type)
    }

    override fun onDestroy() {
        if (mChartsView != null) {
            mChartsView = null
        }
    }

}
