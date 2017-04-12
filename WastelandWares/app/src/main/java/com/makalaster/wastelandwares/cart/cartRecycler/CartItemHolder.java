package com.makalaster.wastelandwares.cart.cartRecycler;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.makalaster.wastelandwares.R;

import org.w3c.dom.Text;

/**
 * Created by Makalaster on 4/12/17.
 */

public class CartItemHolder extends RecyclerView.ViewHolder {
    public Button mIncrementButton, mDecrementButton;
    public TextView mItemQty, mItemTotal, mItemName;

    public CartItemHolder(View itemView) {
        super(itemView);

        mIncrementButton = (Button) itemView.findViewById(R.id.increment_button);
        mDecrementButton = (Button) itemView.findViewById(R.id.decrement_button);
        mItemQty = (TextView) itemView.findViewById(R.id.item_quantity);
        mItemTotal = (TextView) itemView.findViewById(R.id.cart_item_total_textview);
        mItemName = (TextView) itemView.findViewById(R.id.item_name);
    }
}
