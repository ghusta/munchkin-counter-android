package com.datarockets.mnchkn.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.datarockets.mnchkn.R;
import com.datarockets.mnchkn.models.Player;

import java.util.ArrayList;

public class PlayerChartListAdapter extends ArrayAdapter<Player> {

    ArrayList<Player> playersList;
    Context context;

    public PlayerChartListAdapter(Context context, ArrayList<Player> playersList) {
        super(context, 0, playersList);
        this.context = context;
        this.playersList = playersList;
    }

    @Override
    public Player getItem(int position) {
        return super.getItem(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Player player = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.player_chart_item, null);
        }
        TextView tvPlayerName = (TextView) convertView.findViewById(R.id.tv_player_name);
        TextView tvPlayerScore = (TextView) convertView.findViewById(R.id.tv_player_score);
        tvPlayerName.setText(player.getName());
        return convertView;
    }


}
