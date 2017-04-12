package com.makalaster.wastelandwares.shopWares;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.makalaster.wastelandwares.R;
import com.makalaster.wastelandwares.data.Item;
import com.makalaster.wastelandwares.data.WastelandWaresDatabase;
import com.makalaster.wastelandwares.shopWares.shoppingRecycler.WaresRecyclerAdapter;

import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ShoppingFragment#newInstance} factory method to
 * create an instance of this fragment.
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
     * @param selectedTab Parameter 1.
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
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (WaresRecyclerAdapter.OnItemSelectedListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onItemSelected(long itemId, String type) {
        //Intent intent = new Intent(getContext(), DetailActivity.class);
        //startActivity(intent);
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        void onFragmentInteracted(View view);
    }
}