package com.datarockets.mnchkn.store;

public interface ScoreService {
    /**
     *
     * @param score - a player's score
     * @return updated increased score
     */
    int increaseScore(int score);
    /**
     *
     * @param score - a player's score
     * @return updated decreased score
     */
    int decreaseScore(int score);
}
