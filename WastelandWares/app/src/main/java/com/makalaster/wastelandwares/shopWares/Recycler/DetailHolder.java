package com.makalaster.wastelandwares.shopWares.Recycler;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.makalaster.wastelandwares.R;

/**
 * Created by Makalaster on 4/10/17.
 */

public class DetailHolder extends RecyclerView.ViewHolder {
    public ImageView mThumbnail;
    public TextView mValue, mAttribute, mAttributeValue;

    public DetailHolder(View itemView) {
        super(itemView);

        mThumbnail = (ImageView) itemView.findViewById(R.id.thumbnail);
        mValue = (TextView) itemView.findViewById(R.id.value_textview);
        mAttribute = (TextView) itemView.findViewById(R.id.second_label);
        mAttributeValue = (TextView) itemView.findViewById(R.id.second_attribute);
    }
}
