package com.datarockets.mnchkn.activities.result;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.datarockets.mnchkn.R;
import com.datarockets.mnchkn.adapters.ChartsPagerAdapter;

import lecho.lib.hellocharts.model.LineChartData;

public class GameResultActivity extends AppCompatActivity implements GameResultView {

    GameResultPresenter presenter;
    Toolbar toolbar;
    ViewPager vpCharts;
    TabLayout tlChartsTitle;
    ChartsPagerAdapter vpChartsAdapter;
    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new GameResultPresenterImpl(this, this);
        setContentView(R.layout.activity_game_result);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        vpCharts = (ViewPager) findViewById(R.id.vp_charts);
        vpChartsAdapter = new ChartsPagerAdapter(getSupportFragmentManager(), this);
        vpCharts.setOffscreenPageLimit(3);
        vpCharts.setAdapter(vpChartsAdapter);
        tlChartsTitle = (TabLayout) findViewById(R.id.tl_charts_title);
        tlChartsTitle.setupWithViewPager(vpCharts);
        presenter.onCreate();
    }


    @Override
    public void showProgressBar() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle(R.string.progress_dialog_stats_loader_title);
        progressDialog.setMessage(getResources().getString(R.string.progress_dialog_stats_loader_message));
        progressDialog.setCancelable(false);
        progressDialog.show();
    }



    @Override
    public void hideProgressBar() {
        progressDialog.hide();
    }

    @Override
    public void sendLevelScoresChartData(LineChartData levelScoresChartData) {

    }

    @Override
    public void sendStrengthScoresChartData(LineChartData strengthScoresChartData) {

    }

    @Override
    public void sendSummaryScoresChartData(LineChartData summaryScoresChartData) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

}
