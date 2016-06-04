package com.datarockets.mnchkn;

import android.os.Build;

import com.datarockets.mnchkn.activities.dashboard.DashboardPresenter;
import com.datarockets.mnchkn.activities.dashboard.DashboardPresenterImpl;
import com.datarockets.mnchkn.activities.dashboard.DashboardView;
import com.datarockets.mnchkn.models.Player;
import com.datarockets.mnchkn.store.MunchkinDatabaseHelper;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.Shadows;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowApplication;

import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(RobolectricGradleTestRunner.class)
@Config(sdk = Build.VERSION_CODES.LOLLIPOP, constants = BuildConfig.class)
public class DashboardPresenterTest {

    @Mock
    DashboardView dashboardView;

    DashboardPresenter dashboardPresenter;

    MunchkinDatabaseHelper munchkinDatabaseHelper;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        ShadowApplication context = Shadows.shadowOf(RuntimeEnvironment.application);
        munchkinDatabaseHelper = MunchkinDatabaseHelper.getInstance(context.getApplicationContext());
        dashboardPresenter = new DashboardPresenterImpl(dashboardView, context.getApplicationContext());
    }

    @Test
    public void shouldOnResume() {
        dashboardPresenter.onResume();
        verify(dashboardView).setItems(Matchers.anyListOf(Player.class));
    }

    @Test
    public void shouldFinishGame() {
        dashboardPresenter.setGameFinished();
    }

    @Test
    public void shouldOnDestroy() {
        dashboardPresenter.onDestroy();
    }

    @After
    public void tearDown() throws Exception {
        munchkinDatabaseHelper.close();
    }

    @After
    public void detach() {
        dashboardView = null;
    }



}
