package com.datarockets.mnchkn.ui.charts

import com.datarockets.mnchkn.data.model.Player
import com.datarockets.mnchkn.ui.base.BaseView

import java.util.ArrayList

interface ChartsView : BaseView {
    fun showPlayersList(players: ArrayList<Player>)
}
