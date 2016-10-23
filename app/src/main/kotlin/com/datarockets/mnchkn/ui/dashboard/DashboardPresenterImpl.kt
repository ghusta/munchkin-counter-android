package com.datarockets.mnchkn.ui.dashboard

import com.datarockets.mnchkn.data.DataManager
import com.datarockets.mnchkn.data.model.Player
import com.datarockets.mnchkn.ui.base.Presenter
import rx.Subscription
import java.util.*
import javax.inject.Inject

class DashboardPresenterImpl
@Inject constructor(private val mDataManager: DataManager) : Presenter<DashboardView> {

    private var mDashboardView: DashboardView? = null
    private var mSubscription: Subscription? = null

    override fun attachView(mvpView: DashboardView) {
        mDashboardView = mvpView
    }

    fun updatePlayerListItem(player: Player, position: Int) {
        if (mDashboardView != null) {
//            mDashboardInteractor.updatePlayer(player, position, this)
        }
    }

    fun onCreate() {
        if (mDashboardView != null) {
//            mDashboardInteractor.isScreenShouldBeOn(this)
        }
    }

    fun onResume() {
        if (mDashboardView != null) {
//            mDashboardInteractor.loadPlayersList(this)
        }
    }

    fun onFinished(players: ArrayList<Player>) {
        if (mDashboardView != null) {
            mDashboardView!!.setItems(players)
        }
    }

    fun onPlayerUpdated(player: Player, position: Int) {
        if (mDashboardView != null) {
            mDashboardView!!.updatePlayerData(player, position)
        }
    }

    fun setGameFinished() {
        if (mDashboardView != null) {
//            mDashboardInteractor.setGameFinished()
        }
    }

    fun insertStep(player: Player) {
        if (mDashboardView != null) {
//            mDashboardInteractor.insertStep(player)
        }
    }


    fun onKeepScreenOn() {
        if (mDashboardView != null) {
            mDashboardView!!.keepScreenOn(true)
        }
    }

    fun onKeepScreenOff() {
        if (mDashboardView != null) {
            mDashboardView!!.keepScreenOn(false)
        }
    }

    override fun detachView() {
        mDashboardView = null
        mSubscription?.unsubscribe()
    }

}
