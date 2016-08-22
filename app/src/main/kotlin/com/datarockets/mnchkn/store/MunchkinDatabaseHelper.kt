package com.datarockets.mnchkn.store

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.datarockets.mnchkn.models.GameStep
import com.datarockets.mnchkn.models.Player
import com.datarockets.mnchkn.utils.LogUtil
import java.util.*
import javax.inject.Singleton

@Singleton
class MunchkinDatabaseHelper(context: Context) : SQLiteOpenHelper(context, MunchkinDatabaseHelper.DATABASE_NAME, null, MunchkinDatabaseHelper.DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
        val createPlayersTableQuery = "CREATE TABLE " + TABLE_PLAYERS +
                "(" +
                KEY_PLAYER_ID + " INTEGER PRIMARY KEY," +
                KEY_PLAYER_NAME + " TEXT," +
                KEY_PLAYER_LEVEL + " INTEGER," +
                KEY_PLAYER_STRENGTH + " INTEGER," +
                KEY_PLAYER_COLOR + " TEXT" +
                ")"
        val createGameTableQuery = "CREATE TABLE " + TABLE_GAME +
                "(" +
                KEY_GAME_PLAYER_ID + " INTEGER REFERENCES " + TABLE_PLAYERS + "," +
                KEY_GAME_PLAYER_LEVEL + " INTEGER," +
                KEY_GAME_PLAYER_STRENGTH + " INTEGER" +
                ")"
        db.execSQL(createPlayersTableQuery)
        db.execSQL(createGameTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        when (oldVersion) {
            1 -> {
                db.execSQL("ALTER TABLE "
                        + TABLE_PLAYERS + " ADD COLUMN "
                        + KEY_PLAYER_COLOR + " TEXT")
                if (!isTableEmpty(db, TABLE_PLAYERS)) {
                    addColorsToUpdatedPlayers(db)
                }
            }
            else -> {
            }
        }
    }

    fun addPlayer(player: Player): Long {
        var playerId: Long = -1
        val db = writableDatabase
        db.beginTransaction()
        try {
            val values = ContentValues()
            values.put(KEY_PLAYER_NAME, player.name)
            values.put(KEY_PLAYER_LEVEL, player.levelScore)
            values.put(KEY_PLAYER_STRENGTH, player.strengthScore)
            values.put(KEY_PLAYER_COLOR, player.color)
            playerId = db.insertOrThrow(TABLE_PLAYERS, null, values)
            db.setTransactionSuccessful()
            Log.i(TAG, "Player id is " + playerId)
        } catch (e: Exception) {
            Log.e(TAG, "Error while trying to add new player")
        } finally {
            db.endTransaction()
        }
        return playerId
    }

    val players: ArrayList<Player>
        get() = getPlayers(ORDER_BY_ID)

    fun getPlayers(orderValue: Int): ArrayList<Player> {
        val playersList = ArrayList<Player>()
        val db = readableDatabase
        var orderByQuery: String? = null
        when (orderValue) {
            ORDER_BY_ID -> orderByQuery = ORDER_BY + KEY_PLAYER_ID
            ORDER_BY_LEVEL -> orderByQuery = ORDER_BY + KEY_PLAYER_LEVEL
            ORDER_BY_STRENGTH -> orderByQuery = ORDER_BY + KEY_PLAYER_STRENGTH
            ORDER_BY_TOTAL -> orderByQuery = ORDER_BY + KEY_PLAYER_TOTAL
        }
        val playersTotalQuery = "SELECT " +
                KEY_PLAYER_ID + ", " +
                KEY_PLAYER_NAME + ", " +
                KEY_PLAYER_LEVEL + ", " +
                KEY_PLAYER_STRENGTH + ", " +
                KEY_PLAYER_COLOR + ", (" +
                KEY_PLAYER_LEVEL + " + " + KEY_PLAYER_STRENGTH + ") AS " + KEY_PLAYER_TOTAL +
                " FROM " + TABLE_PLAYERS + orderByQuery + " DESC"
        Log.v(TAG, playersTotalQuery)
        val cursor = db.rawQuery(playersTotalQuery, null)
        try {
            if (cursor!!.moveToFirst()) {
                do {
                    val player = Player(
                            id = cursor.getLong(cursor.getColumnIndex(KEY_PLAYER_ID)),
                            name = cursor.getString(cursor.getColumnIndex(KEY_PLAYER_NAME)),
                            color = cursor.getString(cursor.getColumnIndex(KEY_PLAYER_COLOR)),
                            levelScore = cursor.getInt(cursor.getColumnIndex(KEY_PLAYER_LEVEL)),
                            strengthScore = cursor.getInt(cursor.getColumnIndex(KEY_PLAYER_STRENGTH)),
                            totalScore = cursor.getInt(cursor.getColumnIndex(KEY_PLAYER_TOTAL))
                    )
                    playersList.add(player)
                } while (cursor.moveToNext())
            }
        } catch (e: Exception) {
            Log.e(TAG, "Error while getting players")
        } finally {
            if (cursor != null && !cursor.isClosed) {
                cursor.close()
            }
        }
        return playersList
    }

    fun updatePlayer(player: Player): Player {
        val db = writableDatabase
        val values = ContentValues()
        values.put(KEY_PLAYER_LEVEL, player.levelScore)
        values.put(KEY_PLAYER_STRENGTH, player.strengthScore)
        db.update(TABLE_PLAYERS, values, KEY_PLAYER_ID + " = ?",
                arrayOf(player.id.toString()))
        return player
    }

    fun deletePlayer(id: Long) {
        Log.v(TAG, "Id of the player is " + id)
        val db = writableDatabase
        db.beginTransaction()
        try {
            db.delete(TABLE_PLAYERS, KEY_PLAYER_ID + " = ?", arrayOf(java.lang.Long.toString(id)))
            db.setTransactionSuccessful()
        } catch (e: Exception) {
            Log.e(TAG, "Error while deleting player")
        } finally {
            db.endTransaction()
        }
    }

    private fun isTableEmpty(db: SQLiteDatabase, tableName: String): Boolean {
        val countQuery = "SELECT COUNT(*) FROM " + tableName
        val cursor = db.rawQuery(countQuery, null)
        cursor.moveToFirst()
        val count = cursor.getInt(0)
        if (count > 0) {
            return false
        } else {
            return true
        }
    }

    private fun addColorsToUpdatedPlayers(db: SQLiteDatabase) {
        val values = ContentValues()
        values.put(KEY_PLAYER_COLOR, "#3B1606")
        db.update(TABLE_PLAYERS, values, null, null)
    }

    fun clearPlayersStats() {
        val db = writableDatabase
        val values = ContentValues()
        values.put(KEY_PLAYER_LEVEL, 1)
        values.put(KEY_PLAYER_STRENGTH, 1)
        db.update(TABLE_PLAYERS, values, null, null)
    }

    fun insertStep(gameStep: GameStep) {
        val db = writableDatabase
        db.beginTransaction()
        try {
            val values = ContentValues()
            values.put(KEY_GAME_PLAYER_ID, gameStep.playerId)
            values.put(KEY_GAME_PLAYER_LEVEL, gameStep.playerLevel)
            values.put(KEY_GAME_PLAYER_STRENGTH, gameStep.playerStrength)
            db.insertOrThrow(TABLE_GAME, null, values)
            db.setTransactionSuccessful()
        } catch (e: Exception) {
            Log.e(TAG, "Error while trying to insert step to database")
        } finally {
            db.endTransaction()
        }
    }

    fun clearSteps() {
        Log.v(TAG, "Clearing game steps")
        val db = writableDatabase
        db.beginTransaction()
        try {
            db.delete(TABLE_GAME, null, null)
            db.setTransactionSuccessful()
        } catch (e: Exception) {
            Log.e(TAG, "Error while trying to delete game steps")
        } finally {
            db.endTransaction()
        }
    }

    val gameSteps: ArrayList<GameStep>
        get() {
            Log.v(TAG, "GET GAME STEPS")
            val gameSteps = ArrayList<GameStep>()
            val db = readableDatabase
            val lineChartQuery = "SELECT " +
                    KEY_GAME_PLAYER_ID + ", " +
                    KEY_GAME_PLAYER_LEVEL + ", " +
                    KEY_GAME_PLAYER_STRENGTH + ", " +
                    KEY_PLAYER_NAME + ", " +
                    KEY_PLAYER_COLOR + " FROM " + TABLE_GAME +
                    " INNER JOIN " + TABLE_PLAYERS + " ON players.id = " + KEY_GAME_PLAYER_ID
            Log.v("TAG", lineChartQuery)
            val cursor = db.rawQuery(lineChartQuery, null)
            try {
                if (cursor!!.moveToFirst()) {
                    do {
                        val gameStep = GameStep(
                        playerId = cursor.getLong(cursor.getColumnIndex(KEY_GAME_PLAYER_ID)),
                        playerLevel = cursor.getInt(cursor.getColumnIndex(KEY_GAME_PLAYER_LEVEL)),
                        playerStrength = cursor.getInt(cursor.getColumnIndex(KEY_GAME_PLAYER_STRENGTH)))
                        gameSteps.add(gameStep)
                    } while (cursor.moveToNext())
                }
            } catch (e: Exception) {
                Log.e(TAG, "Error while getting game steps")
            } finally {
                if (cursor != null && !cursor.isClosed) {
                    cursor.close()
                }
            }
            return gameSteps
        }

    companion object {

        private val TAG = LogUtil.makeLogTag(MunchkinDatabaseHelper::class)

        private val DATABASE_NAME = "players_db"
        private val DATABASE_VERSION = 6

        private val TABLE_PLAYERS = "players"

        private val KEY_PLAYER_ID = "id"
        private val KEY_PLAYER_NAME = "name"
        private val KEY_PLAYER_LEVEL = "level"
        private val KEY_PLAYER_STRENGTH = "strength"
        private val KEY_PLAYER_COLOR = "color"
        private val KEY_PLAYER_TOTAL = "total"

        private val TABLE_GAME = "game"

        private val KEY_GAME_PLAYER_ID = "player_id"
        private val KEY_GAME_PLAYER_LEVEL = "player_level"
        private val KEY_GAME_PLAYER_STRENGTH = "player_strength"

        private val ORDER_BY = " ORDER BY "

        private val ORDER_BY_ID = 0
        private val ORDER_BY_LEVEL = 1
        private val ORDER_BY_STRENGTH = 2
        private val ORDER_BY_TOTAL = 3
    }

}
