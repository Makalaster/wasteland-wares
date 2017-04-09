package com.makalaster.wastelandwares.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.makalaster.wastelandwares.MainActivity;

/**
 * Created by Makalaster on 4/9/17.
 */

public class Inventory extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DB_NAME = "wastelandwares.db";

    private static Inventory sInventory;

    static Inventory getInstance(Context context) {
        if (sInventory == null) {
            sInventory = new Inventory(context.getApplicationContext());
        }
        return sInventory;
    }

    private Inventory(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
