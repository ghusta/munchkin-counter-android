package com.datarockets.mnchkn.fragments.players

interface PlayerInteractor {
    interface OnUpdatedListener {
        fun onUpdateLevel(score: Int)
        fun onUpdateStrength(score: Int)
    }

    fun increaseLevelScore(score: Int, listener: OnUpdatedListener)
    fun decreaseLevelScore(score: Int, listener: OnUpdatedListener)
    fun increaseStrengthScore(score: Int, listener: OnUpdatedListener)
    fun decreaseStrengthScore(score: Int, listener: OnUpdatedListener)
}
