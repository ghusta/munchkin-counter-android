package com.datarockets.mnchkn.ui.result

import com.datarockets.mnchkn.data.DataManager
import com.datarockets.mnchkn.ui.base.Presenter
import rx.Subscription
import javax.inject.Inject

class GameResultPresenterImpl
@Inject constructor(private val mDataManager: DataManager) : Presenter<GameResultView> {

    private var mGameResultView: GameResultView? = null
    private var mSubscription: Subscription? = null

    override fun attachView(mvpView: GameResultView) {
        mGameResultView = mvpView
    }

    override fun detachView() {
        mGameResultView = null
        mSubscription?.unsubscribe()
    }

    fun onCreate() {
//        mGameResultInteractor.loadGameResults(this)
    }

    fun notifyChartDataPrepared() {
        mGameResultView?.loadChartFragments()
    }

    fun onBackPressed() {
//        mGameResultInteractor.clearSteps()
//        mGameResultInteractor.clearPlayerStats()
    }

    fun onStop() {
//        mGameResultInteractor.clearSteps()
//        mGameResultInteractor.clearPlayerStats()
    }

}
