package com.datarockets.mnchkn.activities.dashboard;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.TextView;

import com.datarockets.mnchkn.R;

public class DashboardActivity extends AppCompatActivity implements DashboardView {

    DashboardPresenter presenter;
    Toolbar toolbar;
    FloatingActionButton fabButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setupToolbar();
        fabButton = (FloatingActionButton) findViewById(R.id.fab_button);
        presenter = new DashboardPresenterImpl(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.drawer, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void setupToolbar() {
        setSupportActionBar(toolbar);
    }

    @Override
    public void setupTabIcons() {
    }

}
