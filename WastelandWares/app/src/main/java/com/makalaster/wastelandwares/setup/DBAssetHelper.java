package com.makalaster.wastelandwares.setup;

import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * Helper class to set up the database
 */

public class DBAssetHelper extends SQLiteAssetHelper {
    private static final String DATABASE_NAME = "wastelandwares.db";
    private static final int DATABASE_VERSION = 1;

    public DBAssetHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

}
