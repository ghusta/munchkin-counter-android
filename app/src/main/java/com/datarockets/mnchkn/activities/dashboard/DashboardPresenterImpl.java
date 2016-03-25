package com.datarockets.mnchkn.activities.dashboard;

import android.content.Context;

import com.datarockets.mnchkn.models.Player;

import java.util.ArrayList;
import java.util.List;

public class DashboardPresenterImpl implements DashboardPresenter, DashboardInteractor.OnLoadPlayerListener {

    DashboardView dashboardView;
    DashboardInteractor interactor;

    public DashboardPresenterImpl(DashboardView dashboardView, Context context) {
        this.dashboardView = dashboardView;
        this.interactor = new DashboardInteractorImpl(context);
    }

    @Override
    public void addNewPlayer(String name) {
        if (dashboardView != null) {
            interactor.addPlayer(name, this);
        }
    }

    @Override
    public void deletePlayerListItem(int index) {
        if (dashboardView != null) {
            interactor.deletePlayer(index, this);
        }
    }

    @Override
    public void updatePlayerListItem(int index, int currentLevel, int currentStrength) {
        if (dashboardView != null) {
            interactor.updatePlayer(index, currentLevel, currentStrength, this);
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
    public void onDestroy() {
        dashboardView = null;
    }


}
