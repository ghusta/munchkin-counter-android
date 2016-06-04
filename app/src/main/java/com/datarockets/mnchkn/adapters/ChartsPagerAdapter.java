package com.datarockets.mnchkn.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.datarockets.mnchkn.R;
import com.datarockets.mnchkn.fragments.charts.ChartsFragment;

public class ChartsPagerAdapter extends FragmentStatePagerAdapter {

    private int[] mTitles = new int[] {
            R.string.tab_level,
            R.string.tab_strength,
            R.string.tab_summary
    };

    private Context mContext;

    public ChartsPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        return ChartsFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        return mTitles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(mTitles[position]);
    }
}
