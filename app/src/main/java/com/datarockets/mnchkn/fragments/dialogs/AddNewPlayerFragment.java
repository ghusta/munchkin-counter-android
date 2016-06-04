package com.datarockets.mnchkn.fragments.dialogs;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;

import com.datarockets.mnchkn.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnEditorAction;

public class AddNewPlayerFragment extends BottomSheetDialogFragment {

    private View mAddNewPlayerView;
    @BindView(R.id.et_player_name) EditText etPlayerName;
    @BindView(R.id.btn_add_new_player) Button btnAddNewPlayer;
    private AddNewPlayerDialogInterface mListener;

    public interface AddNewPlayerDialogInterface {
        void onFinishEditDialog(String inputName);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mListener = (AddNewPlayerDialogInterface) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle bundle) {
        mAddNewPlayerView = inflater.inflate(R.layout.fragment_add_player, container);
        ButterKnife.bind(this, mAddNewPlayerView);
        return mAddNewPlayerView;
    }

    @OnClick(R.id.btn_add_new_player)
    void onAddNewPlayerClick() {
        passNameToActivity();
    }

    @OnEditorAction(R.id.et_player_name)
    boolean onEditorAction(int actionId) {
        if (EditorInfo.IME_ACTION_DONE == actionId) {
            passNameToActivity();
            return true;
        }
        return false;
    }

    private void passNameToActivity() {
        String name = etPlayerName.getText().toString();
        if (!name.isEmpty()) {
            mListener.onFinishEditDialog(name);
            dismiss();
        }
    }

}
