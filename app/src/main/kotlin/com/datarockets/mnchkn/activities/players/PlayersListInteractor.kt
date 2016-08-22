package com.datarockets.mnchkn.activities.players

import com.datarockets.mnchkn.models.Player

interface PlayersListInteractor {

    interface OnFinishedListener {
        fun onPlayersLoaded(players: List<Player>)
        fun onPlayerAdded(player: Player)
        fun onPlayerDeleted(position: Int)
        fun onPlayersCountChecked(enough: Boolean)
        fun onGameStarted(started: Boolean)
    }

    fun clearPlayersStats(listener: OnFinishedListener)
    fun isGameStarted(listener: OnFinishedListener)
    fun checkIsEnoughPlayer(listener: OnFinishedListener)
    fun getPlayers(listener: OnFinishedListener)
    fun addPlayer(name: String, listener: OnFinishedListener)
    fun deletePlayer(position: Int, id: Long, listener: OnFinishedListener)
    fun setGameStatus(started: Boolean)
    fun clearGameSteps()

}
