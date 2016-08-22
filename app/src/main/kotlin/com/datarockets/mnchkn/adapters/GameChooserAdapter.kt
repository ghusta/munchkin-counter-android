package com.datarockets.mnchkn.adapters


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.datarockets.mnchkn.R
import java.util.*

class GameChooserAdapter(context: Context) : BaseAdapter() {

    private val mGames = ArrayList<String>()
    private val mInflater: LayoutInflater

    init {
        mInflater = LayoutInflater.from(context)
        mGames.add("punchkin")
    }

    override fun getCount(): Int {
        return mGames.size
    }

    override fun getItem(position: Int): Any {
        return mGames[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        val textView: TextView
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.choose_game_item, parent, false)
        }
        textView = convertView!!.findViewById(R.id.tv_game_title) as TextView
        textView.text = "Munchkin"
        return convertView
    }

}
