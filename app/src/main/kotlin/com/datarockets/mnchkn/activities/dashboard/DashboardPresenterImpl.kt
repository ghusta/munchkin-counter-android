package com.datarockets.mnchkn.activities.dashboard

import com.datarockets.mnchkn.models.Player

import java.util.ArrayList

class DashboardPresenterImpl(private var mDashboardView: DashboardView?,
                             private val mDashboardInteractor: DashboardInteractor) : DashboardPresenter, DashboardInteractor.OnLoadPlayerListener, DashboardInteractor.OnScreenStatusListener {

    override fun updatePlayerListItem(player: Player, position: Int) {
        if (mDashboardView != null) {
            mDashboardInteractor.updatePlayer(player, position, this)
        }
    }

    override fun onCreate() {
        if (mDashboardView != null) {
            mDashboardInteractor.isScreenShouldBeOn(this)
        }
    }

    override fun onResume() {
        if (mDashboardView != null) {
            mDashboardInteractor.loadPlayersList(this)
        }
    }

    override fun onFinished(players: ArrayList<Player>) {
        if (mDashboardView != null) {
            mDashboardView!!.setItems(players)
        }
    }

    override fun onPlayerUpdated(player: Player, position: Int) {
        if (mDashboardView != null) {
            mDashboardView!!.updatePlayerData(player, position)
        }
    }

    override fun onDestroy() {
        if (mDashboardView != null) {
            mDashboardView = null
        }
    }

    override fun setGameFinished() {
        if (mDashboardView != null) {
            mDashboardInteractor.setGameFinished()
        }
    }

    override fun insertStep(player: Player) {
        if (mDashboardView != null) {
            mDashboardInteractor.insertStep(player)
        }
    }


    override fun onKeepScreenOn() {
        if (mDashboardView != null) {
            mDashboardView!!.keepScreenOn(true)
        }
    }

    override fun onKeepScreenOff() {
        if (mDashboardView != null) {
            mDashboardView!!.keepScreenOn(false)
        }
    }

}
