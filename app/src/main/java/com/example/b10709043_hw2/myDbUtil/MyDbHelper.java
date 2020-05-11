package com.example.b10709043_hw2.myDbUtil;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "waitList.db";
    private static final int DATABASE_VERSION = 1;

    public MyDbHelper(@Nullable Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String FORMAT = "CREATE TABLE %s (   %s INTEGER PRIMARY KEY AUTOINCREMENT," +
                                            "%s TEXT NOT NULL," +
                                            "%s INTEGER NOT NULL," +
                                            "%s TIMESTAMP DEFAULT CURRENT_TIMESTAMP)";
        String sql = String.format(FORMAT,  MyDbContact.WaitList.TABLE_NAME,
                                            MyDbContact.WaitList.COLUMN_NAME,
                                            MyDbContact.WaitList.COLUMN_PARTY_SIZE,
                                            MyDbContact.WaitList.COLUMN_TIMESTAMP);
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ MyDbContact.WaitList.TABLE_NAME);
        onCreate(db);
    }
}
