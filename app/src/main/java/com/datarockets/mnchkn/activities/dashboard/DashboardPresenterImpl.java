package com.datarockets.mnchkn.activities.dashboard;

import android.content.Context;

import com.datarockets.mnchkn.models.Player;

import java.util.ArrayList;
import java.util.List;

public class DashboardPresenterImpl implements DashboardPresenter, DashboardInteractor.OnLoadPlayerListener {

    DashboardView dashboardView;
    DashboardInteractor interactor;
    Context context;

    public DashboardPresenterImpl(DashboardView dashboardView, Context context) {
        this.dashboardView = dashboardView;
        this.context = context;
        this.interactor = new DashboardInteractorImpl(context);
    }

    @Override
    public void updatePlayerListItem(Player player, int position) {
        if (dashboardView != null) {
            interactor.updatePlayer(player, position, this);
        }
    }

    @Override
    public void onResume() {
        if (dashboardView != null) {
            interactor.loadPlayersList(this);
        }
    }

    @Override
    public void onFinished(ArrayList<Player> players) {
        if (dashboardView != null) {
            dashboardView.setItems(players);
        }
    }

    @Override
    public void onPlayerUpdated(Player player, int position) {
        if (dashboardView != null) {
            dashboardView.updatePlayerData(player, position);
        }
    }

    @Override
    public void onDestroy() {
        if (dashboardView != null) {
            dashboardView = null;
        }
    }

    @Override
    public void setGameFinished() {
        if (dashboardView != null) {
            interactor.setGameFinished();
        }
    }


}
