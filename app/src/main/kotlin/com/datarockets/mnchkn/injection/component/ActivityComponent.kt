package com.datarockets.mnchkn.injection.component

import com.datarockets.mnchkn.ui.dashboard.DashboardActivity
import com.datarockets.mnchkn.ui.onboard.OnboardActivity
import com.datarockets.mnchkn.ui.playerslist.PlayersListActivity
import com.datarockets.mnchkn.ui.result.GameResultActivity
import com.datarockets.mnchkn.injection.PerActivity
import com.datarockets.mnchkn.injection.module.ActivityModule
import com.datarockets.mnchkn.ui.players.PlayerFragment
import dagger.Component

@PerActivity
@Component(dependencies = arrayOf(ApplicationComponent::class), modules = arrayOf(ActivityModule::class))
interface ActivityComponent {
    fun inject(gameResultAtivity: GameResultActivity)
    fun inject(playerListActivity: PlayersListActivity)
    fun inject(onboardActivity: OnboardActivity)
    fun inject(dashboardActivity: DashboardActivity)
    fun inject(playerFragment: PlayerFragment)
}