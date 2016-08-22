package com.datarockets.mnchkn.activities

import android.content.Context

abstract class BaseInteractor(context: Context) {

    init {
        setUpComponent(context)
    }

    protected abstract fun setUpComponent(context: Context)

}
