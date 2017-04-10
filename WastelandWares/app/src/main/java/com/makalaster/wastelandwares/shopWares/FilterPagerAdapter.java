package com.makalaster.wastelandwares.shopWares;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Makalaster on 4/10/17.
 */

public class FilterPagerAdapter extends FragmentPagerAdapter {
    public FilterPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return null;
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "All";
            case 1:
                return "Armor";
            case 2:
                return "Weapons";
            case 3:
                return "Aid";
            case 4:
                return "Misc";
            default:
                return null;
        }
    }
}
