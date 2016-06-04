package com.datarockets.mnchkn.fragments.players;

import com.datarockets.mnchkn.store.ScoreServiceImpl;

public class PlayerInteractorImpl implements PlayerInteractor {

    private ScoreServiceImpl mScoreService;

    public PlayerInteractorImpl() {
        this.mScoreService = ScoreServiceImpl.getInstance();
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

}
