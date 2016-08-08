package com.datarockets.mnchkn.store;

public class ScoreServiceImpl implements ScoreService {

    @Override
    public int increaseScore(int score) {
        return score + 1;
    }

    @Override
    public int decreaseScore(int score) {
        return score - 1;
    }

}
