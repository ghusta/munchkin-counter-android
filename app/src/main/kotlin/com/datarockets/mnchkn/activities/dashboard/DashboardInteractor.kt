package com.datarockets.mnchkn.activities.dashboard

import com.datarockets.mnchkn.models.Player

import java.util.ArrayList

interface DashboardInteractor {

    interface OnLoadPlayerListener {
        fun onFinished(players: ArrayList<Player>)
        fun onPlayerUpdated(player: Player, position: Int)
    }

    interface OnScreenStatusListener {
        fun onKeepScreenOn()
        fun onKeepScreenOff()
    }

    fun isScreenShouldBeOn(listener: OnScreenStatusListener)
    fun loadPlayersList(listener: OnLoadPlayerListener)
    fun updatePlayer(player: Player, position: Int, listener: OnLoadPlayerListener)
    fun insertStep(player: Player)
    fun clearPlayersStats()
    fun setGameFinished()
}
