package com.datarockets.mnchkn.ui.playerslist

import com.datarockets.mnchkn.data.model.Player
import com.datarockets.mnchkn.ui.base.BaseView

interface PlayersListView : BaseView {
    fun addPlayerToList(player: Player)
    fun deletePlayerFromList(position: Int)
    fun setPlayersList(players: MutableList<Player>)
    fun showAddNewPlayerDialog()
    fun launchDashboard()
    fun showStartContinueDialog()
    fun showWarning()
}