package com.makalaster.wastelandwares.shopWares.shoppingRecycler;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.makalaster.wastelandwares.R;

/**
 * Class to hold the views for a base Item object in the recycler view
 */

public class MiscHolder extends RecyclerView.ViewHolder {
    public ImageView mThumbnail;
    public TextView mValue, mItemName;
    public View mTarget;

    public MiscHolder(View itemView) {
        super(itemView);

        mThumbnail = (ImageView) itemView.findViewById(R.id.thumbnail);
        mValue = (TextView) itemView.findViewById(R.id.value_textview);
        mItemName = (TextView) itemView.findViewById(R.id.item_name);
        mTarget = itemView.findViewById(R.id.click_target);
    }
}
