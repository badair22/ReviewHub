package com.bignerdranch.android.reviewhub.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.bignerdranch.android.reviewhub.database.UserDbSchema.UserTable;

public class ReviewBaseHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "reviewHub.db";

    public ReviewBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + UserTable.NAME + "(" +
                " _id integer primary key autoincrement, " +
                UserTable.Cols.UUID + ", " +
                UserTable.Cols.FIRST + ", " +
                UserTable.Cols.LAST + ", " +
                UserTable.Cols.EMAIL + ", " +
                UserTable.Cols.USERNAME +
                ")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
