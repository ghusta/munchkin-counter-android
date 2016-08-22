package com.datarockets.mnchkn.fragments.dialogs

import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v7.widget.Toolbar
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.view.Window

import com.datarockets.mnchkn.R

class GameInfoFragment : DialogFragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, bundle: Bundle?): View? {
        val gameInfoView = inflater!!.inflate(R.layout.fragment_game_info, container, false)
        val toolbar = gameInfoView.findViewById(R.id.toolbar) as Toolbar
        toolbar.setOnMenuItemClickListener { false }
        toolbar.inflateMenu(R.menu.drawer)
        toolbar.title = "Dialog info"
        return gameInfoView
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.window!!.requestFeature(Window.FEATURE_NO_TITLE)
        return dialog
    }

}
