package com.datarockets.mnchkn.activities.result

class GameResultPresenterImpl(private var mGameResultView: GameResultView?,
                              private val mGameResultInteractor: GameResultInteractor) : GameResultPresenter, GameResultInteractor.OnResultsLoaded {


    override fun onCreate() {
        mGameResultInteractor.loadGameResults(this)
    }

    override fun notifyChartDataPrepared() {
        mGameResultView?.loadChartFragments()
    }

    override fun onBackPressed() {
        mGameResultInteractor.clearSteps()
        mGameResultInteractor.clearPlayerStats()
    }

    override fun onStop() {
        mGameResultInteractor.clearSteps()
        mGameResultInteractor.clearPlayerStats()
    }

    override fun onDestroy() {
        if (mGameResultView != null) {
            mGameResultInteractor.clearSteps()
            mGameResultInteractor.clearPlayerStats()
            mGameResultView = null
        }
    }

}
