package com.datarockets.mnchkn.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.datarockets.mnchkn.fragments.ChartsFragment;

public class ChartsPagerAdapter extends FragmentStatePagerAdapter {

    public static final int PAGES_COUNT = 3;
    private String titles[] = new String[] { "Level", "Strength", "Summary" };
    private Context context;

    public ChartsPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        return new ChartsFragment();
    }

    @Override
    public int getCount() {
        return PAGES_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
