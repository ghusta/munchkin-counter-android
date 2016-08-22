package com.datarockets.mnchkn.adapters

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

import com.datarockets.mnchkn.R
import com.datarockets.mnchkn.fragments.charts.ChartsFragment

class ChartsPagerAdapter(fm: FragmentManager, private val mContext: Context) : FragmentStatePagerAdapter(fm) {

    private val mTitles = intArrayOf(R.string.tab_level, R.string.tab_strength, R.string.tab_summary)

    override fun getItem(position: Int): Fragment {
        return ChartsFragment.newInstance(position)
    }

    override fun getCount(): Int {
        return mTitles.size
    }

    override fun getPageTitle(position: Int): CharSequence {
        return mContext.resources.getString(mTitles[position])
    }
}
