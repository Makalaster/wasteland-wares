package com.makalaster.wastelandwares.cart;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import com.makalaster.wastelandwares.R;
import com.makalaster.wastelandwares.cart.cartRecycler.CartRecyclerAdapter;
import com.makalaster.wastelandwares.cart.cartRecycler.SwipeHelperCallback;
import com.makalaster.wastelandwares.data.Cart;

public class CartActivity extends AppCompatActivity {
    Cart mCart;
    CartRecyclerAdapter mAdapter;
    RecyclerView mCartRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mCart = Cart.getInstance();

        mCartRecycler = (RecyclerView) findViewById(R.id.cart_recycler);
        mCartRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(CartActivity.this);
                builder.setTitle("Checkout Confirmation")
                        .setMessage("Are you sure you're ready to check out? Your total is " + mCart.getTotal())
                        .setNegativeButton("Cancel", null)
                        .setPositiveButton("Check out", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                mCart.clearCart();
                                onResume();
                            }
                        })
                        .create().show();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        mAdapter = new CartRecyclerAdapter(mCart.getContents());
        mCartRecycler.setAdapter(mAdapter);

        ItemTouchHelper.Callback callback = new SwipeHelperCallback(mAdapter);
        ItemTouchHelper touchHelper = new ItemTouchHelper(callback);
        touchHelper.attachToRecyclerView(mCartRecycler);
    }
}
