package com.datarockets.mnchkn.ui.playerslist

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.amulyakhare.textdrawable.TextDrawable
import com.datarockets.mnchkn.R
import com.datarockets.mnchkn.data.model.Player
import com.datarockets.mnchkn.injection.ActivityContext
import com.datarockets.mnchkn.utils.LogUtil
import java.util.*
import javax.inject.Inject

class PlayerEditorListAdapter
@Inject constructor(@ActivityContext private val mContext: Context) : ArrayAdapter<Player>(mContext, 0) {

    private var mPlayersList: MutableList<Player>

    init {
        mPlayersList = mutableListOf<Player>()
    }

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getCount(): Int = mPlayersList.size

    override fun getItem(position: Int): Player? {
        return mPlayersList[position]
    }

    fun setPlayers(playersList: MutableList<Player>) {
        mPlayersList.addAll(playersList)
    }

    fun addPlayer(player: Player) {
        mPlayersList.add(player)
    }

    fun removePlayer(position: Int) {
        mPlayersList.removeAt(position)
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
