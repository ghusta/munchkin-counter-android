package com.datarockets.mnchkn.fragments.players;


public class PlayerPresenterImpl implements PlayerPresenter, PlayerInteractor.OnUpdatedListener {

    private PlayerView playerView;
    private PlayerInteractor interactor;

    public PlayerPresenterImpl(PlayerView playerView) {
        this.playerView = playerView;
        this.interactor = new PlayerInteractorImpl();
    }

    @Override
    public void increaseLevelScore(int score) {
        interactor.increaseLevelScore(score, this);
    }

    @Override
    public void decreaseLevelScore(int score) {
        interactor.decreaseLevelScore(score, this);
    }

    @Override
    public void increaseStrengthScore(int score) {
        interactor.increaseStrengthScore(score, this);
    }

    @Override
    public void decreaseStrengthScore(int score) {
        interactor.decreaseStrengthScore(score, this);
    }

    @Override
    public void onUpdateLevel(int score) {
        playerView.setLevelScore(String.valueOf(score));
    }

    @Override
    public void onUpdateStrength(int score) {
        playerView.setStrengthScore(String.valueOf(score));
    }

}
