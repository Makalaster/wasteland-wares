package com.makalaster.wastelandwares.threads;

import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;

import com.makalaster.wastelandwares.data.Item;
import com.makalaster.wastelandwares.data.WastelandWaresDatabase;
import com.makalaster.wastelandwares.shopWares.shoppingRecycler.WaresRecyclerAdapter;

import java.util.List;

/**
 * Created by Makalaster on 4/19/17.
 */

public class GetAllWeaponsThread extends AsyncTask<Void, Void, List<Item>> {
    private RecyclerView mRecyclerView;
    private WaresRecyclerAdapter mWaresRecyclerAdapter;
    private WaresRecyclerAdapter.OnItemSelectedListener mListener;

    public GetAllWeaponsThread(RecyclerView recyclerView, WaresRecyclerAdapter waresRecyclerAdapter, WaresRecyclerAdapter.OnItemSelectedListener listener) {
        mRecyclerView = recyclerView;
        mWaresRecyclerAdapter = waresRecyclerAdapter;
        mListener = listener;
    }

    @Override
    protected List<Item> doInBackground(Void... params) {
        WastelandWaresDatabase db = WastelandWaresDatabase.getInstance(null);

        return db.getAllWeapons();
    }

    @Override
    protected void onPostExecute(List<Item> list) {
        super.onPostExecute(list);

        mWaresRecyclerAdapter = new WaresRecyclerAdapter(list, mListener);
        mRecyclerView.setAdapter(mWaresRecyclerAdapter);
    }
}
