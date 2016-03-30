package com.datarockets.mnchkn.fragments.players;

public interface PlayerPresenter {
    void increaseLevelScore(int score);
    void decreaseLevelScore(int score);
    void increaseStrengthScore(int score);
    void decreaseStrengthScore(int score);
}
