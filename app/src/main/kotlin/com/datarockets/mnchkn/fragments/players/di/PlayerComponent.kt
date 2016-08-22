package com.datarockets.mnchkn.fragments.players.di

import com.datarockets.mnchkn.di.ActivityScope
import com.datarockets.mnchkn.di.AppComponent
import com.datarockets.mnchkn.fragments.players.PlayerFragment

import dagger.Component

@ActivityScope
@Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(PlayerModule::class))
interface PlayerComponent {
    fun inject(playerFragment: PlayerFragment)
}
