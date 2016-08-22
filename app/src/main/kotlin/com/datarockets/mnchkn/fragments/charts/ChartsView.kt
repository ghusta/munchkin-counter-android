package com.datarockets.mnchkn.fragments.charts

import com.datarockets.mnchkn.models.Player

import java.util.ArrayList

interface ChartsView {
    fun showPlayersList(players: ArrayList<Player>)
}
