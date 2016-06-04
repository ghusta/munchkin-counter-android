package com.datarockets.mnchkn.models;

public class GameStep  {
    private long mPlayerId;
    private int mPlayerLevel;
    private int mPlayerStrength;


    public long getPlayerId() {
        return mPlayerId;
    }

    public void setPlayerId(long playerId) {
        this.mPlayerId = playerId;
    }

    public int getPlayerLevel() {
        return mPlayerLevel;
    }

    public void setPlayerLevel(int playerLevel) {
        this.mPlayerLevel = playerLevel;
    }

    public int getPlayerStrength() {
        return mPlayerStrength;
    }

    public void setPlayerStrength(int playerStrength) {
        this.mPlayerStrength = playerStrength;
    }

}
