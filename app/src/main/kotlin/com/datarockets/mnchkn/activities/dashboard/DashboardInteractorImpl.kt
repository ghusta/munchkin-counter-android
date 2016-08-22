package com.datarockets.mnchkn.activities.dashboard

import android.content.Context

import com.datarockets.mnchkn.MunchkinApplication
import com.datarockets.mnchkn.activities.BaseInteractor
import com.datarockets.mnchkn.models.Player
import com.datarockets.mnchkn.store.GameService
import com.datarockets.mnchkn.store.PlayerService
import com.datarockets.mnchkn.store.SettingsService

import javax.inject.Inject

class DashboardInteractorImpl(context: Context) : BaseInteractor(context), DashboardInteractor {

    @Inject
    lateinit var mPlayerService: PlayerService
    @Inject
    lateinit var mGameService: GameService
    @Inject
    lateinit var mSettingsService: SettingsService

    override fun setUpComponent(context: Context) {
        MunchkinApplication.get(context).appComponent.inject(this)
    }

    override fun isScreenShouldBeOn(listener: DashboardInteractor.OnScreenStatusListener) {
        if (mSettingsService.isWakeLockActive) {
            listener.onKeepScreenOn()
        } else {
            listener.onKeepScreenOff()
        }
    }

    override fun loadPlayersList(listener: DashboardInteractor.OnLoadPlayerListener) {
        listener.onFinished(mPlayerService.playersList)
    }

    override fun updatePlayer(player: Player, position: Int, listener: DashboardInteractor.OnLoadPlayerListener) {
        listener.onPlayerUpdated(mPlayerService.updatePlayer(player), position)
    }

    override fun insertStep(player: Player) {
        mGameService.insertStep(player)
    }

    override fun clearPlayersStats() {
        mPlayerService.clearPlayersStats()
    }


    override fun setGameFinished() {
        mGameService.setGameStatus(false)
    }


}
