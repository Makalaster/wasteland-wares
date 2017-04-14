package com.makalaster.wastelandwares.shopWares;

import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.makalaster.wastelandwares.R;
import com.makalaster.wastelandwares.cart.CartActivity;
import com.makalaster.wastelandwares.cart.CartHolderFragment;
import com.makalaster.wastelandwares.detail.DetailActivity;
import com.makalaster.wastelandwares.detail.DetailHolderFragment;
import com.makalaster.wastelandwares.setup.DBAssetHelper;
import com.makalaster.wastelandwares.shopWares.shoppingRecycler.WaresRecyclerAdapter;

/**
 * The main activity in the application
 */

public class MainActivity extends AppCompatActivity implements
        WaresRecyclerAdapter.OnItemSelectedListener {

    private ViewPager mPager;
    private FilterPagerAdapter mPagerAdapter;
    private boolean mTwoPane;
    private DetailHolderFragment mDetailHolderFragment;
    private CartHolderFragment mCartHolderFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DBAssetHelper dbSetup = new DBAssetHelper(MainActivity.this);
        dbSetup.getReadableDatabase();

        //Determine whether the app is currently displaying a single pane or two panes
        mTwoPane = (findViewById(R.id.secondary_fragment_holder) != null);

        mPager = (ViewPager) findViewById(R.id.pager);
        mPagerAdapter = new FilterPagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(mPager);

        /*
            Set the floating action button to open the cart
            If in two pane mode, display the cart in a fragment
            Otherwise, open a new activity
         */
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mTwoPane) {
                    mCartHolderFragment = CartHolderFragment.newInstance();
                    getSupportFragmentManager().beginTransaction().
                            replace(R.id.secondary_fragment_holder, mCartHolderFragment).commit();
                } else {
                    startActivity(new Intent(MainActivity.this, CartActivity.class));
                }
            }
        });
    }

    @Override
    protected void onNewIntent(Intent intent) {
        setIntent(intent);
        handleIntent(intent);
    }

    /**
     * Handle the search intent to display search results in the currently displayed fragment
     * @param intent the search intent
     */
    public void handleIntent(Intent intent) {
        if(Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            (mPagerAdapter.getFragmentAtPosition(mPager.getCurrentItem())).search(query);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        ComponentName componentName = new ComponentName(this, MainActivity.class);

        searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName));

        MenuItem searchItem = menu.findItem(R.id.search);
        MenuItemCompat.setOnActionExpandListener(searchItem, new MenuItemCompat.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionExpand(MenuItem item) {
                return true;
            }

            @Override
            public boolean onMenuItemActionCollapse(MenuItem item) {
                (mPagerAdapter.getFragmentAtPosition(mPager.getCurrentItem())).returnFromSearch();
                return true;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Handle selecting an item from the list of items for sale
     * If the activity is in two pane mode, the detail view is displayed in a fragment
     * Otherwise, the detail view is displayed in a separate activity
     * @param itemId The ID of the selected item
     * @param type The type of the selected item
     */
    @Override
    public void onItemSelected(long itemId, String type) {
        if (mTwoPane) {
            mDetailHolderFragment = DetailHolderFragment.newInstance(itemId, type);
            getSupportFragmentManager().beginTransaction().
                    replace(R.id.secondary_fragment_holder, mDetailHolderFragment).commit();
        } else {
            Intent intent = new Intent(MainActivity.this, DetailActivity.class);
            intent.putExtra(DetailActivity.ITEM_ID_KEY, itemId);
            intent.putExtra(DetailActivity.ITEM_TYPE, type);

            startActivity(intent);
        }
    }
}
