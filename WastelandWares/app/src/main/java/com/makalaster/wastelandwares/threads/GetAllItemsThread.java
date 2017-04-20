package com.makalaster.wastelandwares.threads;

import android.content.ContentValues;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;

import com.makalaster.wastelandwares.data.Item;
import com.makalaster.wastelandwares.data.WastelandWaresDatabase;
import com.makalaster.wastelandwares.shopWares.shoppingRecycler.WaresRecyclerAdapter;

import java.util.List;

/**
 * Created by Makalaster on 4/19/17.
 */

public class GetAllItemsThread extends AsyncTask<Void, Void, List<Item>> {
    private RecyclerView mRecyclerView;
    private WaresRecyclerAdapter mWaresRecyclerAdapter;
    private WaresRecyclerAdapter.OnItemSelectedListener mListener;
    private Context mContext;

    public GetAllItemsThread(RecyclerView recyclerView,
                             WaresRecyclerAdapter waresRecyclerAdapter,
                             WaresRecyclerAdapter.OnItemSelectedListener listener,
                             Context context) {
        mRecyclerView = recyclerView;
        mWaresRecyclerAdapter = waresRecyclerAdapter;
        mListener = listener;
        mContext = context;
    }

    @Override
    protected List<Item> doInBackground(Void... params) {
        WastelandWaresDatabase db = WastelandWaresDatabase.getInstance(mContext);

        return db.getEverythingForSale();
    }

    @Override
    protected void onPostExecute(List<Item> list) {
        super.onPostExecute(list);

        mWaresRecyclerAdapter = new WaresRecyclerAdapter(list, mListener);
        mRecyclerView.setAdapter(mWaresRecyclerAdapter);
    }
}
