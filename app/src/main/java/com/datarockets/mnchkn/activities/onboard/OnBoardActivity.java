package com.datarockets.mnchkn.activities.onboard;

import android.content.Intent;
import android.os.Bundle;

import com.chyrta.onboarder.OnboarderActivity;
import com.chyrta.onboarder.OnboarderPage;
import com.datarockets.mnchkn.MunchkinApplication;
import com.datarockets.mnchkn.R;
import com.datarockets.mnchkn.activities.onboard.di.DaggerOnboardComponent;
import com.datarockets.mnchkn.activities.onboard.di.OnboardModule;
import com.datarockets.mnchkn.activities.players.PlayersListActivity;
import com.datarockets.mnchkn.di.AppComponent;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class OnboardActivity extends OnboarderActivity implements OnboardView {

    @Inject
    OnboardPresenter presenter;
    List<OnboarderPage> onboarderPages;
    OnboarderPage onboarderPageOne, onboarderPageTwo, onboarderPageThree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppComponent appComponent = MunchkinApplication.get(this).getAppComponent();

        DaggerOnboardComponent.builder()
                .appComponent(appComponent)
                .onboardModule(new OnboardModule(this))
                .build()
                .inject(this);

        presenter.checkIsUserSeenOnboarding();
        onboarderPages = new ArrayList<>();
        onboarderPageOne = new OnboarderPage(
                R.string.onboarder_page1_title,
                R.string.onboarder_page1_description,
                R.drawable.ic_munchkin);
        onboarderPageOne.setBackgroundColor(R.color.card_general);
        onboarderPageTwo = new OnboarderPage(
                R.string.onboarder_page2_title,
                R.string.onboarder_page2_description,
                R.drawable.ic_infinite);
        onboarderPageTwo.setBackgroundColor(R.color.card_light);
        onboarderPageThree = new OnboarderPage(
                R.string.onboarder_page3_title,
                R.string.onboarder_page3_description,
                R.drawable.ic_dice);
        onboarderPageThree.setBackgroundColor(R.color.card_corner);
        onboarderPages.add(onboarderPageOne);
        onboarderPages.add(onboarderPageTwo);
        onboarderPages.add(onboarderPageThree);
        setOnboardPagesReady(onboarderPages);
    }

    @Override
    public void onSkipButtonPressed() {
        super.onSkipButtonPressed();
    }

    @Override
    public void onFinishButtonPressed() {
        openPlayersActivity();
    }

    @Override
    public void openPlayersActivity() {
        presenter.setOnboardingSeen();
        Intent intent = new Intent(this, PlayersListActivity.class);
        startActivity(intent);
        finish();
    }

}
