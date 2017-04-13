package com.makalaster.wastelandwares.shopWares;

import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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
import com.makalaster.wastelandwares.detail.DetailActivity;
import com.makalaster.wastelandwares.detail.DetailHolderFragment;
import com.makalaster.wastelandwares.setup.DBAssetHelper;
import com.makalaster.wastelandwares.shopWares.shoppingRecycler.WaresRecyclerAdapter;

public class MainActivity extends AppCompatActivity implements
        ShoppingFragment.OnFragmentInteractionListener,
        DetailHolderFragment.OnFragmentInteractionListener,
        WaresRecyclerAdapter.OnItemSelectedListener {

    private ViewPager mPager;
    private FilterPagerAdapter mPagerAdapter;
    private boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DBAssetHelper dbSetup = new DBAssetHelper(MainActivity.this);
        dbSetup.getReadableDatabase();

        if (findViewById(R.id.secondary_fragment_holder) != null) {
            mTwoPane = true;
        } else {
            mTwoPane = false;
        }

        mPager = (ViewPager) findViewById(R.id.pager);
        mPagerAdapter = new FilterPagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(mPager);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mTwoPane) {

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

    @Override
    public void onFragmentInteracted(View view) {

    }

    @Override
    public void onItemSelected(long itemId, String type) {
        if (mTwoPane) {
            DetailHolderFragment detailHolderFragment = DetailHolderFragment.newInstance(itemId, type);
            getSupportFragmentManager().beginTransaction().
                    replace(R.id.secondary_fragment_holder, detailHolderFragment).commit();
        } else {
            Intent intent = new Intent(MainActivity.this, DetailActivity.class);
            intent.putExtra(DetailActivity.ITEM_ID_KEY, itemId);
            intent.putExtra(DetailActivity.ITEM_TYPE, type);

            startActivity(intent);
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
