package com.makalaster.wastelandwares.cart;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.makalaster.wastelandwares.R;
import com.makalaster.wastelandwares.cart.cartRecycler.CartRecyclerAdapter;
import com.makalaster.wastelandwares.cart.cartRecycler.SwipeHelperCallback;
import com.makalaster.wastelandwares.data.Cart;

/**
 * A fragment used to display the contents of the cart in a RecyclerView
 * This fragment is displayed within the CartActivity on screens smaller than 900dp
 * On wider screens, this fragment is nested within a CartHolderFragment
 */
public class CartFragment extends Fragment {
    private Cart mCart;
    private RecyclerView mCartRecycler;

    public CartFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * @return A new instance of fragment CartFragment.
     */
    public static CartFragment newInstance() {
        CartFragment fragment = new CartFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cart, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        mCart = Cart.getInstance();

        mCartRecycler = (RecyclerView) view.findViewById(R.id.cart_recycler);
        mCartRecycler.setLayoutManager(new LinearLayoutManager(view.getContext(), LinearLayoutManager.VERTICAL, false));
    }

    @Override
    public void onResume() {
        super.onResume();

        CartRecyclerAdapter adapter = new CartRecyclerAdapter(mCart.getContents());
        mCartRecycler.setAdapter(adapter);

        ItemTouchHelper.Callback callback = new SwipeHelperCallback(adapter);
        ItemTouchHelper touchHelper = new ItemTouchHelper(callback);
        touchHelper.attachToRecyclerView(mCartRecycler);
    }
}
