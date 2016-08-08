package com.datarockets.mnchkn.activities.dashboard;

import com.datarockets.mnchkn.activities.BasePresenter;
import com.datarockets.mnchkn.models.Player;

import java.util.ArrayList;

public class DashboardPresenterImpl extends BasePresenter implements DashboardPresenter,
        DashboardInteractor.OnLoadPlayerListener,
        DashboardInteractor.OnScreenStatusListener {

    private DashboardView mDashboardView;
    private DashboardInteractor mDashboardInteractor;

    public DashboardPresenterImpl(DashboardView dashboardView,
                                  DashboardInteractor dashboardInteractor) {
        this.mDashboardView = dashboardView;
        this.mDashboardInteractor = dashboardInteractor;
    }

    @Override
    public void updatePlayerListItem(Player player, int position) {
        if (mDashboardView != null) {
            mDashboardInteractor.updatePlayer(player, position, this);
        }
    }

    @Override
    public void onCreate() {
        if (mDashboardView != null) {
            mDashboardInteractor.isScreenShouldBeOn(this);
        }
    }

    @Override
    public void onResume() {
        if (mDashboardView != null) {
            mDashboardInteractor.loadPlayersList(this);
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
            mDashboardInteractor.setGameFinished();
        }
    }

    @Override
    public void insertStep(Player player) {
        if (mDashboardView != null) {
            mDashboardInteractor.insertStep(player);
        }
    }


    @Override
    public void onKeepScreenOn() {
        if (mDashboardView != null) {
            mDashboardView.keepScreenOn(true);
        }
    }

    @Override
    public void onKeepScreenOff() {
        if (mDashboardView != null) {
            mDashboardView.keepScreenOn(false);
        }
    }

}
