package com.datarockets.mnchkn.activities.players;

import android.content.Context;

import com.datarockets.mnchkn.models.Player;

import java.util.ArrayList;

public interface PlayersListInteractor {

    interface OnFinishedListener {
        void onPlayersLoaded(ArrayList<Player> players);
        void onPlayerAdded(Player player);
        void onPlayerDeleted(int position);
        void onPlayersCountChecked(boolean enough);
        void onGameStarted(boolean started);
    }

    void clearPlayersStats(OnFinishedListener listener);
    void isGameStarted(Context context, OnFinishedListener listener);
    void checkIsEnoughPlayer(OnFinishedListener listener);
    void getPlayers(OnFinishedListener listener);
    void addPlayer(String name, OnFinishedListener listener);
    void deletePlayer(int position, long id, OnFinishedListener listener);
    void setGameStatus(boolean started);

}
