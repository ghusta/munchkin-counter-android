package com.datarockets.mnchkn.fragments.players

interface PlayerPresenter {
    fun increaseLevelScore(score: Int)
    fun decreaseLevelScore(score: Int)
    fun increaseStrengthScore(score: Int)
    fun decreaseStrengthScore(score: Int)
}
