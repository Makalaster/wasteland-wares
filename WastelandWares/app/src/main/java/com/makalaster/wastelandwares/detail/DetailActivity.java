package com.makalaster.wastelandwares.detail;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.makalaster.wastelandwares.R;

public class DetailActivity extends AppCompatActivity implements DetailFragment.OnFragmentInteractionListener {
    public static final String ITEM_ID_KEY = "itemIdKey";
    public static final String ITEM_TYPE = "itemType";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        long selectedItemId = getIntent().getLongExtra(ITEM_ID_KEY, -1);
        String selectedItemType = getIntent().getStringExtra(ITEM_TYPE);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        DetailFragment detailFragment = DetailFragment.newInstance(selectedItemId, selectedItemType);
        transaction.add(R.id.detail_fragment_container, detailFragment).commit();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
