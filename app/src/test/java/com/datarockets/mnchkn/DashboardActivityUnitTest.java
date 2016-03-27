package com.datarockets.mnchkn;

import android.app.Instrumentation;
import android.test.ViewAsserts;
import android.widget.Button;
import android.widget.EditText;

import com.datarockets.mnchkn.activities.dashboard.DashboardActivity;
import com.datarockets.mnchkn.fragments.dialogs.AddNewPlayerFragment;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertNotNull;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class DashboardActivityUnitTest {

    @Test
    public void checkAddNewPlayer() {
        DashboardActivity activity = Robolectric.setupActivity(DashboardActivity.class);
    }

}
