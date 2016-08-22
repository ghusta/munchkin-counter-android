package com.datarockets.mnchkn.fragments.players

import android.content.Context

import com.datarockets.mnchkn.MunchkinApplication
import com.datarockets.mnchkn.activities.BaseInteractor
import com.datarockets.mnchkn.store.ScoreService

import javax.inject.Inject

class PlayerInteractorImpl(context: Context) : BaseInteractor(context), PlayerInteractor {

    @Inject
    lateinit var mScoreService: ScoreService

    override fun increaseLevelScore(score: Int, listener: PlayerInteractor.OnUpdatedListener) {
        listener.onUpdateLevel(mScoreService.increaseScore(score))
    }

    override fun decreaseLevelScore(score: Int, listener: PlayerInteractor.OnUpdatedListener) {
        listener.onUpdateLevel(mScoreService.decreaseScore(score))
    }

    override fun increaseStrengthScore(score: Int, listener: PlayerInteractor.OnUpdatedListener) {
        listener.onUpdateStrength(mScoreService.increaseScore(score))
    }

    override fun decreaseStrengthScore(score: Int, listener: PlayerInteractor.OnUpdatedListener) {
        listener.onUpdateStrength(mScoreService.decreaseScore(score))
    }

    override fun setUpComponent(context: Context) {
        MunchkinApplication.get(context).appComponent.inject(this)
    }
}
