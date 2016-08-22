package com.datarockets.mnchkn.activities.result

interface GameResultInteractor {

    interface OnResultsLoaded {
        fun notifyChartDataPrepared()
    }

    fun loadGameResults(listener: OnResultsLoaded)
    fun clearSteps()
    fun clearPlayerStats()

}
