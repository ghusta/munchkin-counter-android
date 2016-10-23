package com.datarockets.mnchkn.data.local

import android.content.ContentValues
import android.database.Cursor
import com.datarockets.mnchkn.data.model.GameStep
import com.datarockets.mnchkn.data.model.Player

class Db {

    constructor() {
    }

    object PlayersTable {
        val TABLE_NAME = "players"

        val COLUMN_ID = "id"
        val COLUMN_NAME = "name"
        val COLUMN_LEVEL = "level"
        val COLUMN_STRENGTH = "strength"
        val COLUMN_COLOR = "color"
        val COLUMN_TOTAL = "total"

        val ORDER_BY_ID = 0
        val ORDER_BY_LEVEL = 1
        val ORDER_BY_STRENGTH = 2
        val ORDER_BY_TOTAL = 3

        val CREATE = "CREATE TABLE " + TABLE_NAME +
                "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY," +
                COLUMN_NAME + " TEXT," +
                COLUMN_LEVEL + " INTEGER," +
                COLUMN_STRENGTH + " INTEGER," +
                COLUMN_COLOR + " TEXT" +
                ")"

        fun toContentValues(player: Player): ContentValues {
            val contentValues = ContentValues()
            contentValues.put(COLUMN_NAME, player.name)
            contentValues.put(COLUMN_LEVEL, player.levelScore)
            contentValues.put(COLUMN_STRENGTH, player.strengthScore)
            contentValues.put(COLUMN_COLOR, player.color)
            return contentValues
        }

        fun parseCursor(cursor: Cursor): Player {
            val player = Player(
                    id = cursor.getLong(cursor.getColumnIndex(COLUMN_ID)),
                    name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME)),
                    color = cursor.getString(cursor.getColumnIndex(COLUMN_COLOR)),
                    levelScore = cursor.getInt(cursor.getColumnIndex(COLUMN_LEVEL)),
                    strengthScore = cursor.getInt(cursor.getColumnIndex(COLUMN_STRENGTH)),
                    totalScore = cursor.getInt(cursor.getColumnIndex(COLUMN_TOTAL))
            )
            return player
        }

    }

    object GameTable {
        val TABLE_NAME = "game"

        val COLUMN_PLAYER_ID = "player_id"
        val COLUMN_PLAYER_LEVEL = "player_level"
        val COLUMN_PLAYER_STRENGTH = "player_strength"

        val ORDER_BY = " ORDER BY "

        val ORDER_BY_ID = 0
        val ORDER_BY_LEVEL = 1
        val ORDER_BY_STRENGTH = 2
        val ORDER_BY_TOTAL = 3

        val CREATE = "CREATE TABLE " + TABLE_NAME +
                "(" +
                COLUMN_PLAYER_ID + " INTEGER REFERENCES " + PlayersTable.TABLE_NAME + "," +
                COLUMN_PLAYER_LEVEL+ " INTEGER," +
                COLUMN_PLAYER_STRENGTH + " INTEGER" +
                ")"

        fun toContentValues(gameStep: GameStep) : ContentValues {
            val contentValues = ContentValues()
            contentValues.put(COLUMN_PLAYER_ID, gameStep.playerId)
            contentValues.put(COLUMN_PLAYER_LEVEL, gameStep.playerLevel)
            contentValues.put(COLUMN_PLAYER_STRENGTH, gameStep.playerStrength)
            return contentValues
        }

        fun parseCursor(cursor: Cursor) : GameStep {
            val gameStep = GameStep(
                    playerId = cursor.getLong(cursor.getColumnIndex(COLUMN_PLAYER_ID)),
                    playerLevel = cursor.getInt(cursor.getColumnIndex(COLUMN_PLAYER_LEVEL)),
                    playerStrength = cursor.getInt(cursor.getColumnIndex(COLUMN_PLAYER_STRENGTH))
            )
            return gameStep
        }
    }

}