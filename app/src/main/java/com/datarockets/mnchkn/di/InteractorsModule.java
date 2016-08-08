package com.datarockets.mnchkn.di;

import android.content.Context;

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

import dagger.Module;
import dagger.Provides;

@Module
public class InteractorsModule {

    private Context mContext;

    public InteractorsModule(Context context) {
        this.mContext = context;
    }

    @Provides
    public PlayersListInteractor providesPlayersListInteractor() {
        return new PlayersListInteractorImpl(mContext);
    }

    @Provides
    public DashboardInteractor providesDashboardInteractor() {
        return new DashboardInteractorImpl(mContext);
    }

    @Provides
    public GameResultInteractor providesGameResultInteractor() {
        return new GameResultInteractorImpl(mContext);
    }

    @Provides
    public ChartsInteractor providesChartsInteractor() {
        return new ChartsInteractorImpl(mContext);
    }

    @Provides
    public PlayerInteractor providesPlayerInteractor() {
        return new PlayerInteractorImpl(mContext);
    }

}
