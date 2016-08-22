package com.datarockets.mnchkn.adapters

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.amulyakhare.textdrawable.TextDrawable
import com.datarockets.mnchkn.R
import com.datarockets.mnchkn.models.Player
import com.datarockets.mnchkn.utils.LogUtil

class PlayerEditorListAdapter(private val mContext: Context, private val mPlayersList: List<Player>) : ArrayAdapter<Player>(mContext, 0, mPlayersList) {

    override fun getItem(position: Int): Player? {
        return mPlayersList[position]
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        val holder: ViewHolder

        val player = mPlayersList[position]
        if (convertView != null) {
            holder = convertView.tag as ViewHolder
        } else {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.player_item, null)
            holder = ViewHolder(convertView)
            convertView!!.tag = holder
        }

        val color = Color.parseColor(player.color)
        val capitalizedPlayerFirstLetter = player.name.substring(0, 1).toUpperCase()
        val drawable = TextDrawable.builder().buildRound(capitalizedPlayerFirstLetter, color)
        holder.ivPlayerImage.setImageDrawable(drawable)
        holder.tvPlayerName.text = player.name
        return convertView
    }

    internal class ViewHolder(view: View) {
        @BindView(R.id.iv_player_color) lateinit var ivPlayerImage: ImageView
        @BindView(R.id.tv_player_name) lateinit var tvPlayerName: TextView

        init {
            ButterKnife.bind(this, view)
        }
    }

    companion object {

        val TAG = LogUtil.makeLogTag(PlayerEditorListAdapter::class)
    }

}
