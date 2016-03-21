package com.datarockets.mnchkn.activities.result;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.datarockets.mnchkn.R;

import lecho.lib.hellocharts.view.LineChartView;

public class GameResultActivity extends AppCompatActivity implements GameResultView {

    LineChartView lineChartView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_result);
        lineChartView = (LineChartView) findViewById(R.id.chart);
    }

}
