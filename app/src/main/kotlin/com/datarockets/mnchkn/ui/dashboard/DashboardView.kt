package com.datarockets.mnchkn.ui.dashboard

import com.datarockets.mnchkn.data.model.Player
import com.datarockets.mnchkn.ui.base.BaseView

interface DashboardView : BaseView {
    fun finishGame()
    fun setItems(players: List<Player>)
    fun showConfirmFinishGameDialog()
    fun updatePlayerData(player: Player, position: Int)
    fun keepScreenOn(keepActive: Boolean)
}
