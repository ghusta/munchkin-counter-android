package com.datarockets.mnchkn.fragments.dialogs;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.datarockets.mnchkn.R;

public class AddNewPlayerFragment extends DialogFragment implements TextView.OnEditorActionListener {

    private EditText etPlayerName;

    public AddNewPlayerFragment() {}

    public interface AddNewPlayerDialogInterface {
        void onFinishEditDialog(String inputName);
    }

    public static AddNewPlayerFragment newInstance() {
        AddNewPlayerFragment fragment = new AddNewPlayerFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_add_player, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        getDialog().getWindow().setBackgroundDrawableResource(R.drawable.add_player_dialog);
        etPlayerName = (EditText) view.findViewById(R.id.et_player_name);
        etPlayerName.setOnEditorActionListener(this);
        etPlayerName.requestFocus();
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (EditorInfo.IME_ACTION_DONE == actionId) {
            AddNewPlayerDialogInterface listener = (AddNewPlayerDialogInterface) getActivity();
            listener.onFinishEditDialog(etPlayerName.getText().toString());
            dismiss();
            this.dismiss();
            return true;
        }
        return false;

    }


}
