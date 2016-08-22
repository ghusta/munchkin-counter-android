package com.datarockets.mnchkn.fragments.players


class PlayerPresenterImpl(private val mPlayerView: PlayerView, private val mPlayerinteractor: PlayerInteractor) : PlayerPresenter, PlayerInteractor.OnUpdatedListener {

    override fun increaseLevelScore(score: Int) {
        mPlayerinteractor.increaseLevelScore(score, this)
    }

    override fun decreaseLevelScore(score: Int) {
        mPlayerinteractor.decreaseLevelScore(score, this)
    }

    override fun increaseStrengthScore(score: Int) {
        mPlayerinteractor.increaseStrengthScore(score, this)
    }

    override fun decreaseStrengthScore(score: Int) {
        mPlayerinteractor.decreaseStrengthScore(score, this)
    }

    override fun onUpdateLevel(score: Int) {
        mPlayerView.setLevelScore(score.toString())
    }

    override fun onUpdateStrength(score: Int) {
        mPlayerView.setStrengthScore(score.toString())
    }

}
