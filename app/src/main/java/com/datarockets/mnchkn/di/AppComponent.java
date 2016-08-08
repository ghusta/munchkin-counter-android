package com.datarockets.mnchkn.di;

import com.datarockets.mnchkn.MunchkinApplication;
import com.datarockets.mnchkn.activities.dashboard.DashboardInteractor;
import com.datarockets.mnchkn.activities.dashboard.DashboardInteractorImpl;
import com.datarockets.mnchkn.activities.onboard.OnboardInteractor;
import com.datarockets.mnchkn.activities.onboard.OnboardInteractorImpl;
import com.datarockets.mnchkn.activities.players.PlayersListInteractor;
import com.datarockets.mnchkn.activities.players.PlayersListInteractorImpl;
import com.datarockets.mnchkn.activities.result.GameResultInteractor;
import com.datarockets.mnchkn.activities.result.GameResultInteractorImpl;
import com.datarockets.mnchkn.fragments.charts.ChartsInteractor;
import com.datarockets.mnchkn.fragments.charts.ChartsInteractorImpl;
import com.datarockets.mnchkn.fragments.players.PlayerInteractor;
import com.datarockets.mnchkn.fragments.players.PlayerInteractorImpl;
import com.datarockets.mnchkn.store.GameServiceImpl;
import com.datarockets.mnchkn.store.PlayerServiceImpl;
import com.datarockets.mnchkn.store.ScoreServiceImpl;
import com.datarockets.mnchkn.store.SettingsServiceImpl;

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
    void inject(OnboardInteractorImpl onboardInteractor);
    void inject(PlayerServiceImpl playerService);
    void inject(GameServiceImpl gameService);
    void inject(ScoreServiceImpl scoreService);
    void inject(SettingsServiceImpl settingsService);
    PlayersListInteractor getPlayersListInteractor();
    DashboardInteractor getDashboardInteractor();
    GameResultInteractor getGameResultInteractor();
    ChartsInteractor getChartsInteractor();
    PlayerInteractor getPlayerInteractor();
    OnboardInteractor getOnboardInteractor();
}