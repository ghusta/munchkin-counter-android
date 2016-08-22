package com.datarockets.mnchkn.activities.onboard.di

import com.datarockets.mnchkn.activities.onboard.OnboardActivity
import com.datarockets.mnchkn.activities.onboard.OnboardPresenter
import com.datarockets.mnchkn.di.ActivityScope
import com.datarockets.mnchkn.di.AppComponent

import dagger.Component

@ActivityScope
@Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(OnboardModule::class))
interface OnboardComponent {
    fun inject(onboardActivity: OnboardActivity)
    val onboardPresenter: OnboardPresenter
}
