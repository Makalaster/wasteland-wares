package com.makalaster.wastelandwares.detail;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.makalaster.wastelandwares.R;
import com.makalaster.wastelandwares.data.Cart;
import com.makalaster.wastelandwares.data.ItemId;
import com.makalaster.wastelandwares.data.WastelandWaresDatabase;
import com.makalaster.wastelandwares.threads.GetByIDThread;

/**
 * The activity that displays details for the currently selected item
 * The details are displayed in a fragment
 */

public class DetailActivity extends AppCompatActivity {
    public static final String ITEM_ID_KEY = "itemIdKey";
    public static final String ITEM_TYPE = "itemType";

    private long mSelectedItemId;
    private String mSelectedItemType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mSelectedItemId = getIntent().getLongExtra(ITEM_ID_KEY, -1);
        mSelectedItemType = getIntent().getStringExtra(ITEM_TYPE);

        if (mSelectedItemId == -1) {
            Log.d("DetailActivity", "onCreate: no ID passed!");
            finish();
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        DetailFragment detailFragment = DetailFragment.newInstance(mSelectedItemId, mSelectedItemType);
        transaction.add(R.id.detail_fragment_container, detailFragment).commit();

        //Set the floating action button to add the current item to the cart
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cart cart = Cart.getInstance();
                cart.addItemToCart(new ItemId(mSelectedItemId, mSelectedItemType));

                Snackbar.make(view, "Item added to cart", Snackbar.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        setActivityTitle(new ItemId(mSelectedItemId, mSelectedItemType));
    }

    /**
     * Set the title of the activity based on the current selected item
     * @param itemId the id of the selected item
     */
    public void setActivityTitle(ItemId itemId) {
        ActionBar actionBar;

        if (getSupportActionBar() != null) {
            actionBar = getSupportActionBar();
        } else {
            actionBar = null;
        }

        GetByIDThread thread = new GetByIDThread(actionBar);
        thread.execute(itemId);

    }
}
