package com.datarockets.mnchkn;

import android.os.Build;

import com.datarockets.mnchkn.activities.players.PlayersListInteractorImpl;
import com.datarockets.mnchkn.activities.players.PlayersListPresenterImpl;
import com.datarockets.mnchkn.activities.players.PlayersListView;
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

import java.util.ArrayList;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;


@RunWith(RobolectricGradleTestRunner.class)
@Config(sdk = Build.VERSION_CODES.LOLLIPOP, constants = BuildConfig.class)
public class PlayersListPresenterTest {

    @Mock
    PlayersListView playersListView;
    @Mock
    Player player;
    @Mock
    PlayersListInteractorImpl interactor;
    @Mock
    ArrayList<Player> players;

    private PlayersListPresenterImpl playersListPresenter;
    private MunchkinDatabaseHelper munchkinDatabaseHelper;

    @Before
    public void setUp() {
        initMocks(this);
        ShadowApplication context = Shadows.shadowOf(RuntimeEnvironment.application);
        munchkinDatabaseHelper = MunchkinDatabaseHelper.getInstance(context.getApplicationContext());
        playersListPresenter = new PlayersListPresenterImpl(playersListView, context.getApplicationContext());
    }

    @Test
    public void shouldLoadPlayersList() throws Exception {
        playersListPresenter.addPlayer("Dzmitry");
        verify(playersListView).addPlayerToList(any(Player.class));
    }

    @Test
    public void shouldDeletePlayerListItem() throws Exception {
        playersListPresenter.addPlayer("Dzmitry");
        playersListPresenter.deletePlayerListItem(0, 0);
        verify(playersListView).deletePlayerFromList(0);
    }

    @Test
    public void shouldNotStartDashboard() {
        playersListPresenter.addPlayer("Dzmitry");
        playersListPresenter.checkIsEnoughPlayers();
        verify(playersListView).showWarning();
    }

    @Test
    public void shouldStartDashboard() {
        playersListPresenter.addPlayer("Dzmitry");
        playersListPresenter.addPlayer("Nick");
        playersListPresenter.checkIsEnoughPlayers();
        verify(playersListView).launchDashboard();
    }

    @Test
    public void shouldShowContinueDialog() {
        playersListPresenter.addPlayer("Dzmitry");
        playersListPresenter.addPlayer("Nick");
        playersListPresenter.setGameStarted();
        playersListPresenter.onCreate();
        verify(playersListView).showStartContinueDialog();
    }

    @Test
    public void shouldClearPlayerStats() {
        playersListPresenter.addPlayer("Dzmitry");
        playersListPresenter.addPlayer("Nick");
        playersListPresenter.addPlayer("Sergey");
        playersListPresenter.clearPlayersStats();
        verify(playersListView).setPlayersList(Matchers.anyListOf(Player.class));
    }

    @Test
    public void shouldFinishGame() {
        playersListPresenter.addPlayer("Dzmitry");
        playersListPresenter.addPlayer("Sergey");
        playersListPresenter.checkIsEnoughPlayers();
        verify(playersListView).launchDashboard();
        playersListPresenter.setGameFinished();
        playersListPresenter.onCreate();
        verify(playersListView, never()).showStartContinueDialog();
    }

    @Test
    public void shouldClearGameSteps() {
        playersListPresenter.clearGameSteps();
    }

    @Test
    public void shouldOnResume() {
        playersListPresenter.onResume();
        verify(playersListView).setPlayersList(Matchers.anyListOf(Player.class));
    }

    @Test
    public void shouldDestroy() {
        playersListPresenter.onDestroy();
        verify(playersListView).equals(Matchers.isNull());
    }

    @After
    public void tearDown() throws Exception {
        munchkinDatabaseHelper.close();
    }


    @After
    public void detach() {
        playersListView = null;
    }

}
