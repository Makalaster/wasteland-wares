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

/**
 * Activity to display the contents of the shopping cart
 * This activity is only launched on screens narrower than 900dp
 * The content of this activity, a RecyclerView, is dispayed in a fragment
 */
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

        /*
            Set the floating action button to display a dialog
            If the cart is empty, the user is informed that they must first add items to the cart
            If the cart has items in it, a confirmation is displayed with the current total price
         */
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(CartActivity.this);
                builder.setTitle("Checkout Confirmation");

                if(mCart.getContents().isEmpty()) {
                    builder.setMessage("Your cart is empty! Please add items before checking out.")
                            .setPositiveButton("OK", null);
                } else {
                    builder.setPositiveButton("Check out", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            mCart.clearCart();
                            cartFragment.onResume();
                            Snackbar.make(view, "Thank you for your business!", Snackbar.LENGTH_LONG).show();
                        }
                    }).setMessage("Are you sure you're ready to check out? Your total is " + mCart.getTotal())
                            .setNegativeButton("Cancel", null);
                }

                builder.create().show();
            }
        });
    }
}
