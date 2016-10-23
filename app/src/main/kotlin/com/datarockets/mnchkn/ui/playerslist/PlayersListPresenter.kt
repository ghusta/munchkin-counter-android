package com.datarockets.mnchkn.ui.playerslist

import com.datarockets.mnchkn.data.DataManager
import com.datarockets.mnchkn.ui.base.Presenter
import rx.Subscription
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import javax.inject.Inject

class PlayersListPresenter
@Inject constructor(private val mDataManager: DataManager) : Presenter<PlayersListView> {

    private var mPlayersListView: PlayersListView? = null
    private var mSubscription: Subscription? = null

    override fun attachView(mvpView: PlayersListView) {
        mPlayersListView = mvpView
    }

    fun loadPlayers() {
        mSubscription = mDataManager.getPlayers()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({
                    retrievedPlayers ->
                    mPlayersListView?.setPlayersList(retrievedPlayers)
                })
    }

    fun addPlayer(name: String) {
        mSubscription = mDataManager.addPlayer(name)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({
                    retrievedPlayer ->
                    mPlayersListView?.addPlayerToList(retrievedPlayer)
                })
    }

    fun deletePlayerListItem(position: Int, id: Long) {
        mSubscription = mDataManager.deletePlayer(id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({}, {}, {
                    mPlayersListView?.deletePlayerFromList(position)
                })

    }

    fun checkIsGameStarted() {
        if (mDataManager.getPreferenceHelper().isGameStarted()) {
            mPlayersListView?.showStartContinueDialog()
        }
    }

    fun clearPlayersStats() {
        mSubscription = mDataManager.clearPlayersStats()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({

                })
    }

    fun checkIsEnoughPlayers() {
        mSubscription = mDataManager.getPlayers()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ retrievedPlayers ->
                    if (retrievedPlayers.size >= 2) {
                        mPlayersListView?.launchDashboard()
                    } else {
                        mPlayersListView?.showWarning()
                    }
                })
    }

    fun clearGameSteps() {
        mSubscription = mDataManager.clearSteps()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({

                })
    }

    fun setGameStarted() {
        mDataManager.getPreferenceHelper().setGameStatus(true)
    }

    fun setGameFinished() {
        mDataManager.getPreferenceHelper().setGameStatus(false)
    }

    override fun detachView() {
        mPlayersListView = null
        mSubscription?.unsubscribe()
    }

//    override fun checkIsEnoughPlayers() {
//        if (mPlayersListView != null) {
//            mInteractor.checkIsEnoughPlayer(this)
//        }
//    }
//
//    override fun addPlayer(name: String) {
//        if (mPlayersListView != null) {
//            mInteractor.addPlayer(name, this)
//        }
//    }
//
//    override fun deletePlayerListItem(position: Int, id: Long) {
//        if (mPlayersListView != null) {
//            mInteractor.deletePlayer(position, id, this)
//        }
//    }
//
//    override fun clearPlayersStats() {
//        if (mPlayersListView != null) {
//            mInteractor.clearPlayersStats(this)
//        }
//    }
//
//    override fun clearGameSteps() {
//        if (mPlayersListView != null) {
//            mInteractor.clearGameSteps()
//        }
//    }
//
//    override fun setGameStarted() {
//        if (mPlayersListView != null) {
//            mInteractor.setGameStatus(true)
//        }
//    }
//
//    override fun setGameFinished() {
//        if (mPlayersListView != null) {
//            mInteractor.setGameStatus(false)
//        }
//    }
//
//    override fun onCreate() {
//        if (mPlayersListView != null) {
//            mInteractor.isGameStarted(this)
//        }
//    }
//
//    override fun onResume() {
//        if (mPlayersListView != null) {
//            mInteractor.getPlayers(this)
//        }
//    }
//
//    override fun onDestroy() {
//        if (mPlayersListView != null) {
//            mPlayersListView = null
//        }
//    }
//
//    override fun onPlayersLoaded(players: List<Player>) {
//        if (mPlayersListView != null) {
//            mPlayersListView!!.setPlayersList(players)
//        }
//    }
//
//    override fun onPlayerAdded(player: Player) {
//        if (mPlayersListView != null) {
//            mPlayersListView!!.addPlayerToList(player)
//        }
//    }
//
//    override fun onPlayerDeleted(position: Int) {
//        if (mPlayersListView != null) {
//            mPlayersListView!!.deletePlayerFromList(position)
//        }
//    }
//
//    override fun onPlayersCountChecked(enough: Boolean) {
//        if (mPlayersListView != null) {
//            if (enough) {
//                mPlayersListView!!.launchDashboard()
//            } else {
//                mPlayersListView!!.showWarning()
//            }
//        }
//    }
//
//    override fun onGameStarted(started: Boolean) {
//        if (mPlayersListView != null && started) {
//            mPlayersListView!!.showStartContinueDialog()
//        }
//    }

}