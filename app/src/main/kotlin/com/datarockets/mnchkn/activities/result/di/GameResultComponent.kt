package com.datarockets.mnchkn.activities.result.di

import com.datarockets.mnchkn.activities.result.GameResultActivity
import com.datarockets.mnchkn.di.ActivityScope
import com.datarockets.mnchkn.di.AppComponent

import dagger.Component

@ActivityScope
@Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(GameResultModule::class))
interface GameResultComponent {
    fun inject(activity: GameResultActivity)
}
