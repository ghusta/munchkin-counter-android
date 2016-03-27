package com.datarockets.mnchkn.models;

public class Player {
    public long id;
    public String name;
    public int levelScore;
    public int strengthScore;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getLevelScore() {
        return levelScore;
    }

    public int getStrengthScore() {
        return strengthScore;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLevelScore(int levelScore) {
        this.levelScore = levelScore;
    }

    public void setStrengthScore(int strengthScore) {
        this.strengthScore = strengthScore;
    }

}
