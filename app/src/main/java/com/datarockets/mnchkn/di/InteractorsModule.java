package com.datarockets.mnchkn.di;

import android.content.Context;

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

import dagger.Module;
import dagger.Provides;

@Module
public class InteractorsModule {

    @Provides
    public PlayersListInteractor providesPlayersListInteractor(Context context) {
        return new PlayersListInteractorImpl(context);
    }

    @Provides
    public DashboardInteractor providesDashboardInteractor(Context context) {
        return new DashboardInteractorImpl(context);
    }

    @Provides
    public GameResultInteractor providesGameResultInteractor(Context context) {
        return new GameResultInteractorImpl(context);
    }

    @Provides
    public ChartsInteractor providesChartsInteractor(Context context) {
        return new ChartsInteractorImpl(context);
    }

    @Provides
    public PlayerInteractor providesPlayerInteractor(Context context) {
        return new PlayerInteractorImpl(context);
    }

    @Provides
    public OnboardInteractor providesOnboardInteractor(Context context) {
        return new OnboardInteractorImpl(context);
    }

}
