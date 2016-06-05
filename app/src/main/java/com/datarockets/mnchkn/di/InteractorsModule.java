package com.datarockets.mnchkn.di;

import com.datarockets.mnchkn.MunchkinApplication;
import com.datarockets.mnchkn.activities.chooser.ChooseGameInteractor;
import com.datarockets.mnchkn.activities.chooser.ChooseGameInteractorImpl;
import com.datarockets.mnchkn.activities.dashboard.DashboardInteractor;
import com.datarockets.mnchkn.activities.dashboard.DashboardInteractorImpl;
import com.datarockets.mnchkn.activities.onboard.OnboardInteractor;
import com.datarockets.mnchkn.activities.onboard.OnboardInteractorImpl;
import com.datarockets.mnchkn.activities.players.PlayersListInteractor;
import com.datarockets.mnchkn.activities.players.PlayersListInteractorImpl;
import com.datarockets.mnchkn.activities.result.GameResultInteractor;
import com.datarockets.mnchkn.activities.result.GameResultInteractorImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class InteractorsModule {

    @Provides
    public OnboardInteractor provideOnboardInteractor(MunchkinApplication application) {
        return new OnboardInteractorImpl(application);
    }

    @Provides
    public DashboardInteractor provideDashboardInteractor(MunchkinApplication application) {
        return new DashboardInteractorImpl(application);
    }

    @Provides
    public PlayersListInteractor providePlayersListInteractor(MunchkinApplication application) {
        return new PlayersListInteractorImpl(application);
    }

    @Provides
    public GameResultInteractor provideGameResultInteractor(MunchkinApplication application) {
        return new GameResultInteractorImpl(application);
    }

    @Provides
    public ChooseGameInteractor chooseGameInteractor() {
        return new ChooseGameInteractorImpl();
    }

}
