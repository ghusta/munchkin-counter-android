package com.datarockets.mnchkn.fragments.charts

import com.datarockets.mnchkn.models.Player
import lecho.lib.hellocharts.model.LineChartData
import java.util.*

interface ChartsInteractor {

    interface OnChartLoadedListener {
        fun showPlayers(players: ArrayList<Player>)
    }

    fun loadLineChartData(type: Int): LineChartData
    fun loadPlayers(type: Int, listener: OnChartLoadedListener)

}
