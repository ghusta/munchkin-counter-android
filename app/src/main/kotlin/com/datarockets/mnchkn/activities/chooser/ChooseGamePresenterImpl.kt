package com.datarockets.mnchkn.activities.chooser

class ChooseGamePresenterImpl(private var mChooseGameView: ChooseGameView?) : ChooseGamePresenter {
    private val mInteractor: ChooseGameInteractorImpl

    init {
        this.mInteractor = ChooseGameInteractorImpl()
    }

    override fun onResume() {
    }

    override fun onDestroy() {
        if (mChooseGameView != null) {
            mChooseGameView = null
        }
    }

}
