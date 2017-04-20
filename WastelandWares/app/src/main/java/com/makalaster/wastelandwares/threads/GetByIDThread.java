package com.makalaster.wastelandwares.threads;

import android.app.ActionBar;
import android.os.AsyncTask;

import com.makalaster.wastelandwares.data.Item;
import com.makalaster.wastelandwares.data.ItemId;
import com.makalaster.wastelandwares.data.WastelandWaresDatabase;

/**
 * Created by Makalaster on 4/19/17.
 */

public class GetByIDThread extends AsyncTask<ItemId, Void, Item> {

    private WastelandWaresDatabase mDb = WastelandWaresDatabase.getInstance(null);
    private android.support.v7.app.ActionBar mActionBar;

    public GetByIDThread(android.support.v7.app.ActionBar actionBar) {
        mActionBar = actionBar;
    }

    @Override
    protected Item doInBackground(ItemId... params) {
        ItemId id = params[0];

        switch (id.getItemType()) {
            case "Armor":
                return mDb.getArmorById(id.getItemId());
            case "Weapon":
                return mDb.getWeaponById(id.getItemId());
            case "Aid":
                return mDb.getAidById(id.getItemId());
            default:
                return mDb.getItemById(id.getItemId());
        }
    }

    @Override
    protected void onPostExecute(Item item) {
        super.onPostExecute(item);

        mActionBar.setTitle(item.getName());
    }
}
