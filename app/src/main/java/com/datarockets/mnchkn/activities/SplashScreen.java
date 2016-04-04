package com.datarockets.mnchkn.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.datarockets.mnchkn.R;
import com.datarockets.mnchkn.activities.onboard.OnBoardActivity;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Intent intent = new Intent(this, OnBoardActivity.class);
        startActivity(intent);
        finish();
    }
}
