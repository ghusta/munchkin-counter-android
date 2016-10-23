package com.datarockets.mnchkn.ui.players

import com.datarockets.mnchkn.data.DataManager
import javax.inject.Inject

class PlayerPresenterImpl
@Inject constructor(private val mDataManager: DataManager) {

    fun increaseLevelScore(score: Int) {
//        mPlayerinteractor.increaseLevelScore(score, this)
    }

    fun decreaseLevelScore(score: Int) {
//        mPlayerinteractor.decreaseLevelScore(score, this)
    }

    fun increaseStrengthScore(score: Int) {
//        mPlayerinteractor.increaseStrengthScore(score, this)
    }

    fun decreaseStrengthScore(score: Int) {
//        mPlayerinteractor.decreaseStrengthScore(score, this)
    }

    fun onUpdateLevel(score: Int) {
//        mPlayerView.setLevelScore(score.toString())
    }

    fun onUpdateStrength(score: Int) {
//        mPlayerView.setStrengthScore(score.toString())
    }

}
