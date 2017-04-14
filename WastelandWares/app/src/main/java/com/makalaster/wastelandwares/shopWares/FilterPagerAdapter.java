package com.makalaster.wastelandwares.shopWares;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

/**
 * Adapter to handle the behavior of the ViewPager
 */

public class FilterPagerAdapter extends FragmentPagerAdapter {
    private ShoppingFragment[] mFragmentList;

    public FilterPagerAdapter(FragmentManager fm) {
        super(fm);
        mFragmentList = new ShoppingFragment[5];
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return ShoppingFragment.newInstance(0);
            case 1:
                return ShoppingFragment.newInstance(1);
            case 2:
                return ShoppingFragment.newInstance(2);
            case 3:
                return ShoppingFragment.newInstance(3);
            case 4:
                return ShoppingFragment.newInstance(4);
            default:
                return null;
        }
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

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ShoppingFragment createdFragment = (ShoppingFragment) super.instantiateItem(container, position);
        mFragmentList[position] = createdFragment;
        return createdFragment;
    }

    /**
     * Get the fragment that is currently showing in the ViewPager
     * @param position the position of the ViewPager
     * @return the currently showing fragment
     */
    public ShoppingFragment getFragmentAtPosition(int position) {
        return mFragmentList[position];
    }
}
