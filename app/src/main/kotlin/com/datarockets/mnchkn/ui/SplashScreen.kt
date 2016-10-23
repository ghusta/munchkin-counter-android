package com.datarockets.mnchkn.ui

import android.content.Intent
import android.os.Bundle

import com.datarockets.mnchkn.R
import com.datarockets.mnchkn.ui.onboard.OnboardActivity
import com.datarockets.mnchkn.ui.base.BaseActivity
import com.datarockets.mnchkn.utils.LogUtil

class SplashScreen : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
    }

    override fun onResume() {
        super.onResume()
        super.trackWithProperties("Current activity", "Activity name", TAG)
        val intent = Intent(this, OnboardActivity::class.java)
        startActivity(intent)
        finish()
    }

    companion object {

        val TAG = LogUtil.makeLogTag(SplashScreen::class)
    }
}
