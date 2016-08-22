package com.datarockets.mnchkn.store

class ScoreServiceImpl : ScoreService {

    override fun increaseScore(score: Int): Int {
        return score + 1
    }

    override fun decreaseScore(score: Int): Int {
        return score - 1
    }

}
