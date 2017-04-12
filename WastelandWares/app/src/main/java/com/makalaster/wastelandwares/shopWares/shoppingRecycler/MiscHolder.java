package com.makalaster.wastelandwares.shopWares.shoppingRecycler;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.makalaster.wastelandwares.R;

/**
 * Created by Makalaster on 4/10/17.
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
