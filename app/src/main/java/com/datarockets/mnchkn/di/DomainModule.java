package com.datarockets.mnchkn.di;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.datarockets.mnchkn.store.GameService;
import com.datarockets.mnchkn.store.GameServiceImpl;
import com.datarockets.mnchkn.store.MunchkinDatabaseHelper;
import com.datarockets.mnchkn.store.PlayerService;
import com.datarockets.mnchkn.store.PlayerServiceImpl;
import com.datarockets.mnchkn.store.ScoreService;
import com.datarockets.mnchkn.store.ScoreServiceImpl;
import com.datarockets.mnchkn.store.SettingsService;
import com.datarockets.mnchkn.store.SettingsServiceImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DomainModule {

    @Provides
    @Singleton
    public SettingsService providesSettingsService(Context context) {
        return new SettingsServiceImpl(context);
    }

    @Provides
    @Singleton
    public GameService providesGameService(Context context) {
        return new GameServiceImpl(context);
    }

    @Provides
    @Singleton
    public ScoreService providesScoreService() {
        return new ScoreServiceImpl();
    }

    @Provides
    @Singleton
    public PlayerService providesPlayerService(Context context) {
        return new PlayerServiceImpl(context);
    }

    @Provides
    @Singleton
    public MunchkinDatabaseHelper providesMunchkinDatabaseHelper(Context context) {
        return new MunchkinDatabaseHelper(context);
    }

    @Provides
    @Singleton
    public SharedPreferences providesSharedPreferences(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    @Provides
    @Singleton
    public SharedPreferences.Editor providesSharedPreferencesEditor(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).edit();
    }

}
