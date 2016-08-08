package com.datarockets.mnchkn.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import com.datarockets.mnchkn.MunchkinApplication;
import com.datarockets.mnchkn.di.AppComponent;

public abstract class BaseFragment extends Fragment {


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUpComponent(MunchkinApplication.get(getActivity()).getAppComponent());
    }

    protected abstract void setUpComponent(AppComponent appComponent);

}