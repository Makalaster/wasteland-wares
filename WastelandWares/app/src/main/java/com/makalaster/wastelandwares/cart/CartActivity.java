package com.makalaster.wastelandwares.cart;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.makalaster.wastelandwares.R;
import com.makalaster.wastelandwares.data.Cart;

public class CartActivity extends AppCompatActivity {
    private Cart mCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mCart = Cart.getInstance();

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        final CartFragment cartFragment = CartFragment.newInstance();
        transaction.add(R.id.cart_recycler_holder, cartFragment).commit();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(CartActivity.this);
                builder.setTitle("Checkout Confirmation")
                        .setMessage("Are you sure you're ready to check out? Your total is " + mCart.getTotal())
                        .setNegativeButton("Cancel", null)
                        .setPositiveButton("Check out", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                mCart.clearCart();
                                cartFragment.onResume();
                                Snackbar.make(view, "Thank you for your business!", Snackbar.LENGTH_LONG).show();
                            }
                        })
                        .create().show();
            }
        });
    }
}
