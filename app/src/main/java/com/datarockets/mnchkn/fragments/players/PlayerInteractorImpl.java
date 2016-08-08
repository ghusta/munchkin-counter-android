package com.datarockets.mnchkn.fragments.players;

import android.content.Context;

import com.datarockets.mnchkn.MunchkinApplication;
import com.datarockets.mnchkn.activities.BaseInteractor;
import com.datarockets.mnchkn.store.ScoreService;

import javax.inject.Inject;

public class PlayerInteractorImpl extends BaseInteractor implements PlayerInteractor {

    @Inject
    ScoreService mScoreService;

    public PlayerInteractorImpl(Context context) {
        super(context);
    }

    @Override
    public void increaseLevelScore(int score, OnUpdatedListener listener) {
        listener.onUpdateLevel(mScoreService.increaseScore(score));
    }

    @Override
    public void decreaseLevelScore(int score, OnUpdatedListener listener) {
        listener.onUpdateLevel(mScoreService.decreaseScore(score));
    }

    @Override
    public void increaseStrengthScore(int score, OnUpdatedListener listener) {
        listener.onUpdateStrength(mScoreService.increaseScore(score));
    }

    @Override
    public void decreaseStrengthScore(int score, OnUpdatedListener listener) {
        listener.onUpdateStrength(mScoreService.decreaseScore(score));
    }

    @Override
    protected void setUpComponent(Context context) {
        MunchkinApplication.get(context).getAppComponent().inject(this);
    }
}
