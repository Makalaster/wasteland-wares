package com.makalaster.wastelandwares.shopWares.shoppingRecycler;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.makalaster.wastelandwares.R;

/**
 * Class to hold the view for an item which is a subclass of Item in the recycler view
 */

public class DetailHolder extends RecyclerView.ViewHolder {
    public ImageView mThumbnail;
    public TextView mValue, mAttribute, mAttributeValue, mItemName;
    public View mTarget;

    public DetailHolder(View itemView) {
        super(itemView);

        mThumbnail = (ImageView) itemView.findViewById(R.id.thumbnail);
        mItemName = (TextView) itemView.findViewById(R.id.item_name);
        mValue = (TextView) itemView.findViewById(R.id.value_textview);
        mAttribute = (TextView) itemView.findViewById(R.id.second_label);
        mAttributeValue = (TextView) itemView.findViewById(R.id.second_attribute);
        mTarget = itemView.findViewById(R.id.click_target);
    }
}
