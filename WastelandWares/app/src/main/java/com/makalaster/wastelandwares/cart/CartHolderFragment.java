package com.makalaster.wastelandwares.cart;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.makalaster.wastelandwares.R;
import com.makalaster.wastelandwares.data.Cart;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CartHolderFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CartHolderFragment extends Fragment {
    private Cart mCart;

    public CartHolderFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment CartHolderFragment.
     */
    public static CartHolderFragment newInstance() {
        CartHolderFragment fragment = new CartHolderFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }

        mCart = Cart.getInstance();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cart_holder, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ((Toolbar)view.findViewById(R.id.toolbar)).setTitle("WaresCart");

        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        final CartFragment cartFragment = CartFragment.newInstance();
        transaction.add(R.id.cart_recycler_holder, cartFragment).commit();

        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setTitle("Checkout Confirmation")
                        .setMessage("Are you sure you're ready to check out? Your total is " + mCart.getTotal())
                        .setNegativeButton("Cancel", null)
                        .setPositiveButton("Check out", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                mCart.clearCart();
                                cartFragment.onResume();
                                Snackbar.make(v, "Thank you for your business!", Snackbar.LENGTH_LONG).show();
                            }
                        })
                        .create().show();
            }
        });
    }
}
