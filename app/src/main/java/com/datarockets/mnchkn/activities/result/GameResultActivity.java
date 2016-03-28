package com.datarockets.mnchkn.activities.result;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.datarockets.mnchkn.R;
import com.datarockets.mnchkn.adapters.ChartsPagerAdapter;

import lecho.lib.hellocharts.view.LineChartView;

public class GameResultActivity extends AppCompatActivity implements GameResultView {

    Toolbar toolbar;
    ViewPager vpCharts;
    TabLayout tlChartsTitle;
    ChartsPagerAdapter vpChartsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_result);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        vpCharts = (ViewPager) findViewById(R.id.vp_charts);
        vpChartsAdapter = new ChartsPagerAdapter(getSupportFragmentManager(), this);
        vpCharts.setAdapter(vpChartsAdapter);
        tlChartsTitle = (TabLayout) findViewById(R.id.tl_charts_title);
        tlChartsTitle.setupWithViewPager(vpCharts);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
