package com.datarockets.mnchkn;

import android.widget.TextView;

import com.datarockets.mnchkn.activities.dashboard.DashboardActivity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertTrue;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class DashboardActivityUnitTest {

    @Test
    public void firstCount() {
        DashboardActivity activity = Robolectric.setupActivity(DashboardActivity.class);
        TextView tvLevelScore = (TextView) activity.findViewById(R.id.tv_level_score);
        TextView tvStrengthScore = (TextView) activity.findViewById(R.id.tv_strength_score);
        assertTrue("0".equals(tvLevelScore.getText().toString()));
        assertTrue("0".equals(tvStrengthScore.getText().toString()));
    }

}
