package com.datarockets.mnchkn;


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
