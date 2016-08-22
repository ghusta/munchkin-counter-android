package com.datarockets.mnchkn.activities.players

import android.content.Context

import com.datarockets.mnchkn.MunchkinApplication
import com.datarockets.mnchkn.activities.BaseInteractor
import com.datarockets.mnchkn.store.GameService
import com.datarockets.mnchkn.store.PlayerService
import com.datarockets.mnchkn.utils.LogUtil

import javax.inject.Inject

class PlayersListInteractorImpl(context: Context) : BaseInteractor(context), PlayersListInteractor {

    @Inject
    lateinit var mPlayerService: PlayerService
    @Inject
    lateinit var mGameService: GameService

    override fun setUpComponent(context: Context) {
        MunchkinApplication.get(context).appComponent.inject(this)
    }

    override fun clearPlayersStats(listener: PlayersListInteractor.OnFinishedListener) {
        mPlayerService.clearPlayersStats()
        listener.onPlayersLoaded(mPlayerService.playersList)
    }

    override fun isGameStarted(listener: PlayersListInteractor.OnFinishedListener) {
        listener.onGameStarted(mGameService.isGameStarted)
    }

    override fun checkIsEnoughPlayer(listener: PlayersListInteractor.OnFinishedListener) {
        listener.onPlayersCountChecked(mPlayerService.playersList.size >= 2)
    }

    override fun getPlayers(listener: PlayersListInteractor.OnFinishedListener) {
        listener.onPlayersLoaded(mPlayerService.playersList)
    }

    override fun addPlayer(name: String, listener: PlayersListInteractor.OnFinishedListener) {
        listener.onPlayerAdded(mPlayerService.addPlayer(name))
    }

    override fun deletePlayer(position: Int, id: Long, listener: PlayersListInteractor.OnFinishedListener) {
        listener.onPlayerDeleted(mPlayerService.deletePlayer(position, id))
    }

    override fun setGameStatus(started: Boolean) {
        mGameService.setGameStatus(started)
    }

    override fun clearGameSteps() {
        mGameService.clearSteps()
    }

    companion object {

        private val TAG = LogUtil.makeLogTag(PlayersListInteractorImpl::class)
    }


}