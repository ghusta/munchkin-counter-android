package com.datarockets.mnchkn.activities.welcome;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class WelcomeActivity extends AppCompatActivity implements WelcomeView, View.OnClickListener  {

    WelcomePresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new WelcomePresenterImpl(this);
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void setNewDialog() {

    }

    @Override
    public void onClick(View view) {
        presenter.validateCredentials("firstName", "lastName");
    }
}
