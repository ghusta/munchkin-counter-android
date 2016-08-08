package com.datarockets.mnchkn.di;

import android.content.Context;

import com.datarockets.mnchkn.store.GameService;
import com.datarockets.mnchkn.store.GameServiceImpl;
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

    private Context mContext;

    public DomainModule(Context context) {
        this.mContext = context;
    }

    @Provides
    @Singleton
    public SettingsService providesSettingsService() {
        return new SettingsServiceImpl(mContext);
    }

    @Provides
    @Singleton
    public GameService providesGameService() {
        return new GameServiceImpl(mContext);
    }

    @Provides
    @Singleton
    public ScoreService providesScoreService() {
        return new ScoreServiceImpl();
    }

    @Provides
    @Singleton
    public PlayerService providesPlayerService() {
        return new PlayerServiceImpl(mContext);
    }

}
