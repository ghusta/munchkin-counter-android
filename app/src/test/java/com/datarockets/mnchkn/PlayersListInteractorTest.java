package com.datarockets.mnchkn;

import android.content.Context;
import android.os.Build;

import com.datarockets.mnchkn.activities.players.PlayersListInteractor;
import com.datarockets.mnchkn.activities.players.PlayersListInteractorImpl;
import com.datarockets.mnchkn.models.Player;
import com.datarockets.mnchkn.store.GameService;
import com.datarockets.mnchkn.store.GameServiceImpl;
import com.datarockets.mnchkn.store.MunchkinDatabaseHelper;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.Shadows;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowApplication;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(RobolectricGradleTestRunner.class)
@Config(sdk = Build.VERSION_CODES.LOLLIPOP, constants = BuildConfig.class, application = MunchkinApplication.class)
public class PlayersListInteractorTest {

    @Mock
    PlayersListInteractor.OnFinishedListener listener;
    @Mock
    GameService gameService;

    GameServiceImpl gameServiceImpl;

    @Captor
    ArgumentCaptor<Player> captorPlayer;
    @Captor
    ArgumentCaptor<Integer> captorPlayerPosition;
    @Captor
    ArgumentCaptor<ArrayList<Player>> captorPlayersList;
    @Captor
    ArgumentCaptor<Boolean> captorBooleanValue;

    ShadowApplication application;
    Context context;
    PlayersListInteractorImpl interactor;
    MunchkinDatabaseHelper munchkinDatabaseHelper;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        application = Shadows.shadowOf(RuntimeEnvironment.application);
        context = application.getApplicationContext();
        munchkinDatabaseHelper = MunchkinDatabaseHelper.getInstance(context);
        interactor = new PlayersListInteractorImpl(context);
        gameServiceImpl = spy(GameServiceImpl.getInstance(context));
    }

    @Test
    public void shoudlClearPlayersStats() {
        interactor.addPlayer("Dzmitry", listener);
        interactor.addPlayer("Sergey", listener);
        interactor.clearPlayersStats(listener);
        verify(listener).onPlayersLoaded(captorPlayersList.capture());
        ArrayList<Player> playersList = captorPlayersList.getValue();
        assertEquals(2, playersList.size());
    }

    @Test
    public void shouldCheckIsGameNotStarted() {
        interactor.isGameStarted(context, listener);
        verify(listener).onGameStarted(captorBooleanValue.capture());
        boolean isGameStarted = captorBooleanValue.getValue();
        assertEquals(false, isGameStarted);
    }

    @Test
    public void shouldCheckIsGameStarted() {
        interactor.setGameStatus(true);
        interactor.isGameStarted(context, listener);
        verify(listener).onGameStarted(captorBooleanValue.capture());
        boolean isGameStarted = captorBooleanValue.getValue();
        assertEquals(true, isGameStarted);
    }

    @Test
    public void shouldCheckIsNotEnoughPlayers() {
        interactor.checkIsEnoughPlayer(listener);
        verify(listener).onPlayersCountChecked(captorBooleanValue.capture());
        boolean isNotEnoughPlayers = captorBooleanValue.getValue();
        assertEquals(false, isNotEnoughPlayers);
    }

    @Test
    public void shouldCheckIsEnoughPlayers() {
        interactor.addPlayer("Dzmitry", listener);
        interactor.addPlayer("Sergey", listener);
        interactor.checkIsEnoughPlayer(listener);
        verify(listener).onPlayersCountChecked(captorBooleanValue.capture());
        boolean isEnoughPlayers = captorBooleanValue.getValue();
        assertEquals(true, isEnoughPlayers);
    }

    @Test
    public void shouldGetPlayers() {
        interactor.addPlayer("Dzmitry", listener);
        interactor.addPlayer("Sergey", listener);
        interactor.getPlayers(listener);
        verify(listener).onPlayersLoaded(captorPlayersList.capture());
        ArrayList<Player> playersList = captorPlayersList.getValue();
        assertEquals(2, playersList.size());
    }

    @Test
    public void shouldAddPlayer() {
        interactor.addPlayer("Dzmitry", listener);
        verify(listener).onPlayerAdded(captorPlayer.capture());
        Player player = captorPlayer.getValue();
        assertEquals("Dzmitry", player.getName());
        assertEquals(1, player.getLevelScore());
        assertEquals(1, player.getStrengthScore());
    }

    @Test
    public void shouldDeletePlayer() {
        interactor.addPlayer("Dzmitry", listener);
        interactor.deletePlayer(0, 0, listener);
        verify(listener).onPlayerDeleted(captorPlayerPosition.capture());
        int position = captorPlayerPosition.getValue();
        assertEquals(0, position);
    }

    @After
    public void tearDown() throws Exception {
        munchkinDatabaseHelper.close();
    }

}
