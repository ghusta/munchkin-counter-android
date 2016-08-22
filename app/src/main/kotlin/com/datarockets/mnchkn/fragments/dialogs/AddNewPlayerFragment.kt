package com.datarockets.mnchkn.fragments.dialogs

import android.content.Context
import android.os.Bundle
import android.support.design.widget.BottomSheetDialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import butterknife.OnEditorAction
import com.datarockets.mnchkn.R

class AddNewPlayerFragment : BottomSheetDialogFragment() {

    private var mAddNewPlayerView: View? = null
    @BindView(R.id.et_player_name) lateinit var etPlayerName: EditText
    @BindView(R.id.btn_add_new_player) lateinit var btnAddNewPlayer: Button
    private lateinit var mListener: AddNewPlayerDialogInterface

    interface AddNewPlayerDialogInterface {
        fun onFinishEditDialog(inputName: String)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        mListener = activity as AddNewPlayerDialogInterface
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, bundle: Bundle?): View? {
        mAddNewPlayerView = inflater!!.inflate(R.layout.fragment_add_player, container)
        ButterKnife.bind(this, mAddNewPlayerView!!)
        return mAddNewPlayerView
    }

    @OnClick(R.id.btn_add_new_player)
    internal fun onAddNewPlayerClick() {
        passNameToActivity()
    }

    @OnEditorAction(R.id.et_player_name)
    internal fun onEditorAction(actionId: Int): Boolean {
        if (EditorInfo.IME_ACTION_DONE == actionId) {
            passNameToActivity()
            return true
        }
        return false
    }

    private fun passNameToActivity() {
        val name = etPlayerName.text.toString()
        if (!name.isEmpty()) {
            mListener.onFinishEditDialog(name)
            dismiss()
        }
    }

}
