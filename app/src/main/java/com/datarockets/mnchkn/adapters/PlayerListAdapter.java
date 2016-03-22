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

public class PlayerListAdapter extends ArrayAdapter<Player>{

    public PlayerListAdapter(Context context, ArrayList<Player> players) {
        super(context, 0, players);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Player player = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.player_list_item, parent, false);
        }
        TextView tvPlayerName = (TextView) convertView.findViewById(R.id.tv_player_item_name);
        tvPlayerName.setText(player.name);
        return convertView;
    }

}
