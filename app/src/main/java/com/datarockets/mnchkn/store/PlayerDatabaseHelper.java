package com.datarockets.mnchkn.store;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.datarockets.mnchkn.models.Player;
import com.datarockets.mnchkn.utils.LogUtil;

import java.util.ArrayList;
import java.util.List;

public class PlayerDatabaseHelper extends SQLiteOpenHelper{

    private static final String TAG = LogUtil.makeLogTag(PlayerDatabaseHelper.class);

    private static PlayerDatabaseHelper instance;

    private static final String DATABASE_NAME = "players_db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_PLAYERS = "players";

    private static final String KEY_PLAYER_ID = "id";
    private static final String KEY_PLAYER_NAME = "name";
    private static final String KEY_PLAYER_LEVEL = "level";
    private static final String KEY_PLAYER_STRENGTH = "strength";

    private PlayerDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static synchronized PlayerDatabaseHelper getInstance(Context context) {
        if (instance == null) {
            instance = new PlayerDatabaseHelper(context);
        }
        return instance;
    }

    @Override
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
        db.setForeignKeyConstraintsEnabled(true);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_PLAYERS_TABLE = "CREATE TABLE " + TABLE_PLAYERS +
                "(" +
                KEY_PLAYER_ID + " INTEGER PRIMARY KEY," +
                KEY_PLAYER_NAME + " TEXT," +
                KEY_PLAYER_LEVEL + " INTEGER," +
                KEY_PLAYER_STRENGTH + " INTEGER" +
                ")";
        db.execSQL(CREATE_PLAYERS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_PLAYERS);
            onCreate(db);
        }
    }

    public void addPlayer(Player player) {
        SQLiteDatabase db = getWritableDatabase();
        db.beginTransaction();
        try {
            ContentValues values = new ContentValues();
            values.put(KEY_PLAYER_NAME, player.name);
            values.put(KEY_PLAYER_LEVEL, player.levelScore);
            values.put(KEY_PLAYER_STRENGTH, player.strengthScore);
            db.insertOrThrow(TABLE_PLAYERS, null, values);
        } catch (Exception e) {
            Log.d(TAG, "Error while trying to add new player");
            e.printStackTrace();
        } finally {
            db.endTransaction();
        }
    }

    public Player getPlayer(int index) {
        Player player = new Player();
        String PLAYER_SELECT_QUERY = "SELECT * FROM " + TABLE_PLAYERS + " WHERE id = " + index;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(PLAYER_SELECT_QUERY, null);
        try {
            if (cursor.moveToFirst()) {
                do {
                    player.name = cursor.getString(cursor.getColumnIndex(KEY_PLAYER_NAME));
                    player.levelScore = cursor.getInt(cursor.getColumnIndex(KEY_PLAYER_LEVEL));
                    player.strengthScore = cursor.getInt(cursor.getColumnIndex(KEY_PLAYER_STRENGTH));
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            Log.d(TAG, "Error while getting the player the record");
            e.printStackTrace();
        } finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        }
        return player;
    }

    public List<Player> getPlayers() {
        List<Player> players = new ArrayList<>();
        String PLAYERS_SELECT_QUERY = String.format("SELECT * FROM %s", TABLE_PLAYERS);
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(PLAYERS_SELECT_QUERY, null);
        try {
            if (cursor.moveToFirst()) {
                do {
                    Player player = new Player();
                    player.name = cursor.getString(cursor.getColumnIndex(KEY_PLAYER_NAME));
                    player.levelScore = cursor.getInt(cursor.getColumnIndex(KEY_PLAYER_LEVEL));
                    player.strengthScore = cursor.getInt(cursor.getColumnIndex(KEY_PLAYER_STRENGTH));
                    players.add(player);
                } while(cursor.moveToNext());
            }
        } catch (Exception e) {
            Log.d(TAG, "Error while trying to get posts from database");
            e.printStackTrace();
        } finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        }
        return players;
    }

    public void updatePlayer(int position, Player player) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_PLAYER_LEVEL, player.levelScore);
        values.put(KEY_PLAYER_STRENGTH, player.strengthScore);
        db.update(TABLE_PLAYERS, values, KEY_PLAYER_ID + " = ?", new String[] {String.valueOf(position)});
    }

    public void deletePlayer(int position) {
        SQLiteDatabase db = getWritableDatabase();
        db.beginTransaction();
        try {
            db.delete(TABLE_PLAYERS, KEY_PLAYER_ID + " = " + String.valueOf(position), null);
        } catch (Exception e) {
            Log.d(TAG, "Error while deleting player");
            e.printStackTrace();
        } finally {
            db.endTransaction();
        }
    }


}
