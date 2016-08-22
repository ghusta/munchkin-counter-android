package com.datarockets.mnchkn.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.datarockets.mnchkn.R
import com.datarockets.mnchkn.models.Player

class PlayerListAdapter(internal var context: Context, internal var players: List<Player>) : ArrayAdapter<Player>(context, 0, players) {

    override fun getItem(position: Int): Player {
        return players[position]
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        val holder: ViewHolder
        val player = players[position]

        if (convertView != null) {
            holder = convertView.tag as ViewHolder
        } else {
            convertView = LayoutInflater.from(context).inflate(R.layout.player_list_item, parent, false)
            holder = ViewHolder(convertView)
            convertView!!.tag = holder
        }

        holder.tvPlayerName.text = player.name
        holder.tvPlayerLevelScore.text = player.levelScore.toString()
        holder.tvPlayerStrengthScore.text = player.strengthScore.toString()
        return convertView
    }

    internal class ViewHolder(view: View) {
        @BindView(R.id.tv_player_item_name) lateinit var tvPlayerName: TextView
        @BindView(R.id.tv_player_item_level_score) lateinit var tvPlayerLevelScore: TextView
        @BindView(R.id.tv_player_item_strength_score) lateinit var tvPlayerStrengthScore: TextView

        init {
            ButterKnife.bind(this, view)
        }

    }

}
