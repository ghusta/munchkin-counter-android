package com.datarockets.mnchkn.di

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.datarockets.mnchkn.store.*
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DomainModule {

    @Provides @Singleton
    fun providesSettingsService(context: Context): SettingsService {
        return SettingsServiceImpl(context)
    }

    @Provides @Singleton
    fun providesGameService(context: Context): GameService {
        return GameServiceImpl(context)
    }

    @Provides @Singleton
    fun providesScoreService(): ScoreService {
        return ScoreServiceImpl()
    }

    @Provides @Singleton
    fun providesPlayerService(context: Context): PlayerService {
        return PlayerServiceImpl(context)
    }

    @Provides @Singleton
    fun providesMunchkinDatabaseHelper(context: Context): MunchkinDatabaseHelper {
        return MunchkinDatabaseHelper(context)
    }

    @Provides @Singleton
    fun providesSharedPreferences(context: Context): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(context)
    }

    @Provides @Singleton
    fun providesSharedPreferencesEditor(context: Context): SharedPreferences.Editor {
        return PreferenceManager.getDefaultSharedPreferences(context).edit()
    }

}
