package com.datarockets.mnchkn.activities.dashboard

import com.datarockets.mnchkn.models.Player

interface DashboardView {
    fun finishGame()
    fun setItems(players: List<Player>)
    fun showConfirmFinishGameDialog()
    fun updatePlayerData(player: Player, position: Int)
    fun keepScreenOn(keepActive: Boolean)
}
