package com.datarockets.mnchkn.activities.players;

public interface PlayersListPresenter {
    void checkIsEnoughPlayers();
    void addPlayer(String name);
    void deletePlayerListItem(int position, long id);
    void clearPlayersStats();
    void clearGameSteps();
    void setGameStarted();
    void setGameFinished();
    void onCreate();
    void onResume();
    void onDestroy();
}
