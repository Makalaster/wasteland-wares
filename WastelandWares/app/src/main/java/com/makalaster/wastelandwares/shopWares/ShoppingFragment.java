package com.makalaster.wastelandwares.shopWares;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.makalaster.wastelandwares.R;
import com.makalaster.wastelandwares.data.Item;
import com.makalaster.wastelandwares.data.WastelandWaresDatabase;
import com.makalaster.wastelandwares.shopWares.shoppingRecycler.WaresRecyclerAdapter;

import java.util.List;

/**
 * A fragment that displays a grid list of items for sale
 */
public class ShoppingFragment extends Fragment implements WaresRecyclerAdapter.OnItemSelectedListener {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    public static final String SELECTED_TAB = "selectedTab";

    private int mSelectedTab;
    private WaresRecyclerAdapter mAdapter;

    private WaresRecyclerAdapter.OnItemSelectedListener mListener;

    public ShoppingFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param selectedTab The currently selected tab in the ViewPager.
     * @return A new instance of fragment ShoppingFragment.
     */
    public static ShoppingFragment newInstance(int selectedTab) {
        ShoppingFragment fragment = new ShoppingFragment();
        Bundle args = new Bundle();

        args.putInt(SELECTED_TAB, selectedTab);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mSelectedTab = getArguments().getInt(SELECTED_TAB);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_shopping, container, false);
    }

    /**
     * Filters the contents of the item list based on the current page in the ViewPager
     * @param view the current view
     * @param savedInstanceState the saved instance state
     */
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        WastelandWaresDatabase wastelandWaresDatabase = WastelandWaresDatabase.getInstance(view.getContext());
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new GridLayoutManager(view.getContext(), 2));

        switch (mSelectedTab) {
            case 0:
                List<Item> list = wastelandWaresDatabase.getEverythingForSale();
                mAdapter = new WaresRecyclerAdapter(list, mListener);
                break;
            case 1:
                List<Item> armorList = wastelandWaresDatabase.getAllArmor();
                mAdapter = new WaresRecyclerAdapter(armorList, mListener);
                break;
            case 2:
                List<Item> weaponList = wastelandWaresDatabase.getAllWeapons();
                mAdapter = new WaresRecyclerAdapter(weaponList, mListener);
                break;
            case 3:
                List<Item> aidList = wastelandWaresDatabase.getAllAid();
                mAdapter = new WaresRecyclerAdapter(aidList, mListener);
                break;
            case 4:
                List<Item> miscList = wastelandWaresDatabase.getAllMisc();
                mAdapter = new WaresRecyclerAdapter(miscList, mListener);
                break;
            default:
                mAdapter = new WaresRecyclerAdapter(null, null);
        }

        recyclerView.setAdapter(mAdapter);
    }

    /**
     * Displays search results relevant to the current category of items
     * @param query the search query
     */
    public void search(String query) {
        WastelandWaresDatabase db = WastelandWaresDatabase.getInstance(getContext());

        switch (mSelectedTab) {
            case 0:
                List<Item> searchAllList = db.searchAllByNameOrDescription(query);
                mAdapter.replaceData(searchAllList);
                break;
            case 1:
                List<Item> searchArmorList = db.searchArmorByNameOrDescription(query);
                mAdapter.replaceData(searchArmorList);
                break;
            case 2:
                List<Item> searchWeaponList = db.searchWeaponByNameOrDescription(query);
                mAdapter.replaceData(searchWeaponList);
                break;
            case 3:
                List<Item> searchAidList = db.searchAidByNameOrDescription(query);
                mAdapter.replaceData(searchAidList);
                break;
            case 4:
                List<Item> searchItemList = db.searchItemByNameOrDescription(query);
                mAdapter.replaceData(searchItemList);
                break;
        }
    }

    /**
     * On closing the search view, the default items are displayed on each page
     */
    public void returnFromSearch() {
        WastelandWaresDatabase wastelandWaresDatabase = WastelandWaresDatabase.getInstance(getContext());

        switch (mSelectedTab) {
            case 0:
                List<Item> list = wastelandWaresDatabase.getEverythingForSale();
                mAdapter.replaceData(list);
                break;
            case 1:
                List<Item> armorList = wastelandWaresDatabase.getAllArmor();
                mAdapter.replaceData(armorList);
                break;
            case 2:
                List<Item> weaponList = wastelandWaresDatabase.getAllWeapons();
                mAdapter.replaceData(weaponList);
                break;
            case 3:
                List<Item> aidList = wastelandWaresDatabase.getAllAid();
                mAdapter.replaceData(aidList);
                break;
            case 4:
                List<Item> miscList = wastelandWaresDatabase.getAllMisc();
                mAdapter.replaceData(miscList);
                break;
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        mListener = (WaresRecyclerAdapter.OnItemSelectedListener) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onItemSelected(long itemId, String type) {

    }
}
