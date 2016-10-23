package com.datarockets.mnchkn.data.local

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.datarockets.mnchkn.injection.ApplicationContext
import javax.inject.Inject

class DbOpenHelper
@Inject
constructor(@ApplicationContext context: Context) :
        SQLiteOpenHelper(context, DbOpenHelper.DATABASE_NAME, null, DbOpenHelper.DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
        db.beginTransaction()
        try {
            db.execSQL(Db.PlayersTable.CREATE)
            db.execSQL(Db.GameTable.CREATE)
            db.setTransactionSuccessful()
        } finally {
            db.endTransaction()
        }
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
//        when (oldVersion) {
//            1 -> {
//                db.execSQL("ALTER TABLE "
//                        + TABLE_PLAYERS + " ADD COLUMN "
//                        + KEY_PLAYER_COLOR + " TEXT")
//                if (!isTableEmpty(db, TABLE_PLAYERS)) {
//                    addColorsToUpdatedPlayers(db)
//                }
//            }
//            else -> {
//            }
//        }
    }

    companion object {
        val DATABASE_NAME = "players_db"
        val DATABASE_VERSION = 6
    }

}