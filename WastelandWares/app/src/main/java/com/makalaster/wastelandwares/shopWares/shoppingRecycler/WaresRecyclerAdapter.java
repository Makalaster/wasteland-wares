package com.makalaster.wastelandwares.shopWares.shoppingRecycler;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.makalaster.wastelandwares.R;
import com.makalaster.wastelandwares.data.Aid;
import com.makalaster.wastelandwares.data.Armor;
import com.makalaster.wastelandwares.data.Item;
import com.makalaster.wastelandwares.data.Weapon;

import java.util.List;

/**
 * Adapter for the recycler view that displays lists of items for sale
 */

public class WaresRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Item> mItemList;
    private OnItemSelectedListener mListener;
    private final static int ITEM = 0, AID = 1, WEAPON = 2, ARMOR = 3;

    public WaresRecyclerAdapter(List<Item> itemList, OnItemSelectedListener listener) {
        mItemList = itemList;
        mListener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;

        switch (viewType) {
            case ITEM:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_misc, parent, false);
                return new MiscHolder(view);
            default:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_weap_arm_aid, parent, false);
                return new DetailHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case AID:
                Aid currentAid = (Aid) mItemList.get(position);
                DetailHolder aidHolder = (DetailHolder) holder;

                aidHolder.mItemName.setText(currentAid.getName());
                aidHolder.mValue.setText(String.valueOf(currentAid.getPrice()));
                aidHolder.mAttribute.setText(R.string.hp_label);
                aidHolder.mAttributeValue.setText(String.valueOf(currentAid.getHp()));

                setOnItemSelectedListener(aidHolder, currentAid);
                break;
            case WEAPON:
                Weapon currentWeapon = (Weapon) mItemList.get(position);
                DetailHolder weaponHolder = (DetailHolder) holder;

                weaponHolder.mItemName.setText(currentWeapon.getName());
                weaponHolder.mValue.setText(String.valueOf(currentWeapon.getPrice()));
                weaponHolder.mAttribute.setText(R.string.damage_label);
                weaponHolder.mAttributeValue.setText(String.valueOf(currentWeapon.getDamage()));

                setOnItemSelectedListener(weaponHolder, currentWeapon);
                break;
            case ARMOR:
                Armor currentArmor = (Armor) mItemList.get(position);
                DetailHolder armorHolder = (DetailHolder) holder;

                armorHolder.mItemName.setText(currentArmor.getName());
                armorHolder.mValue.setText(String.valueOf(currentArmor.getPrice()));
                armorHolder.mAttribute.setText(R.string.defense_label);
                armorHolder.mAttributeValue.setText(String.valueOf(currentArmor.getDefense()));

                setOnItemSelectedListener(armorHolder, currentArmor);
                break;
            case ITEM:
                Item currentItem = mItemList.get(position);
                MiscHolder miscHolder = (MiscHolder) holder;

                miscHolder.mItemName.setText(currentItem.getName());
                miscHolder.mValue.setText(String.valueOf(currentItem.getPrice()));

                setOnItemSelectedListener(miscHolder, currentItem);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mItemList.size();
    }

    @Override
    public int getItemViewType(int position) {
        switch (mItemList.get(position).getClass().getSimpleName()) {
            case "Armor":
                return ARMOR;
            case "Weapon":
                return WEAPON;
            case "Aid":
                return AID;
            default:
                return ITEM;
        }
    }

    /**
     * Set the listener for the ViewHolder of type DetailHolder
     * @param detailHolder the slightly more complex ViewHolder
     * @param item the item clicked
     */
    public void setOnItemSelectedListener(DetailHolder detailHolder, Item item) {
        final long id = item.getId();
        final String type = item.getClass().getSimpleName();

        detailHolder.mTarget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onItemSelected(id, type);
            }
        });
    }

    /**
     * Set the listener for the ViewHolder of type MiscHolder
     * @param miscHolder the slightly simpler ViewHolder
     * @param item the item clicked
     */
    public void setOnItemSelectedListener(MiscHolder miscHolder, Item item) {
        final long id = item.getId();
        final String type = item.getClass().getSimpleName();

        miscHolder.mTarget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onItemSelected(id, type);
            }
        });
    }

    /**
     * Replace the contents of the recycler view and notify that the data has changed
     * @param newList the new contents of the recycler
     */
    public void replaceData(List<Item> newList) {
        mItemList = newList;
        notifyDataSetChanged();
    }

    /**
     * Interface to handle selecting an item in the recycler view
     */
    public interface OnItemSelectedListener {
        void onItemSelected(long itemId, String type);
    }
}
