package com.datarockets.mnchkn.di

import android.content.Context

import com.datarockets.mnchkn.activities.dashboard.DashboardInteractor
import com.datarockets.mnchkn.activities.dashboard.DashboardInteractorImpl
import com.datarockets.mnchkn.activities.onboard.OnboardInteractor
import com.datarockets.mnchkn.activities.onboard.OnboardInteractorImpl
import com.datarockets.mnchkn.activities.players.PlayersListInteractor
import com.datarockets.mnchkn.activities.players.PlayersListInteractorImpl
import com.datarockets.mnchkn.activities.result.GameResultInteractor
import com.datarockets.mnchkn.activities.result.GameResultInteractorImpl
import com.datarockets.mnchkn.fragments.charts.ChartsInteractor
import com.datarockets.mnchkn.fragments.charts.ChartsInteractorImpl
import com.datarockets.mnchkn.fragments.players.PlayerInteractor
import com.datarockets.mnchkn.fragments.players.PlayerInteractorImpl

import dagger.Module
import dagger.Provides

@Module
class InteractorsModule {

    @Provides
    fun providesPlayersListInteractor(context: Context): PlayersListInteractor {
        return PlayersListInteractorImpl(context)
    }

    @Provides
    fun providesDashboardInteractor(context: Context): DashboardInteractor {
        return DashboardInteractorImpl(context)
    }

    @Provides
    fun providesGameResultInteractor(context: Context): GameResultInteractor {
        return GameResultInteractorImpl(context)
    }

    @Provides
    fun providesChartsInteractor(context: Context): ChartsInteractor {
        return ChartsInteractorImpl(context)
    }

    @Provides
    fun providesPlayerInteractor(context: Context): PlayerInteractor {
        return PlayerInteractorImpl(context)
    }

    @Provides
    fun providesOnboardInteractor(context: Context): OnboardInteractor {
        return OnboardInteractorImpl(context)
    }

}
