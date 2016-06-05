package com.datarockets.mnchkn.models;

public class Player {
    private long mId;
    private String mName;
    private int mLevelScore;
    private int mStrengthScore;
    private int mTotalScore;
    private String mColor;

    public long getId() {
        return mId;
    }

    public void setId(long id) {
        this.mId = id;
    }

    public String getName() {
        return mName;
    }

    public int getLevelScore() {
        return mLevelScore;
    }

    public int getStrengthScore() {
        return mStrengthScore;
    }

    public String getColor() {
        return mColor;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public void setLevelScore(int levelScore) {
        this.mLevelScore = levelScore;
    }

    public void setStrengthScore(int strengthScore) {
        this.mStrengthScore = strengthScore;
    }

    public void setColor(String color) {
        this.mColor = color;
    }

    public int getTotalScore() {
        return mTotalScore;
    }

    public void setTotalScore(int totalScore) {
        this.mTotalScore = totalScore;
    }

}
