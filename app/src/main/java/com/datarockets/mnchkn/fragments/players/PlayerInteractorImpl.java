package com.datarockets.mnchkn.fragments.players;

import com.datarockets.mnchkn.store.ScoreServiceImpl;

public class PlayerInteractorImpl implements PlayerInteractor {

    private ScoreServiceImpl scoreService;

    public PlayerInteractorImpl() {
        this.scoreService = ScoreServiceImpl.getInstance();
    }

    @Override
    public void increaseLevelScore(int score, OnUpdatedListener listener) {
        listener.onUpdateLevel(scoreService.increaseScore(score));
    }

    @Override
    public void decreaseLevelScore(int score, OnUpdatedListener listener) {
        listener.onUpdateLevel(scoreService.decreaseScore(score));
    }

    @Override
    public void increaseStrengthScore(int score, OnUpdatedListener listener) {
        listener.onUpdateStrength(scoreService.increaseScore(score));
    }

    @Override
    public void decreaseStrengthScore(int score, OnUpdatedListener listener) {
        listener.onUpdateStrength(scoreService.decreaseScore(score));
    }

}
