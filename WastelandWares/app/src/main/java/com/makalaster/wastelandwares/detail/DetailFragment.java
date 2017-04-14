package com.makalaster.wastelandwares.detail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.makalaster.wastelandwares.R;
import com.makalaster.wastelandwares.data.Aid;
import com.makalaster.wastelandwares.data.Armor;
import com.makalaster.wastelandwares.data.Item;
import com.makalaster.wastelandwares.data.WastelandWaresDatabase;
import com.makalaster.wastelandwares.data.Weapon;

/**
 * A fragment that displays details of the currently selected item
 * This fragment displays inside of the DetailActivity layout when on a screen smaller than 900dp wide
 * It displays inside of a DetailHolderFragment in a Master/Detail flow on wider screens
 */
public class DetailFragment extends Fragment {
    private static final String ARG_ITEM_ID = "param1";
    private static final String ARG_ITEM_TYPE = "param2";

    private long mItemId;
    private String mItemType;
    private WastelandWaresDatabase mWastelandWaresDatabase = WastelandWaresDatabase.getInstance(getContext());

    public DetailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param itemId Parameter 1.
     * @param itemType Parameter 2.
     * @return A new instance of fragment DetailFragment.
     */
    public static DetailFragment newInstance(long itemId, String itemType) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putLong(ARG_ITEM_ID, itemId);
        args.putString(ARG_ITEM_TYPE, itemType);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mItemId = getArguments().getLong(ARG_ITEM_ID);
            mItemType = getArguments().getString(ARG_ITEM_TYPE);
        }
    }

    /**
     * Inflate the appropriate view based on the type of item selected
     * @param inflater a LayoutInflater
     * @param container the root viewgroup
     * @param savedInstanceState a bundle
     * @return an inflated view
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        switch (mItemType) {
            case "Aid":
                return inflater.inflate(R.layout.fragment_aid_detail, container, false);
            case "Weapon":
                return inflater.inflate(R.layout.fragment_weapon_detail, container, false);
            case "Armor":
                return inflater.inflate(R.layout.fragment_armor_detail, container, false);
            default:
                return inflater.inflate(R.layout.fragment_item_detail, container, false);
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        populateView(view);
    }


    /**
     * Populates the detail view based on the type of item currently selected
     * @param view the inflated view
     */
    public void populateView(View view) {
        switch (mItemType) {
            case "Aid":
                Aid openedAid = mWastelandWaresDatabase.getAidById(mItemId);
                ((TextView)view.findViewById(R.id.value_value)).setText(String.valueOf(openedAid.getPrice()));
                ((TextView)view.findViewById(R.id.weight_value)).setText(String.valueOf(openedAid.getWeight()));
                ((TextView)view.findViewById(R.id.hp_value)).setText(String.valueOf(openedAid.getHp()));
                ((TextView)view.findViewById(R.id.radiation_value)).setText(String.valueOf(openedAid.getRads()));
                ((TextView)view.findViewById(R.id.item_description)).setText(openedAid.getDescription());
                break;
            case "Weapon":
                Weapon openedWeapon = mWastelandWaresDatabase.getWeaponById(mItemId);
                ((TextView)view.findViewById(R.id.value_value)).setText(String.valueOf(openedWeapon.getPrice()));
                ((TextView)view.findViewById(R.id.weight_value)).setText(String.valueOf(openedWeapon.getWeight()));
                ((TextView)view.findViewById(R.id.damage_value)).setText(String.valueOf(openedWeapon.getDamage()));
                ((TextView)view.findViewById(R.id.capacity_value)).setText(String.valueOf(openedWeapon.getAmmoCapacity()));
                ((TextView)view.findViewById(R.id.ammo_value)).setText(openedWeapon.getAmmoRequired());
                ((TextView)view.findViewById(R.id.item_description)).setText(openedWeapon.getDescription());
                break;
            case "Armor":
                Armor openedArmor = mWastelandWaresDatabase.getArmorById(mItemId);
                ((TextView)view.findViewById(R.id.value_value)).setText(String.valueOf(openedArmor.getPrice()));
                ((TextView)view.findViewById(R.id.weight_value)).setText(String.valueOf(openedArmor.getWeight()));
                ((TextView)view.findViewById(R.id.defense_value)).setText(String.valueOf(openedArmor.getDefense()));
                ((TextView)view.findViewById(R.id.item_description)).setText(openedArmor.getDescription());
                break;
            default:
                Item openedItem = mWastelandWaresDatabase.getItemById(mItemId);
                ((TextView)view.findViewById(R.id.value_value)).setText(String.valueOf(openedItem.getPrice()));
                ((TextView)view.findViewById(R.id.weight_value)).setText(String.valueOf(openedItem.getWeight()));
                ((TextView)view.findViewById(R.id.item_description)).setText(openedItem.getDescription());
        }
    }
}
