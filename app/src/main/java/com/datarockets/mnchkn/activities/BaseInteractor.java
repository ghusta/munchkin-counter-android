package com.datarockets.mnchkn.activities;

import android.content.Context;

public abstract class BaseInteractor {

    public BaseInteractor(Context context) {
        setUpComponent(context);
    }

    protected abstract void setUpComponent(Context context);

}
