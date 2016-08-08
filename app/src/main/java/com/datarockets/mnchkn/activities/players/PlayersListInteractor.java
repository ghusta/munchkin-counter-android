package com.datarockets.mnchkn.activities.players;

import com.datarockets.mnchkn.models.Player;

import java.util.List;

public interface PlayersListInteractor {

    interface OnFinishedListener {
        void onPlayersLoaded(List<Player> players);
        void onPlayerAdded(Player player);
        void onPlayerDeleted(int position);
        void onPlayersCountChecked(boolean enough);
        void onGameStarted(boolean started);
    }

    void clearPlayersStats(OnFinishedListener listener);
    void isGameStarted(OnFinishedListener listener);
    void checkIsEnoughPlayer(OnFinishedListener listener);
    void getPlayers(OnFinishedListener listener);
    void addPlayer(String name, OnFinishedListener listener);
    void deletePlayer(int position, long id, OnFinishedListener listener);
    void setGameStatus(boolean started);
    void clearGameSteps();

}
