package com.datarockets.mnchkn.store;

public class ScoreServiceImpl implements ScoreService{
    private static ScoreServiceImpl instance;

    private ScoreServiceImpl() {}

    public static ScoreServiceImpl getInstance() {
        if (instance == null) {
            instance = new ScoreServiceImpl();
        }
        return instance;
    }

    @Override
    public int increaseScore(int score) {
        return score + 1;
    }

    @Override
    public int decreaseScore(int score) {
        return score - 1;
    }

}
