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

    ArrayList<Player> players = new ArrayList<>();

    public PlayerListAdapter(Context context, ArrayList<Player> players) {
        super(context, 0, players);
        this.players = players;
    }

    @Override
    public Player getItem(int position) {
        return players.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Player player = players.get(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.player_list_item, parent, false);
        }
        TextView tvPlayerName = (TextView) convertView.findViewById(R.id.tv_player_item_name);
        TextView tvPlayerLevelScore = (TextView) convertView.findViewById(R.id.tv_player_item_level_score);
        TextView tvPlayerStrengthScore = (TextView) convertView.findViewById(R.id.tv_player_item_strength_score);
        tvPlayerName.setText(player.getName());
        tvPlayerLevelScore.setText(String.valueOf(player.getLevelScore()));
        tvPlayerStrengthScore.setText(String.valueOf(player.getStrengthScore()));
        return convertView;
    }

}
