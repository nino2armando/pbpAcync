package com.verrus.paybyphoneasync.Helpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.verrus.paybyphoneasync.Models.UserInputContract;

import java.net.PortUnreachableException;

/**
 * Created by nkhodabandeh on 15/01/14.
 */
public class UserEntryDbHelper extends SQLiteOpenHelper {

    // If you change the database schema, you must increment the database version.
    public static final int DATABAE_VERSION = 1;
    public static final String DATABASE_NAME = "UserInput.db";


    // QUERIES
    private static final String COMMA_SEP = ",";
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + UserInputContract.UserEntry.TABLE_NAME +
                    " (" +
                    UserInputContract.UserEntry._ID + "INTEGER PRIMARY KEY,"
                    + UserInputContract.UserEntry.COLUMN_NAME_ENTRY_ID + "TEXT ,"
                    + UserInputContract.UserEntry.COLUMN_NAME + "TEXT ,"
                    + UserInputContract.UserEntry.COLUMN_VALUE + "TEXT" + ")";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + UserInputContract.UserEntry.TABLE_NAME;

    public UserEntryDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABAE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion){
        onUpgrade(db, oldVersion, newVersion);
    }
}
