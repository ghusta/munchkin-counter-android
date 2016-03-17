package com.datarockets.mnchkn.activities.dashboard;

public class DashboardPresenterImpl implements DashboardPresenter {

    DashboardView view;
    DashboardInteractor interactor;

    public DashboardPresenterImpl(DashboardView dashboardView) {
        this.view = dashboardView;
        this.interactor = new DashboardInteractorImpl();
    }

}
