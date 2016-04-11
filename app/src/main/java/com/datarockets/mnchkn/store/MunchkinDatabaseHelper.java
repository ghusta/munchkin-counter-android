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

import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;

public class MunchkinDatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG = LogUtil.makeLogTag(MunchkinDatabaseHelper.class);

    private static final String DATABASE_NAME = "players_db";
    private static final int DATABASE_VERSION = 2;

    private static final String TABLE_PLAYERS = "players";

    private static final String KEY_PLAYER_ID = "id";
    private static final String KEY_PLAYER_NAME = "name";
    private static final String KEY_PLAYER_LEVEL = "level";
    private static final String KEY_PLAYER_STRENGTH = "strength";
    private static final String KEY_PLAYER_COLOR = "color";

    private static final String TABLE_GAME = "game";

    private static final String KEY_GAME_PLAYER_ID = "player_id";
    private static final String KEY_GAME_PLAYER_LEVEL = "player_level";
    private static final String KEY_GAME_PLAYER_STRENGTH = "player_strength";

    private static MunchkinDatabaseHelper instance;

    public static synchronized MunchkinDatabaseHelper getInstance(Context context) {
        if (instance == null) {
            instance = new MunchkinDatabaseHelper(context.getApplicationContext());
        }
        return instance;
    }

    private MunchkinDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_PLAYERS_TABLE = "CREATE TABLE " + TABLE_PLAYERS +
                "(" +
                KEY_PLAYER_ID + " INTEGER PRIMARY KEY," +
                KEY_PLAYER_NAME + " TEXT," +
                KEY_PLAYER_LEVEL + " INTEGER," +
                KEY_PLAYER_STRENGTH + " INTEGER," +
                KEY_PLAYER_COLOR + " TEXT" +
                ")";
        String CREATE_GAME_TABLE = "CREATE TABLE " + TABLE_GAME +
                "(" +
                KEY_GAME_PLAYER_ID + " INTEGER REFERENCES " + TABLE_PLAYERS + "," +
                KEY_GAME_PLAYER_LEVEL + " INTEGER," +
                KEY_GAME_PLAYER_STRENGTH + " INTEGER" +
                ")";
        db.execSQL(CREATE_PLAYERS_TABLE);
        db.execSQL(CREATE_GAME_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        switch (oldVersion) {
            case 1:
                db.execSQL("ALTER TABLE " + TABLE_PLAYERS + " ADD COLUMN " + KEY_PLAYER_COLOR + " TEXT");
                if (!isTableEmpty(db, TABLE_PLAYERS)) {
                    addColorsToUpdatedPlayers(db);
                }
            default:
                break;
        }
    }

    public long addPlayer(Player player) {
        long playerId = -1;
        SQLiteDatabase db = getWritableDatabase();
        db.beginTransaction();
        try {
            ContentValues values = new ContentValues();
            values.put(KEY_PLAYER_NAME, player.name);
            values.put(KEY_PLAYER_LEVEL, player.levelScore);
            values.put(KEY_PLAYER_STRENGTH, player.strengthScore);
            values.put(KEY_PLAYER_COLOR, player.color);
            playerId = db.insertOrThrow(TABLE_PLAYERS, null, values);
            db.setTransactionSuccessful();
            Log.i(TAG, "Player id is " + playerId);
        } catch (Exception e) {
            Log.e(TAG, "Error while trying to add new player");
            e.printStackTrace();
        } finally {
            db.endTransaction();
        }
        return playerId;
    }

    public ArrayList<Player> getPlayers() {
        ArrayList<Player> players = new ArrayList<>();
        String PLAYERS_SELECT_QUERY = String.format("SELECT * FROM " + TABLE_PLAYERS);
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(PLAYERS_SELECT_QUERY, null);
        try {
            if (cursor.moveToFirst()) {
                do {
                    Player player = new Player();
                    player.setId(cursor.getLong(cursor.getColumnIndex(KEY_PLAYER_ID)));
                    player.setName(cursor.getString(cursor.getColumnIndex(KEY_PLAYER_NAME)));
                    player.setLevelScore(cursor.getInt(cursor.getColumnIndex(KEY_PLAYER_LEVEL)));
                    player.setStrengthScore(cursor.getInt(cursor.getColumnIndex(KEY_PLAYER_STRENGTH)));
                    player.setColor(cursor.getString(cursor.getColumnIndex(KEY_PLAYER_COLOR)));
                    players.add(player);
                } while(cursor.moveToNext());
            }
        } catch (Exception e) {
            Log.e(TAG, "Error while trying to get posts from database");
            e.printStackTrace();
        } finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        }
        return players;
    }

    public Player updatePlayer(Player player) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_PLAYER_LEVEL, player.levelScore);
        values.put(KEY_PLAYER_STRENGTH, player.strengthScore);
        db.update(TABLE_PLAYERS, values, KEY_PLAYER_ID + " = ?", new String[] {String.valueOf(player.id)});
        return player;
    }

    public void deletePlayer(long id) {
        Log.v(TAG, "Id of the player is " + id);
        SQLiteDatabase db = getWritableDatabase();
        db.beginTransaction();
        try {
            db.delete(TABLE_PLAYERS, KEY_PLAYER_ID + " = ?", new String[] {Long.toString(id)});
            db.setTransactionSuccessful();
        } catch (Exception e) {
            Log.e(TAG, "Error while deleting player");
            e.printStackTrace();
        } finally {
            db.endTransaction();
        }
    }

    private boolean isTableEmpty(SQLiteDatabase db, String tableName) {
        String countQuery = "SELECT COUNT(*) FROM " + tableName;
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.moveToFirst();
        int count = cursor.getInt(0);
        if (count > 0) {
            return false;
        } else {
            return true;
        }
    }

    private void addColorsToUpdatedPlayers(SQLiteDatabase db) {
        ContentValues values = new ContentValues();
        values.put(KEY_PLAYER_COLOR, "#3B1606");
        db.update(TABLE_PLAYERS, values, null, null);
    }

    public void clearPlayersStats() {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_PLAYER_LEVEL, 1);
        values.put(KEY_PLAYER_STRENGTH, 1);
        db.update(TABLE_PLAYERS, values, null, null);
    }

    public void insertStep(Player player) {
        SQLiteDatabase db = getWritableDatabase();
        db.beginTransaction();
        try {
            ContentValues values = new ContentValues();
            values.put(KEY_GAME_PLAYER_ID, player.id);
            values.put(KEY_GAME_PLAYER_LEVEL, player.levelScore);
            values.put(KEY_GAME_PLAYER_STRENGTH, player.strengthScore);
            db.insertOrThrow(TABLE_GAME, null, values);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            Log.e(TAG, "Error while trying to insert step to database");
            e.printStackTrace();
        } finally {
            db.endTransaction();
        }
    }

    public void clearSteps() {
        SQLiteDatabase db = getWritableDatabase();
        try {
            db.delete(TABLE_GAME, null, null);
        } catch (Exception e) {
            Log.e(TAG, "Error while trying to delete game steps");
        } finally {
            db.endTransaction();
        }
    }

    public LineChartData getLineChartData() {
        List<PointValue> values = new ArrayList<>();
        List<Line> lines = new ArrayList<>();
        LineChartData data = new LineChartData(lines);

        SQLiteDatabase db = getReadableDatabase();
        String LINE_CHART_QUERY = "SELECT * FROM " + TABLE_GAME;
        Cursor cursor = db.rawQuery(LINE_CHART_QUERY, null);
        try {
            if (cursor.moveToFirst()) {
                do {
                    Player player = new Player();
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            Log.e(TAG, "Error while getting linechart data");
            e.printStackTrace();
        }
        return data;
    }

    public ArrayList<Player> getGameStats(int type) {
        ArrayList<Player> players = new ArrayList<>();
        String GAME_SELECT_QUERY = String.format("SELECT * FROM " + TABLE_GAME);
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(GAME_SELECT_QUERY, null);
        try {
            if (cursor.moveToFirst()) {
                do {
                    Player player = new Player();

                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            Log.e(TAG, "Error while getting game stats from database");
        } finally {
            db.endTransaction();
        }
        return players;
    }

}
