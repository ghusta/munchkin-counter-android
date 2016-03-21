package com.datarockets.mnchkn.fragments.dialogs;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.datarockets.mnchkn.R;

public class DiceRollResultFragment extends DialogFragment implements DialogInterface.OnClickListener{

    View diceRollResultView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        diceRollResultView = inflater.inflate(R.layout.fragment_dice, container, false);
        return diceRollResultView;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {

    }


}
