package com.datarockets.mnchkn.di;

import com.datarockets.mnchkn.MunchkinApplication;
import com.datarockets.mnchkn.activities.dashboard.DashboardInteractor;
import com.datarockets.mnchkn.activities.onboard.OnboardInteractor;
import com.datarockets.mnchkn.activities.players.PlayersListInteractor;
import com.datarockets.mnchkn.activities.result.GameResultInteractor;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, InteractorsModule.class})
public interface AppComponent {
    void inject(MunchkinApplication application);

    OnboardInteractor getOnboardInteractor();
    PlayersListInteractor getPlayersListInteractor();
    GameResultInteractor getGameResultInteractor();
    DashboardInteractor getDashboardInteractor();
}
