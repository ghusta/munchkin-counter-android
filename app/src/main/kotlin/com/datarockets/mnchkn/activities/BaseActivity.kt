package com.datarockets.mnchkn.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log

import com.datarockets.mnchkn.MunchkinApplication
import com.datarockets.mnchkn.di.AppComponent
import com.datarockets.mnchkn.utils.LogUtil
import com.mixpanel.android.mpmetrics.MixpanelAPI

import org.json.JSONException
import org.json.JSONObject

abstract class BaseActivity : AppCompatActivity() {

    private lateinit var mApplication: MunchkinApplication
    private lateinit var mMixpanel: MixpanelAPI

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mApplication = application as MunchkinApplication
        mMixpanel = mApplication.mixpanel
        setUpActivityComponent(MunchkinApplication.get(this).appComponent)
    }

    fun trackWithProperties(title: String, propertyName: String, propertyData: String) {
        val props = JSONObject()
        try {
            props.put(propertyName, propertyData)
        } catch (e: JSONException) {
            Log.e(TAG, "Error while trying to send tracked event")
        }

        mMixpanel.track(title, props)
    }

    fun trackWithoutProperties(eventName: String) {
        mMixpanel.track(eventName)
    }

    override fun onDestroy() {
        super.onDestroy()
        mMixpanel.flush()
    }

    protected abstract fun setUpActivityComponent(appComponent: AppComponent)

    companion object {

        private val TAG = LogUtil.makeLogTag(BaseActivity::class)
    }
}
