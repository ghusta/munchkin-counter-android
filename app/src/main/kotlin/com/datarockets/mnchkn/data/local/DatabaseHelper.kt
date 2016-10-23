package com.datarockets.mnchkn.data.local

import android.content.ContentValues
import android.database.Cursor
import com.datarockets.mnchkn.data.model.GameStep
import com.datarockets.mnchkn.data.model.Player
import com.squareup.sqlbrite.BriteDatabase
import com.squareup.sqlbrite.SqlBrite
import rx.Observable
import rx.schedulers.Schedulers
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class DatabaseHelper
@Inject constructor(dbOpenHelper: DbOpenHelper) {

    private val mDb: BriteDatabase

    init {
        mDb = SqlBrite.Builder().build().wrapDatabaseHelper(dbOpenHelper, Schedulers.io())
    }

    fun getBriteDb(): BriteDatabase = mDb

    fun addPlayer(player: Player): Observable<Player> {
        return Observable.create { subscriber ->
            val transaction: BriteDatabase.Transaction = mDb.newTransaction()
            try {
                val id = mDb.insert(Db.PlayersTable.TABLE_NAME, Db.PlayersTable.toContentValues(player))
                player.id = id
                transaction.markSuccessful()
                subscriber.onNext(player)
                subscriber.onCompleted()
            } finally {
                transaction.end()
            }
        }
    }

    fun getPlayers(orderValue: Int): Observable<ArrayList<Player>> {
        return Observable.create { subscriber ->
            val playersList = ArrayList<Player>()
            var orderByQuery: String? = null
            when (orderValue) {
                Db.PlayersTable.ORDER_BY_ID -> orderByQuery = " ORDER BY " + Db.PlayersTable.COLUMN_ID
                Db.PlayersTable.ORDER_BY_LEVEL -> orderByQuery = " ORDER BY " + Db.PlayersTable.COLUMN_LEVEL
                Db.PlayersTable.ORDER_BY_STRENGTH -> orderByQuery = " ORDER BY " + Db.PlayersTable.COLUMN_STRENGTH
                Db.PlayersTable.ORDER_BY_TOTAL -> orderByQuery = " ORDER BY " + Db.PlayersTable.COLUMN_TOTAL
            }
            val cursor: Cursor = mDb.query(
                    "SELECT " +
                            Db.PlayersTable.COLUMN_ID + ", " +
                            Db.PlayersTable.COLUMN_NAME + ", " +
                            Db.PlayersTable.COLUMN_LEVEL + ", " +
                            Db.PlayersTable.COLUMN_STRENGTH + ", " +
                            Db.PlayersTable.COLUMN_COLOR + ", (" +
                            Db.PlayersTable.COLUMN_LEVEL + " + " + Db.PlayersTable.COLUMN_STRENGTH + ") AS " +
                            Db.PlayersTable.COLUMN_TOTAL + " FROM " + Db.PlayersTable.TABLE_NAME + orderByQuery + " DESC"
            )
            try {
                if (cursor.moveToFirst()) {
                    do {
                        val player = Db.PlayersTable.parseCursor(cursor)
                        playersList.add(player)
                    } while (cursor.moveToNext())
                    subscriber.onNext(playersList)
                }
            } finally {
                cursor.close()
                subscriber.onCompleted()
            }
        }
    }

    fun updatePlayer(player: Player): Observable<Player> {
        return Observable.create { subscriber ->
            val transaction: BriteDatabase.Transaction = mDb.newTransaction()
            try {
                mDb.update(
                        Db.PlayersTable.TABLE_NAME,
                        Db.PlayersTable.toContentValues(player),
                        Db.PlayersTable.COLUMN_ID + " = ?",
                        player.id.toString())
                transaction.markSuccessful()
                subscriber.onNext(player)
                subscriber.onCompleted()
            } finally {
                transaction.end()
            }
        }
    }

    fun deletePlayer(id: Long): Observable<Void> {
        return Observable.create { subscriber ->
            val transaction: BriteDatabase.Transaction = mDb.newTransaction()
            try {
                mDb.delete(
                        Db.PlayersTable.TABLE_NAME,
                        Db.PlayersTable.COLUMN_ID + " = ?",
                        id.toString()
                )
                transaction.markSuccessful()
                subscriber.onCompleted()
            } finally {
                transaction.end()
            }
        }
    }

    fun addColorsToUpdatedPlayers(): Observable<Void> {
        return Observable.create { subscriber ->
            val contentValues = ContentValues()
            contentValues.put(Db.PlayersTable.COLUMN_COLOR, "#3B1606")
            val transaction: BriteDatabase.Transaction = mDb.newTransaction()
            try {
                mDb.update(Db.PlayersTable.TABLE_NAME, contentValues, null, null)
                transaction.markSuccessful()
                subscriber.onCompleted()
            } finally {
                transaction.end()
            }
        }
    }

    fun clearPlayersStats(): Observable<Void> {
        return Observable.create { subscriber ->
            val transaction: BriteDatabase.Transaction = mDb.newTransaction()
            try {
                val values = ContentValues()
                values.put(Db.PlayersTable.COLUMN_LEVEL, 1)
                values.put(Db.PlayersTable.COLUMN_STRENGTH, 1)
                mDb.update(Db.PlayersTable.TABLE_NAME, values, 3, null, null)
                transaction.markSuccessful()
                subscriber.onCompleted()
            } finally {
                transaction.end()
            }
        }
    }

    fun insertStep(gameStep: GameStep): Observable<Void> {
        return Observable.create { subscriber ->
            val transaction: BriteDatabase.Transaction = mDb.newTransaction()
            try {
                mDb.insert(Db.GameTable.TABLE_NAME, Db.GameTable.toContentValues(gameStep))
                transaction.markSuccessful()
                subscriber.onCompleted()
            } finally {
                transaction.end()
            }
        }
    }

    fun clearSteps(): Observable<Void> {
        return Observable.create { subscriber ->
            val transaction: BriteDatabase.Transaction = mDb.newTransaction()
            try {
                mDb.delete(Db.GameTable.TABLE_NAME, null, null)
                transaction.markSuccessful()
                subscriber.onCompleted()
            } finally {
                transaction.end()
            }
        }
    }

    fun getGameSteps(): Observable<ArrayList<GameStep>> {
        return Observable.create { subscriber ->
            val gameSteps = ArrayList<GameStep>()
            val cursor: Cursor = mDb.query(
                    "SELECT " +
                            Db.GameTable.COLUMN_PLAYER_ID + ", " +
                            Db.GameTable.COLUMN_PLAYER_LEVEL + ", " +
                            Db.GameTable.COLUMN_PLAYER_STRENGTH + ", " +
                            Db.PlayersTable.COLUMN_NAME + ", " +
                            Db.PlayersTable.COLUMN_COLOR + " FROM " + Db.GameTable.TABLE_NAME +
                            " INNER JOIN " + Db.PlayersTable.TABLE_NAME + " ON players.id = " +
                            Db.GameTable.COLUMN_PLAYER_ID
            )
            try {
                if (cursor.moveToFirst()) {
                    do {
                        val gameStep = Db.GameTable.parseCursor(cursor)
                        gameSteps.add(gameStep)
                    } while (cursor.moveToNext())
                    subscriber.onNext(gameSteps)
                }
            } finally {
                cursor.close()
                subscriber.onCompleted()
            }
        }
    }

    fun getGameStepsByPlayerId(playerId: Long): Observable<ArrayList<GameStep>> {
        return Observable.create { subscriber ->

        }
    }

}