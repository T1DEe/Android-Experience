package com.example.artemymarkovsky.countriesdatabase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {

    static final String TABLE_NAME = "Countries";
    static final String LOG_TAG = "dbLog";

    public DBHelper(Context context) {
        super(context, TABLE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "CREATE TABLE " + TABLE_NAME + "(" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "name TEXT," +
                    "population INTEGER," +
                    "region TEXT );"
        );

        Log.d(LOG_TAG, "Database was create.");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
