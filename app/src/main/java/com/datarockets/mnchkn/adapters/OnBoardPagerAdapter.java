package com.datarockets.mnchkn.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.datarockets.mnchkn.fragments.OnBoardFragment;

public class OnBoardPagerAdapter extends FragmentPagerAdapter {

    public OnBoardPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return OnBoardFragment.newInstance(position + 1);
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Section 1";
            case 1:
                return "Section 2";
            case 2:
                return "Section 3";
        }
        return null;
    }
}
