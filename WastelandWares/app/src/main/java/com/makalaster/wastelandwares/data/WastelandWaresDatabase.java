package com.makalaster.wastelandwares.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Makalaster on 4/9/17.
 */

public class WastelandWaresDatabase extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DB_NAME = "wastelandwares.db";

    private static WastelandWaresDatabase sInstance;

    static WastelandWaresDatabase getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new WastelandWaresDatabase(context.getApplicationContext());
        }
        return sInstance;
    }

    private WastelandWaresDatabase(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
