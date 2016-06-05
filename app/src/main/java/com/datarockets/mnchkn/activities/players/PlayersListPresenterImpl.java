package com.datarockets.mnchkn.activities.players;

import android.content.Context;

import com.datarockets.mnchkn.models.Player;

import java.util.List;

public class PlayersListPresenterImpl implements PlayersListPresenter,
        PlayersListInteractor.OnFinishedListener {

    private PlayersListView mPlayersListView;
    private PlayersListInteractor mInteractor;
    private Context mContext;

    public PlayersListPresenterImpl(PlayersListView playersListView, Context context) {
        this.mContext = context;
        this.mPlayersListView = playersListView;
        this.mInteractor = new PlayersListInteractorImpl(context);
    }

    @Override
    public void checkIsEnoughPlayers() {
        if (mPlayersListView != null) {
            mInteractor.checkIsEnoughPlayer(this);
        }
    }

    @Override
    public void addPlayer(String name) {
        if (mPlayersListView != null) {
            mInteractor.addPlayer(name, this);
        }
    }

    @Override
    public void deletePlayerListItem(int position, long id) {
        if (mPlayersListView != null) {
            mInteractor.deletePlayer(position, id, this);
        }
    }

    @Override
    public void clearPlayersStats() {
        if (mPlayersListView != null) {
            mInteractor.clearPlayersStats(this);
        }
    }

    @Override
    public void clearGameSteps() {
        if (mPlayersListView != null) {
            mInteractor.clearGameSteps();
        }
    }

    @Override
    public void setGameStarted() {
        if (mPlayersListView != null) {
            mInteractor.setGameStatus(true);
        }
    }

    @Override
    public void setGameFinished() {
        if (mPlayersListView != null) {
            mInteractor.setGameStatus(false);
        }
    }

    @Override
    public void onCreate() {
        if (mPlayersListView != null) {
            mInteractor.isGameStarted(mContext, this);
        }
    }

    @Override
    public void onResume() {
        if (mPlayersListView != null) {
            mInteractor.getPlayers(this);
        }
    }

    @Override
    public void onDestroy() {
        if (mPlayersListView != null) {
            mPlayersListView = null;
        }
    }

    @Override
    public void onPlayersLoaded(List<Player> players) {
        if (mPlayersListView != null) {
            mPlayersListView.setPlayersList(players);
        }
    }

    @Override
    public void onPlayerAdded(Player player) {
        if (mPlayersListView != null) {
            mPlayersListView.addPlayerToList(player);
        }
    }

    @Override
    public void onPlayerDeleted(int position) {
        if (mPlayersListView != null) {
            mPlayersListView.deletePlayerFromList(position);
        }
    }

    @Override
    public void onPlayersCountChecked(boolean enough) {
        if (mPlayersListView != null) {
            if (enough) {
                mPlayersListView.launchDashboard();
            } else {
                mPlayersListView.showWarning();
            }
        }
    }

    @Override
    public void onGameStarted(boolean started) {
        if (mPlayersListView != null && started) {
            mPlayersListView.showStartContinueDialog();
        }
    }

}