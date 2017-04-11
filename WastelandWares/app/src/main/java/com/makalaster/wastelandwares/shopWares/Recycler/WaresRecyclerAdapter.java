package com.makalaster.wastelandwares.shopWares.Recycler;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.makalaster.wastelandwares.R;
import com.makalaster.wastelandwares.data.Aid;
import com.makalaster.wastelandwares.data.Armor;
import com.makalaster.wastelandwares.data.Item;
import com.makalaster.wastelandwares.data.Weapon;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Makalaster on 4/10/17.
 */

public class WaresRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Item> mItemList;
    private final static int ITEM = 0, AID = 1, WEAPON = 2, ARMOR = 3;

    public WaresRecyclerAdapter(List<Item> itemList) {
        mItemList = itemList;
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
                break;
            case WEAPON:
                Weapon currentWeapon = (Weapon) mItemList.get(position);
                DetailHolder weaponHolder = (DetailHolder) holder;

                weaponHolder.mItemName.setText(currentWeapon.getName());
                weaponHolder.mValue.setText(String.valueOf(currentWeapon.getPrice()));
                weaponHolder.mAttribute.setText(R.string.damage_label);
                weaponHolder.mAttributeValue.setText(String.valueOf(currentWeapon.getDamage()));
                break;
            case ARMOR:
                Armor currentArmor = (Armor) mItemList.get(position);
                DetailHolder armorHolder = (DetailHolder) holder;

                armorHolder.mItemName.setText(currentArmor.getName());
                armorHolder.mValue.setText(String.valueOf(currentArmor.getPrice()));
                armorHolder.mAttribute.setText(R.string.defense_label);
                armorHolder.mAttributeValue.setText(String.valueOf(currentArmor.getDefense()));
                break;
            case ITEM:
                Item currentItem = mItemList.get(position);
                MiscHolder miscHolder = (MiscHolder) holder;

                miscHolder.mItemName.setText(currentItem.getName());
                miscHolder.mValue.setText(String.valueOf(currentItem.getPrice()));
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mItemList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (mItemList.get(position) instanceof Armor) {
            return ARMOR;
        } else if (mItemList.get(position) instanceof Weapon) {
            return WEAPON;
        } else if (mItemList.get(position) instanceof Aid) {
            return AID;
        } else {
            return ITEM;
        }
    }
}
