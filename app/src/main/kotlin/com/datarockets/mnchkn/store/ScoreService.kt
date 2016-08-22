package com.datarockets.mnchkn.store

interface ScoreService {
    /**

     * @param score - a player's score
     * *
     * @return updated increased score
     */
    fun increaseScore(score: Int): Int

    /**

     * @param score - a player's score
     * *
     * @return updated decreased score
     */
    fun decreaseScore(score: Int): Int
}
