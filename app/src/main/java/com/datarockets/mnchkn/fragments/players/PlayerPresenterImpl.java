package com.datarockets.mnchkn.fragments.players;


public class PlayerPresenterImpl implements PlayerPresenter, PlayerInteractor.OnUpdatedListener {

    private PlayerView mPlayerView;
    private PlayerInteractor mPlayerinteractor;

    public PlayerPresenterImpl(PlayerView playerView, PlayerInteractor playerInteractor) {
        this.mPlayerView = playerView;
        this.mPlayerinteractor = playerInteractor;
    }

    @Override
    public void increaseLevelScore(int score) {
        mPlayerinteractor.increaseLevelScore(score, this);
    }

    @Override
    public void decreaseLevelScore(int score) {
        mPlayerinteractor.decreaseLevelScore(score, this);
    }

    @Override
    public void increaseStrengthScore(int score) {
        mPlayerinteractor.increaseStrengthScore(score, this);
    }

    @Override
    public void decreaseStrengthScore(int score) {
        mPlayerinteractor.decreaseStrengthScore(score, this);
    }

    @Override
    public void onUpdateLevel(int score) {
        mPlayerView.setLevelScore(String.valueOf(score));
    }

    @Override
    public void onUpdateStrength(int score) {
        mPlayerView.setStrengthScore(String.valueOf(score));
    }

}
