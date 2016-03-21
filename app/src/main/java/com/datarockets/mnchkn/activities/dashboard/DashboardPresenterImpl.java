package com.datarockets.mnchkn.activities.dashboard;

import com.datarockets.mnchkn.models.Player;

import java.util.List;

public class DashboardPresenterImpl implements DashboardPresenter, DashboardInteractor.OnLoadPlayerListener {

    DashboardView dashboardView;
    DashboardInteractor interactor;

    public DashboardPresenterImpl(DashboardView dashboardView) {
        this.dashboardView = dashboardView;
        this.interactor = new DashboardInteractorImpl();
    }

    @Override
    public void onResume() {
        if (dashboardView != null) {
            // TODO
        }
        interactor.loadPlayersList(this);
    }

    @Override
    public void onDestroy() {
        dashboardView = null;
    }

    @Override
    public void onFinished(List<Player> players) {
        if (dashboardView != null) {
            dashboardView.setItems(players);
        }
    }


}
