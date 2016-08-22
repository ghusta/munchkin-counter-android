package com.datarockets.mnchkn.activities.dashboard

import com.datarockets.mnchkn.models.Player

interface DashboardPresenter {
    fun updatePlayerListItem(player: Player, position: Int)
    fun onCreate()
    fun onResume()
    fun onDestroy()
    fun setGameFinished()
    fun insertStep(player: Player)
}
