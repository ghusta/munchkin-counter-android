package com.datarockets.mnchkn.activities.dashboard;

import android.content.Context;

import com.datarockets.mnchkn.models.Player;

import java.util.ArrayList;

public class DashboardPresenterImpl implements DashboardPresenter,
        DashboardInteractor.OnLoadPlayerListener {

    private DashboardView mDashboardView;
    private DashboardInteractor mInteractor;

    public DashboardPresenterImpl(DashboardView dashboardView, Context context) {
        this.mDashboardView = dashboardView;
        this.mInteractor = new DashboardInteractorImpl(context);
    }

    @Override
    public void updatePlayerListItem(Player player, int position) {
        if (mDashboardView != null) {
            mInteractor.updatePlayer(player, position, this);
        }
    }

    @Override
    public void onResume() {
        if (mDashboardView != null) {
            mInteractor.loadPlayersList(this);
        }
    }

    @Override
    public void onFinished(ArrayList<Player> players) {
        if (mDashboardView != null) {
            mDashboardView.setItems(players);
        }
    }

    @Override
    public void onPlayerUpdated(Player player, int position) {
        if (mDashboardView != null) {
            mDashboardView.updatePlayerData(player, position);
        }
    }

    @Override
    public void onDestroy() {
        if (mDashboardView != null) {
            mDashboardView = null;
        }
    }

    @Override
    public void setGameFinished() {
        if (mDashboardView != null) {
            mInteractor.setGameFinished();
        }
    }

    @Override
    public void insertStep(Player player) {
        if (mDashboardView != null) {
            mInteractor.insertStep(player);
        }
    }

}
