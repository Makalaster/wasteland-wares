package com.makalaster.wastelandwares.cart.cartRecycler;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.makalaster.wastelandwares.R;
import com.makalaster.wastelandwares.data.Aid;
import com.makalaster.wastelandwares.data.Armor;
import com.makalaster.wastelandwares.data.Cart;
import com.makalaster.wastelandwares.data.Item;
import com.makalaster.wastelandwares.data.ItemId;
import com.makalaster.wastelandwares.data.WastelandWaresDatabase;
import com.makalaster.wastelandwares.data.Weapon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Makalaster on 4/12/17.
 */

public class CartRecyclerAdapter extends RecyclerView.Adapter<CartItemHolder> implements OnItemRemove{
    private HashMap<ItemId, Integer> mCartMap;
    private List<ItemId> mItemList;
    private List<Integer> mQtyList;

    public CartRecyclerAdapter(HashMap<ItemId, Integer> cartMap) {
        mCartMap = cartMap;
        mItemList = new ArrayList<>();
        mItemList.addAll(cartMap.keySet());
        mQtyList = new ArrayList<>();
        mQtyList.addAll(cartMap.values());
    }

    @Override
    public CartItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_cart_item, parent, false);
        return new CartItemHolder(view);
    }

    @Override
    public void onBindViewHolder(final CartItemHolder holder, int position) {
        WastelandWaresDatabase database = WastelandWaresDatabase.getInstance(null);
        final Cart cart = Cart.getInstance();
        final ItemId currentItemId = mItemList.get(position);
        int currentQty = mQtyList.get(position);

        holder.mItemQty.setText(String.valueOf(mQtyList.get(position)));
        switch (currentItemId.getItemType()) {
            case "Aid":
                Aid currentAid = database.getAidById(currentItemId.getItemId());
                holder.mItemTotal.setText(currentQty * currentAid.getPrice() + " caps");
                holder.mItemName.setText(currentAid.getName());
                break;
            case "Armor":
                Armor currentArmor = database.getArmorById(currentItemId.getItemId());
                holder.mItemTotal.setText(currentQty * currentArmor.getPrice() + " caps");
                holder.mItemName.setText(currentArmor.getName());
                break;
            case "Weapon":
                Weapon currentWeapon = database.getWeaponById(currentItemId.getItemId());
                holder.mItemTotal.setText(currentQty * currentWeapon.getPrice() + " caps");
                holder.mItemName.setText(currentWeapon.getName());
                break;
            default:
                Item currentItem = database.getItemById(currentItemId.getItemId());
                holder.mItemTotal.setText(currentQty * currentItem.getPrice() + " caps");
                holder.mItemName.setText(currentItem.getName());
        }

        holder.mDecrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentQty = mQtyList.get(holder.getAdapterPosition());
                if (currentQty <= 1) {
                    cart.removeItemFromCart(currentItemId);
                    mQtyList.remove(holder.getAdapterPosition());
                    mItemList.remove(holder.getAdapterPosition());
                    notifyItemRemoved(holder.getAdapterPosition());
                } else {
                    mQtyList.set(holder.getAdapterPosition(), mQtyList.get(holder.getAdapterPosition()) - 1);
                    cart.decrementItemCount(currentItemId);
                    notifyItemChanged(holder.getAdapterPosition());
                }
            }
        });

        holder.mIncrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mQtyList.set(holder.getAdapterPosition(), mQtyList.get(holder.getAdapterPosition()) + 1);
                notifyItemChanged(holder.getAdapterPosition());
                cart.incrementItemCount(currentItemId);
            }
        });
    }



    @Override
    public int getItemCount() {
        return mItemList.size();
    }

    @Override
    public void onItemRemove(int position) {
        Cart cart = Cart.getInstance();
        cart.removeItemFromCart(mItemList.get(position));

        mItemList.remove(position);
        notifyItemRemoved(position);
    }
}
