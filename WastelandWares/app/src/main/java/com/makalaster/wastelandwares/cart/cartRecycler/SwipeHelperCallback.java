package com.makalaster.wastelandwares.cart.cartRecycler;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

/**
 * Callback class to handle what happens when an item is swiped
 * Moving an item by dragging up and down is disabled
 */

public class SwipeHelperCallback extends ItemTouchHelper.Callback {
    private OnItemRemove mRecyclerAdapter;

    public SwipeHelperCallback(OnItemRemove recyclerAdapter) {
        mRecyclerAdapter = recyclerAdapter;
    }

    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
        int swipeFlags = ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;

        return makeMovementFlags(dragFlags, swipeFlags);
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        return false;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        mRecyclerAdapter.onItemRemove(viewHolder.getAdapterPosition());
    }

    @Override
    public boolean isItemViewSwipeEnabled() {
        return true;
    }
}
