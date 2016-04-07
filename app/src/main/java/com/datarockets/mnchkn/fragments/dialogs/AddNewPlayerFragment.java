package com.datarockets.mnchkn.fragments.dialogs;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.datarockets.mnchkn.R;

public class AddNewPlayerFragment extends BottomSheetDialogFragment implements TextView.OnEditorActionListener {

    private View addNewPlayerView;
    private EditText etPlayerName;
    private Button btnAddNewPlayer;
    private AddNewPlayerDialogInterface listener;

    public interface AddNewPlayerDialogInterface {
        void onFinishEditDialog(String inputName);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        listener = (AddNewPlayerDialogInterface) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        addNewPlayerView = inflater.inflate(R.layout.fragment_add_player, container);
        etPlayerName = (EditText) addNewPlayerView.findViewById(R.id.et_player_name);
        etPlayerName.setOnEditorActionListener(this);
        btnAddNewPlayer = (Button) addNewPlayerView.findViewById(R.id.btn_add_new_player);
        btnAddNewPlayer.setOnClickListener(v -> passNameToActivity());
        return addNewPlayerView;
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (EditorInfo.IME_ACTION_DONE == actionId) {
            passNameToActivity();
            return true;
        }
        return false;
    }

    private void passNameToActivity() {
        String name = etPlayerName.getText().toString();
        if (!name.isEmpty()) {
            listener.onFinishEditDialog(name);
            dismiss();
        }
    }

}
