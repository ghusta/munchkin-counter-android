package com.datarockets.mnchkn.models;

public class Player {
    private long id;
    private String name;
    private int levelScore;
    private int strengthScore;
    private int totalScore;
    private String color;

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

    public String getColor() {
        return color;
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

    public void setColor(String color) {
        this.color = color;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

}
