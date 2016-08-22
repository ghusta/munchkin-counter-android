package com.datarockets.mnchkn.activities.players

import com.datarockets.mnchkn.models.Player

interface PlayersListView {
    fun addPlayerToList(player: Player)
    fun deletePlayerFromList(position: Int)
    fun setPlayersList(players: List<Player>)
    fun showAddNewPlayerDialog()
    fun launchDashboard()
    fun showStartContinueDialog()
    fun showWarning()
}