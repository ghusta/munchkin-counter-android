package com.datarockets.mnchkn.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.datarockets.mnchkn.R;
import com.datarockets.mnchkn.models.Player;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PlayerListAdapter extends ArrayAdapter<Player>{

    List<Player> players;

    public PlayerListAdapter(Context context, List<Player> players) {
        super(context, 0, players);
        this.players = players;
    }

    @Override
    public Player getItem(int position) {
        return players.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        Player player = players.get(position);

        if (convertView != null) {
            holder = (ViewHolder) convertView.getTag();
        } else {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.player_list_item, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }

        holder.tvPlayerName.setText(player.getName());
        holder.tvPlayerLevelScore.setText(String.valueOf(player.getLevelScore()));
        holder.tvPlayerStrengthScore.setText(String.valueOf(player.getStrengthScore()));
        return convertView;
    }

    static final class ViewHolder {
        @BindView(R.id.tv_player_item_name) TextView tvPlayerName;
        @BindView(R.id.tv_player_item_level_score) TextView tvPlayerLevelScore;
        @BindView(R.id.tv_player_item_strength_score) TextView tvPlayerStrengthScore;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }

    }

}
