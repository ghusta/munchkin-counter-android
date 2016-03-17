package com.datarockets.mnchkn.activities.dashboard;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;

import com.datarockets.mnchkn.R;
import com.datarockets.mnchkn.fragments.dice.DiceFragment;

public class DashboardViewPagerAdapter extends FragmentPagerAdapter {
    private static int PAGES = 4;
    private String RESOURCES_TEXTS[] = {
            "counter",
            "dice",
            "kill-o-meter",
            "title 4"
    };

    private int[] imageResId = {
            R.drawable.ic_casino_black_24px,
            R.drawable.ic_casino_black_24px,
            R.drawable.ic_casino_black_24px,
            R.drawable.ic_casino_black_24px
    };

    private Context context;

    public DashboardViewPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new DiceFragment();
            case 1:
                fragment = new DiceFragment();
            case 2:
                fragment = new DiceFragment();
            case 3:
                fragment = new DiceFragment();
            default:
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return PAGES;
    }

}
