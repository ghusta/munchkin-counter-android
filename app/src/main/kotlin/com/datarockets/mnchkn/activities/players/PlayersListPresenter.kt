package com.datarockets.mnchkn.activities.players

interface PlayersListPresenter {
    fun checkIsEnoughPlayers()
    fun addPlayer(name: String)
    fun deletePlayerListItem(position: Int, id: Long)
    fun clearPlayersStats()
    fun clearGameSteps()
    fun setGameStarted()
    fun setGameFinished()
    fun onCreate()
    fun onResume()
    fun onDestroy()
}
