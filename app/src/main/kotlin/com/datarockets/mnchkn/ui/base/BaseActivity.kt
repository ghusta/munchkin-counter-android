package com.datarockets.mnchkn.ui.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.datarockets.mnchkn.MunchkinApplication
import com.datarockets.mnchkn.injection.component.ActivityComponent
import com.datarockets.mnchkn.injection.component.DaggerActivityComponent
import com.datarockets.mnchkn.injection.module.ActivityModule
import com.datarockets.mnchkn.utils.LogUtil
import org.json.JSONException
import org.json.JSONObject

abstract class BaseActivity : AppCompatActivity() {

    var mActivityComponent: ActivityComponent? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun activityComponent() : ActivityComponent {
        if (mActivityComponent == null) {
            mActivityComponent = DaggerActivityComponent.builder()
                .activityModule(ActivityModule(this))
                .applicationComponent(MunchkinApplication.get(this).getComponent())
                .build()
        }
        return mActivityComponent!!
    }

    fun trackWithProperties(title: String, propertyName: String, propertyData: String) {
        val props = JSONObject()
        try {
            props.put(propertyName, propertyData)
        } catch (e: JSONException) {
            Log.e(TAG, "Error while trying to send tracked event")
        }

//        mMixpanel.track(title, props)
    }

    fun trackWithoutProperties(eventName: String) {
//        mMixpanel.track(eventName)
    }

    override fun onDestroy() {
//        mMixpanel.flush()
        super.onDestroy()
    }

    companion object {

        private val TAG = LogUtil.makeLogTag(BaseActivity::class)
    }
}
