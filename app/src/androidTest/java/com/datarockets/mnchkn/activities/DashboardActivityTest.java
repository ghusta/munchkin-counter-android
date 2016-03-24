package com.datarockets.mnchkn.activities;

import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.MediumTest;

import com.datarockets.mnchkn.R;
import com.datarockets.mnchkn.activities.dashboard.DashboardActivity;
import com.datarockets.mnchkn.activities.result.GameResultActivity;
import com.datarockets.mnchkn.activities.welcome.WelcomeActivity;
import com.robotium.solo.Solo;

public class DashboardActivityTest extends ActivityInstrumentationTestCase2<DashboardActivity>{

    private Solo solo;

    public DashboardActivityTest() {
        super(DashboardActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        solo = new Solo(getInstrumentation(), getActivity());
    }

    @MediumTest
    public void testAddingPlayers() {
        solo.assertCurrentActivity("wrong activity", DashboardActivity.class);
        solo.clickOnButton(solo.getString(R.string.button_add_new_player));
        solo.waitForDialogToOpen();
        solo.enterText(0, "Alex");
        solo.pressSoftKeyboardDoneButton();
        solo.waitForDialogToClose();
        solo.clickInList(0);
        solo.clickOnView(solo.getView(R.id.btn_level_score_up));
        solo.clickOnView(solo.getView(R.id.btn_level_score_up));
        solo.clickOnView(solo.getView(R.id.item_finish_game));
        solo.waitForDialogToOpen();
        solo.clickOnButton(solo.getString(R.string.button_yes));
        solo.waitForDialogToClose();
        solo.assertCurrentActivity("wrong activity", GameResultActivity.class);
    }

    @Override
    protected void tearDown() throws Exception {
        try {
            solo.finalize();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        getActivity().finish();
        super.tearDown();
    }
}
