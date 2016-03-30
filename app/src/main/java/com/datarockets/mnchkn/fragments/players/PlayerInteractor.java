package com.datarockets.mnchkn.fragments.players;

public interface PlayerInteractor {
    interface OnUpdatedListener {
        void onUpdateLevel(int score);
        void onUpdateStrength(int score);
    }
    void increaseLevelScore(int score, OnUpdatedListener listener);
    void decreaseLevelScore(int score, OnUpdatedListener listener);
    void increaseStrengthScore(int score, OnUpdatedListener listener);
    void decreaseStrengthScore(int score, OnUpdatedListener listener);
}
