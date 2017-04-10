package com.makalaster.wastelandwares.shopWares.Recycler;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.makalaster.wastelandwares.data.Item;

import java.util.List;

/**
 * Created by Makalaster on 4/10/17.
 */

public class WaresRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<Item> mItemList;

    public WaresRecyclerAdapter(List<Item> itemList) {
        mItemList = itemList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mItemList.size();
    }
}
