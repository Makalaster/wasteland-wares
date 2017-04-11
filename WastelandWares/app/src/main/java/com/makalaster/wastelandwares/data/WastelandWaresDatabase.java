package com.makalaster.wastelandwares.data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Makalaster on 4/9/17.
 */

public class WastelandWaresDatabase extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DB_NAME = "wastelandwares.db";

    public static abstract class MiscTable implements BaseColumns {
        public static final String TABLE_NAME = "miscellaneous";
        public static final String COLUMN_ID = "item_id";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_DESCRIPTION = "description";
        public static final String COLUMN_PRICE = "price";
        public static final String COLUMN_WEIGHT = "weight";
        public static final String COLUMN_RATING = "rating";
    }

    public static final String SQL_CREATE_TABLE_MISCELLANEOUS =
            "CREATE TABLE " + MiscTable.TABLE_NAME + " (" +
                    MiscTable.COLUMN_ID + " INTEGER PRIMARY KEY," +
                    MiscTable.COLUMN_NAME + " TEXT," +
                    MiscTable.COLUMN_DESCRIPTION + " TEXT," +
                    MiscTable.COLUMN_PRICE + " INTEGER," +
                    MiscTable.COLUMN_WEIGHT + " INTEGER," +
                    MiscTable.COLUMN_RATING + " TEXT)";

    public static final String SQL_DELETE_ENTRIES_MISCELLANEOUS =
            "DROP TABLE IF EXISTS " + MiscTable.TABLE_NAME;

    public static abstract class AidTable implements BaseColumns {
        public static final String TABLE_NAME = "aid";
        public static final String COLUMN_ID = "aid_id";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_DESCRIPTION = "description";
        public static final String COLUMN_PRICE = "price";
        public static final String COLUMN_WEIGHT = "weight";
        public static final String COLUMN_RATING = "rating";
        public static final String COLUMN_HP = "hp";
        public static final String COLUMN_RADS = "radiation";
    }

    public static final String SQL_CREATE_TABLE_AID =
            "CREATE TABLE " + AidTable.TABLE_NAME + " (" +
                    AidTable.COLUMN_ID + " INTEGER PRIMARY KEY," +
                    AidTable.COLUMN_NAME + " TEXT," +
                    AidTable.COLUMN_DESCRIPTION + " TEXT," +
                    AidTable.COLUMN_PRICE + " INTEGER," +
                    AidTable.COLUMN_WEIGHT + " INTEGER," +
                    AidTable.COLUMN_RATING + " TEXT," +
                    AidTable.COLUMN_HP + " INTEGER," +
                    AidTable.COLUMN_RADS + " INTEGER)";

    public static final String SQL_DELETE_ENTRIES_AID =
            "DROP TABLE IF EXISTS " + AidTable.TABLE_NAME;

    public static abstract class WeaponTable implements BaseColumns {
        public static final String TABLE_NAME = "weapons";
        public static final String COLUMN_ID = "weapon_id";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_DESCRIPTION = "description";
        public static final String COLUMN_PRICE = "price";
        public static final String COLUMN_WEIGHT = "weight";
        public static final String COLUMN_RATING = "rating";
        public static final String COLUMN_DAMAGE = "damage";
        public static final String COLUMN_CAPACITY = "capacity";
        public static final String COLUMN_AMMO = "ammoType";
    }

    public static final String SQL_CREATE_TABLE_WEAPONS =
            "CREATE TABLE " + WeaponTable.TABLE_NAME + " (" +
                    WeaponTable.COLUMN_ID + " INTEGER PRIMARY KEY," +
                    WeaponTable.COLUMN_NAME + " TEXT," +
                    WeaponTable.COLUMN_DESCRIPTION + " TEXT," +
                    WeaponTable.COLUMN_PRICE + " INTEGER," +
                    WeaponTable.COLUMN_WEIGHT + " INTEGER," +
                    WeaponTable.COLUMN_RATING + " TEXT," +
                    WeaponTable.COLUMN_DAMAGE + " INTEGER," +
                    WeaponTable.COLUMN_CAPACITY + " INTEGER," +
                    WeaponTable.COLUMN_AMMO + " TEXT)";

    public static final String SQL_DELETE_ENTRIES_WEAPONS =
            "DROP TABLE IF EXISTS " + WeaponTable.TABLE_NAME;

    public static abstract class ArmorTable implements BaseColumns {
        public static final String TABLE_NAME = "armor";
        public static final String COLUMN_ID = "armor_id";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_DESCRIPTION = "description";
        public static final String COLUMN_PRICE = "price";
        public static final String COLUMN_WEIGHT = "weight";
        public static final String COLUMN_RATING = "rating";
        public static final String COLUMN_DEFENSE = "defense";
    }

    public static final String SQL_CREATE_TABLE_ARMOR =
            "CREATE TABLE " + ArmorTable.TABLE_NAME + " (" +
                    ArmorTable.COLUMN_ID + " INTEGER PRIMARY KEY," +
                    ArmorTable.COLUMN_NAME + " TEXT," +
                    ArmorTable.COLUMN_DESCRIPTION + " TEXT," +
                    ArmorTable.COLUMN_PRICE + " INTEGER" +
                    ArmorTable.COLUMN_WEIGHT + " INTEGER" +
                    ArmorTable.COLUMN_RATING + " TEXT" +
                    ArmorTable.COLUMN_DEFENSE + " INTEGER)";

    public static final String SQL_DELETE_ENTRIES_ARMOR =
            "DROP TABLE IF EXISTS " + ArmorTable.TABLE_NAME;

    private static WastelandWaresDatabase sInstance;

    public static WastelandWaresDatabase getInstance(Context context) {
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
        db.execSQL(SQL_CREATE_TABLE_AID);
        db.execSQL(SQL_CREATE_TABLE_ARMOR);
        db.execSQL(SQL_CREATE_TABLE_MISCELLANEOUS);
        db.execSQL(SQL_CREATE_TABLE_WEAPONS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES_AID);
        db.execSQL(SQL_DELETE_ENTRIES_ARMOR);
        db.execSQL(SQL_DELETE_ENTRIES_WEAPONS);
        db.execSQL(SQL_DELETE_ENTRIES_MISCELLANEOUS);

        onCreate(db);
    }

    public List<Item> getAllAid() {
        List<Item> allAid = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();
        Cursor aidCursor = db.query(AidTable.TABLE_NAME, null, null, null, null, null, null);
        if (aidCursor.moveToFirst()) {
            while (!aidCursor.isAfterLast()) {
                String name = aidCursor.getString(aidCursor.getColumnIndex(AidTable.COLUMN_NAME));
                String description = aidCursor.getString(aidCursor.getColumnIndex(AidTable.COLUMN_DESCRIPTION));
                double price = aidCursor.getDouble(aidCursor.getColumnIndex(AidTable.COLUMN_PRICE));
                double rating = aidCursor.getDouble(aidCursor.getColumnIndex(AidTable.COLUMN_RATING));
                long id = aidCursor.getLong(aidCursor.getColumnIndex(AidTable.COLUMN_ID));
                int weight = aidCursor.getInt(aidCursor.getColumnIndex(AidTable.COLUMN_WEIGHT));
                int hp = aidCursor.getInt(aidCursor.getColumnIndex(AidTable.COLUMN_HP));
                int rads = aidCursor.getInt(aidCursor.getColumnIndex(AidTable.COLUMN_RADS));

                allAid.add(new Aid(name, description, price, rating, id, weight, hp, rads));
                aidCursor.moveToNext();
            }
        }
        aidCursor.close();

        return allAid;
    }

    public List<Item> getAllArmor() {
        List<Item> allArmor = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();
        Cursor armorCursor = db.query(ArmorTable.TABLE_NAME, null, null, null, null, null, null);
        if (armorCursor.moveToFirst()) {
            while (!armorCursor.isAfterLast()) {
                String name = armorCursor.getString(armorCursor.getColumnIndex(ArmorTable.COLUMN_NAME));
                String description = armorCursor.getString(armorCursor.getColumnIndex(ArmorTable.COLUMN_DESCRIPTION));
                double price = armorCursor.getDouble(armorCursor.getColumnIndex(ArmorTable.COLUMN_PRICE));
                double rating = armorCursor.getDouble(armorCursor.getColumnIndex(ArmorTable.COLUMN_RATING));
                long id = armorCursor.getLong(armorCursor.getColumnIndex(ArmorTable.COLUMN_ID));
                int weight = armorCursor.getInt(armorCursor.getColumnIndex(ArmorTable.COLUMN_WEIGHT));
                int defense = armorCursor.getInt(armorCursor.getColumnIndex(ArmorTable.COLUMN_DEFENSE));

                allArmor.add(new Armor(name, description, price, rating, id, weight, 100, defense));
                armorCursor.moveToNext();
            }
        }
        armorCursor.close();

        return allArmor;
    }

    public List<Item> getAllWeapons() {
        List<Item> allWeapons = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();
        Cursor weaponCursor = db.query(WeaponTable.TABLE_NAME, null, null, null, null, null, null);
        if (weaponCursor.moveToFirst()) {
            while (!weaponCursor.isAfterLast()) {
                String name = weaponCursor.getString(weaponCursor.getColumnIndex(WeaponTable.COLUMN_NAME));
                String description = weaponCursor.getString(weaponCursor.getColumnIndex(WeaponTable.COLUMN_DESCRIPTION));
                double price = weaponCursor.getDouble(weaponCursor.getColumnIndex(WeaponTable.COLUMN_PRICE));
                double rating = weaponCursor.getDouble(weaponCursor.getColumnIndex(WeaponTable.COLUMN_RATING));
                long id = weaponCursor.getLong(weaponCursor.getColumnIndex(WeaponTable.COLUMN_ID));
                int weight = weaponCursor.getInt(weaponCursor.getColumnIndex(WeaponTable.COLUMN_WEIGHT));
                int damage = weaponCursor.getInt(weaponCursor.getColumnIndex(WeaponTable.COLUMN_DAMAGE));
                int capacity = weaponCursor.getInt(weaponCursor.getColumnIndex(WeaponTable.COLUMN_CAPACITY));
                String typeRequired = weaponCursor.getString(weaponCursor.getColumnIndex(WeaponTable.COLUMN_AMMO));

                allWeapons.add(new Weapon(name, description, price, rating, id, weight, 100, damage, capacity, capacity, typeRequired));
                weaponCursor.moveToNext();
            }
        }
        weaponCursor.close();

        return allWeapons;
    }

    public List<Item> getAllMisc() {
        List<Item> allItems = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();
        Cursor miscCursor = db.query(MiscTable.TABLE_NAME, null, null, null, null, null, null, null);

        if (miscCursor.moveToFirst()) {
            while (!miscCursor.isAfterLast()) {
                String name = miscCursor.getString(miscCursor.getColumnIndex(MiscTable.COLUMN_NAME));
                String description = miscCursor.getString(miscCursor.getColumnIndex(MiscTable.COLUMN_DESCRIPTION));
                double price = miscCursor.getDouble(miscCursor.getColumnIndex(MiscTable.COLUMN_PRICE));
                double rating = miscCursor.getDouble(miscCursor.getColumnIndex(MiscTable.COLUMN_RATING));
                long id = miscCursor.getLong(miscCursor.getColumnIndex(MiscTable.COLUMN_ID));
                int weight = miscCursor.getInt(miscCursor.getColumnIndex(MiscTable.COLUMN_WEIGHT));

                allItems.add(new Item(name, description, price, rating, id, weight));
                miscCursor.moveToNext();
            }
        }
        miscCursor.close();

        return allItems;
    }

    public List<Item> getEverythingForSale() {
        List<Item> everythingForSale = new ArrayList<>();

        everythingForSale.addAll(getAllAid());
        everythingForSale.addAll(getAllArmor());
        everythingForSale.addAll(getAllWeapons());
        everythingForSale.addAll(getAllMisc());

        return everythingForSale;
    }
}
