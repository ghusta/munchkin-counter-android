package com.datarockets.mnchkn.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View

import com.datarockets.mnchkn.MunchkinApplication
import com.datarockets.mnchkn.di.AppComponent

abstract class BaseFragment : Fragment() {


    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpComponent(MunchkinApplication.get(activity).appComponent)
    }

    protected abstract fun setUpComponent(appComponent: AppComponent)

}