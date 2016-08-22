package com.datarockets.mnchkn.fragments.charts

import lecho.lib.hellocharts.model.LineChartData

interface ChartsPresenter {
    fun loadPlayersList(type: Int)
    fun loadChartData(type: Int): LineChartData
    fun onDestroy()
}
