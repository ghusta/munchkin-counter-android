package com.datarockets.mnchkn.di

import com.datarockets.mnchkn.MunchkinApplication
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
import com.datarockets.mnchkn.store.GameServiceImpl
import com.datarockets.mnchkn.store.PlayerServiceImpl
import com.datarockets.mnchkn.store.ScoreServiceImpl
import com.datarockets.mnchkn.store.SettingsServiceImpl
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class, InteractorsModule::class, DomainModule::class))
interface AppComponent {
    fun inject(munchkinApplication: MunchkinApplication)
    fun inject(playersListInteractor: PlayersListInteractorImpl)
    fun inject(dashboardInteractor: DashboardInteractorImpl)
    fun inject(gameResultInteractor: GameResultInteractorImpl)
    fun inject(chartsInteractor: ChartsInteractorImpl)
    fun inject(playerInteractor: PlayerInteractorImpl)
    fun inject(onboardInteractor: OnboardInteractorImpl)
    fun inject(playerService: PlayerServiceImpl)
    fun inject(gameService: GameServiceImpl)
    fun inject(scoreService: ScoreServiceImpl)
    fun inject(settingsService: SettingsServiceImpl)
    val playersListInteractor: PlayersListInteractor
    val dashboardInteractor: DashboardInteractor
    val gameResultInteractor: GameResultInteractor
    val chartsInteractor: ChartsInteractor
    val playerInteractor: PlayerInteractor
    val onboardInteractor: OnboardInteractor
}