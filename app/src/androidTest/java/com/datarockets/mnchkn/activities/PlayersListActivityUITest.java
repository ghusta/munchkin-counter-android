package com.datarockets.mnchkn.activities;

import android.test.ActivityInstrumentationTestCase2;
import android.view.View;

import com.datarockets.mnchkn.R;
import com.datarockets.mnchkn.activities.players.PlayersListActivity;
import com.robotium.solo.Solo;

public class PlayersListActivityUITest extends ActivityInstrumentationTestCase2<PlayersListActivity> {

    private Solo solo;

    public PlayersListActivityUITest() {
        super(PlayersListActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        solo = new Solo(getInstrumentation(), getActivity());
    }

    public void testCreatingNewGame() {
        View fabAddPlayer = getActivity().findViewById(R.id.fab_add_player);
        solo.clickOnView(fabAddPlayer);
        solo.waitForDialogToOpen();
        solo.enterText(0, "Alex");
        solo.pressSoftKeyboardDoneButton();
        solo.waitForDialogToClose();
        solo.clickOnView(solo.getView(R.id.item_start_game));
        solo.assertCurrentActivity("Wrong activity", PlayersListActivity.class);
        solo.clickOnView(fabAddPlayer);
        solo.enterText(0, "John");
        solo.pressSoftKeyboardDoneButton();
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
