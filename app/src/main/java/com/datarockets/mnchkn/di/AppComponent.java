package com.datarockets.mnchkn.di;

import com.datarockets.mnchkn.MunchkinApplication;
import com.datarockets.mnchkn.activities.dashboard.DashboardInteractor;
import com.datarockets.mnchkn.activities.dashboard.DashboardInteractorImpl;
import com.datarockets.mnchkn.activities.players.PlayersListInteractor;
import com.datarockets.mnchkn.activities.players.PlayersListInteractorImpl;
import com.datarockets.mnchkn.activities.result.GameResultInteractor;
import com.datarockets.mnchkn.activities.result.GameResultInteractorImpl;
import com.datarockets.mnchkn.fragments.charts.ChartsInteractor;
import com.datarockets.mnchkn.fragments.charts.ChartsInteractorImpl;
import com.datarockets.mnchkn.fragments.players.PlayerInteractor;
import com.datarockets.mnchkn.fragments.players.PlayerInteractorImpl;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        AppModule.class,
        InteractorsModule.class,
        DomainModule.class})
public interface AppComponent {
    void inject(MunchkinApplication munchkinApplication);
    void inject(PlayersListInteractorImpl playersListInteractor);
    void inject(DashboardInteractorImpl dashboardInteractor);
    void inject(GameResultInteractorImpl gameResultInteractor);
    void inject(ChartsInteractorImpl chartsInteractor);
    void inject(PlayerInteractorImpl playerInteractor);

    PlayersListInteractor getPlayersListInteractor();
    DashboardInteractor getDashboardInteractor();
    GameResultInteractor getGameResultInteractor();
    ChartsInteractor getChartsInteractor();
    PlayerInteractor getPlayerInteractor();
}