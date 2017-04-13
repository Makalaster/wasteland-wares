package com.makalaster.wastelandwares.detail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.makalaster.wastelandwares.R;
import com.makalaster.wastelandwares.data.Cart;
import com.makalaster.wastelandwares.data.ItemId;
import com.makalaster.wastelandwares.data.WastelandWaresDatabase;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetailHolderFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailHolderFragment extends Fragment {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_ITEM_ID = "itemId";
    private static final String ARG_ITEM_TYPE = "itemType";

    private long mItemId;
    private String mItemType;

    public DetailHolderFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param itemId Parameter 1.
     * @param itemType Parameter 2.
     * @return A new instance of fragment DetailHolderFragment.
     */
    public static DetailHolderFragment newInstance(long itemId, String itemType) {
        DetailHolderFragment fragment = new DetailHolderFragment();
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
        setRetainInstance(false);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_holder, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        setTitle(view);

        DetailFragment detailFragment = DetailFragment.newInstance(mItemId, mItemType);
        getActivity().getSupportFragmentManager().beginTransaction().
                replace(R.id.content_detail, detailFragment).commit();

        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cart cart = Cart.getInstance();
                cart.addItemToCart(new ItemId(mItemId, mItemType));

                Snackbar.make(v, "Item added to cart", Snackbar.LENGTH_SHORT).show();
            }
        });
    }

    public void setTitle(View view) {
        WastelandWaresDatabase db = WastelandWaresDatabase.getInstance(view.getContext());
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        String title;

        switch (mItemType) {
            case "Aid":
                title = db.getAidById(mItemId).getName();
                break;
            case "Armor":
                title = db.getArmorById(mItemId).getName();
                break;
            case "Weapon":
                title = db.getWeaponById(mItemId).getName();
                break;
            default:
                title = db.getItemById(mItemId).getName();
        }

        toolbar.setTitle(title);
    }
}
