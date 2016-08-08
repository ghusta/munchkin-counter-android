package com.datarockets.mnchkn.activities.onboard.di;

import com.datarockets.mnchkn.activities.onboard.OnboardActivity;
import com.datarockets.mnchkn.activities.onboard.OnboardPresenter;
import com.datarockets.mnchkn.di.ActivityScope;
import com.datarockets.mnchkn.di.AppComponent;

import dagger.Component;

@ActivityScope
@Component(dependencies = AppComponent.class, modules = OnboardModule.class)
public interface OnboardComponent {
    void inject(OnboardActivity onboardActivity);
    OnboardPresenter getOnboardPresenter();
}
