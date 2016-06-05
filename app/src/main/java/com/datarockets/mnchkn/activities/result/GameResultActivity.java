package com.datarockets.mnchkn.activities.result;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.datarockets.mnchkn.R;
import com.datarockets.mnchkn.activities.BaseActivity;
import com.datarockets.mnchkn.activities.players.PlayersListActivity;
import com.datarockets.mnchkn.adapters.ChartsPagerAdapter;
import com.datarockets.mnchkn.di.AppComponent;
import com.datarockets.mnchkn.di.DaggerGameResultComponent;
import com.datarockets.mnchkn.di.GameResultModule;
import com.datarockets.mnchkn.utils.LogUtil;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GameResultActivity extends BaseActivity implements GameResultView {

    public static final String TAG = LogUtil.makeLogTag(GameResultActivity.class);

    @Inject
    GameResultPresenter presenter;
    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.vp_charts) ViewPager vpCharts;
    @BindView(R.id.tl_charts_title) TabLayout tlChartsTitle;
    ChartsPagerAdapter vpChartsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_result);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        presenter.onCreate();
    }

    @Override
    protected void setupComponent(AppComponent appComponent) {
        DaggerGameResultComponent.builder()
                .appComponent(appComponent)
                .gameResultModule(new GameResultModule(this, this))
                .build()
                .inject(this);
    }

    @Override
    public void loadChartFragments() {
        vpChartsAdapter = new ChartsPagerAdapter(getSupportFragmentManager(), this);
        vpCharts.setAdapter(vpChartsAdapter);
        vpCharts.setOffscreenPageLimit(3);
        tlChartsTitle.setupWithViewPager(vpCharts);
    }

    @Override
    protected void onResume() {
        super.onResume();
        trackWithProperties("Current activity", "Activity name", TAG);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        presenter.onBackPressed();
        Intent intent = new Intent(this, PlayersListActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return false;
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.onStop();
    }

}
