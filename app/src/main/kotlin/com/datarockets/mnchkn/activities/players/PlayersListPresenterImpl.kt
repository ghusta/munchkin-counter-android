package com.datarockets.mnchkn.activities.players

import com.datarockets.mnchkn.models.Player

class PlayersListPresenterImpl(private var mPlayersListView: PlayersListView?,
                               private val mInteractor: PlayersListInteractor) : PlayersListPresenter, PlayersListInteractor.OnFinishedListener {

    override fun checkIsEnoughPlayers() {
        if (mPlayersListView != null) {
            mInteractor.checkIsEnoughPlayer(this)
        }
    }

    override fun addPlayer(name: String) {
        if (mPlayersListView != null) {
            mInteractor.addPlayer(name, this)
        }
    }

    override fun deletePlayerListItem(position: Int, id: Long) {
        if (mPlayersListView != null) {
            mInteractor.deletePlayer(position, id, this)
        }
    }

    override fun clearPlayersStats() {
        if (mPlayersListView != null) {
            mInteractor.clearPlayersStats(this)
        }
    }

    override fun clearGameSteps() {
        if (mPlayersListView != null) {
            mInteractor.clearGameSteps()
        }
    }

    override fun setGameStarted() {
        if (mPlayersListView != null) {
            mInteractor.setGameStatus(true)
        }
    }

    override fun setGameFinished() {
        if (mPlayersListView != null) {
            mInteractor.setGameStatus(false)
        }
    }

    override fun onCreate() {
        if (mPlayersListView != null) {
            mInteractor.isGameStarted(this)
        }
    }

    override fun onResume() {
        if (mPlayersListView != null) {
            mInteractor.getPlayers(this)
        }
    }

    override fun onDestroy() {
        if (mPlayersListView != null) {
            mPlayersListView = null
        }
    }

    override fun onPlayersLoaded(players: List<Player>) {
        if (mPlayersListView != null) {
            mPlayersListView!!.setPlayersList(players)
        }
    }

    override fun onPlayerAdded(player: Player) {
        if (mPlayersListView != null) {
            mPlayersListView!!.addPlayerToList(player)
        }
    }

    override fun onPlayerDeleted(position: Int) {
        if (mPlayersListView != null) {
            mPlayersListView!!.deletePlayerFromList(position)
        }
    }

    override fun onPlayersCountChecked(enough: Boolean) {
        if (mPlayersListView != null) {
            if (enough) {
                mPlayersListView!!.launchDashboard()
            } else {
                mPlayersListView!!.showWarning()
            }
        }
    }

    override fun onGameStarted(started: Boolean) {
        if (mPlayersListView != null && started) {
            mPlayersListView!!.showStartContinueDialog()
        }
    }

}