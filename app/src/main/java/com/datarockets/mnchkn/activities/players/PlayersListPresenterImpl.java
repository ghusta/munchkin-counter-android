package com.datarockets.mnchkn.activities.players;

import android.content.Context;

import com.datarockets.mnchkn.models.Player;

import java.util.ArrayList;

public class PlayersListPresenterImpl implements PlayersListPresenter, PlayersListInteractor.OnFinishedListener {

    private PlayersListView playersListView;
    private PlayersListInteractorImpl interactor;
    private Context context;

    public PlayersListPresenterImpl(PlayersListView playersListView, Context context) {
        this.context = context;
        this.playersListView = playersListView;
        this.interactor = new PlayersListInteractorImpl(context);
    }

    @Override
    public void checkIsEnoughPlayers() {
        if (playersListView != null) {
            interactor.checkIsEnoughPlayer(this);
        }
    }

    @Override
    public void addPlayer(String name) {
        if (playersListView != null) {
            interactor.addPlayer(name, this);
        }
    }

    @Override
    public void deletePlayerListItem(int position, long id) {
        if (playersListView != null) {
            interactor.deletePlayer(position, id, this);
        }
    }

    @Override
    public void clearPlayersStats() {
        if (playersListView != null) {
            interactor.clearPlayersStats(this);
        }
    }

    @Override
    public void setGameStarted() {
        if (playersListView != null) {
            interactor.setGameStatus(true);
        }
    }

    @Override
    public void setGameFinished() {
        if (playersListView != null) {
            interactor.setGameStatus(false);
        }
    }

    @Override
    public void onCreate() {
        if (playersListView != null) {
            interactor.isGameStarted(context, this);
        }
    }

    @Override
    public void onResume() {
        if (playersListView != null) {
            interactor.getPlayers(this);
        }
    }

    @Override
    public void onDestroy() {
        if (playersListView != null) {
            playersListView = null;
        }
    }

    @Override
    public void onPlayersLoaded(ArrayList<Player> players) {
        if (playersListView != null) {
            playersListView.setPlayersList(players);
        }
    }

    @Override
    public void onPlayerAdded(Player player) {
        if (playersListView != null) {
            playersListView.addPlayerToList(player);
        }
    }

    @Override
    public void onPlayerDeleted(int position) {
        if (playersListView != null) {
            playersListView.deletePlayerFromList(position);
        }
    }

    @Override
    public void onPlayersCountChecked(boolean enough) {
        if (playersListView != null) {
            if (enough) {
                playersListView.launchDashboard();
            } else {
                playersListView.showWarning();
            }
        }
    }

    @Override
    public void onGameStarted(boolean started) {
        if (playersListView != null) {
            if (started) {
                playersListView.showStartContinueDialog();
            }
        }
    }

}