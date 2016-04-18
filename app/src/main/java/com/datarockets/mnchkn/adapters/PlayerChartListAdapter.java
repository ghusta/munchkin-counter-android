package com.datarockets.mnchkn.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.datarockets.mnchkn.R;
import com.datarockets.mnchkn.models.Player;

import java.util.ArrayList;

public class PlayerChartListAdapter extends ArrayAdapter<Player> {

    private static final int ORDER_BY_LEVEL = 0;
    private static final int ORDER_BY_STRENGTH = 1;
    private static final int ORDER_BY_TOTAL = 2;

    ArrayList<Player> playersList;
    Context context;
    int type;

    public PlayerChartListAdapter(Context context, ArrayList<Player> playersList, int type) {
        super(context, 0, playersList);
        this.context = context;
        this.playersList = playersList;
        this.type = type;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Player player = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.player_chart_item, null);
        }

        int color = Color.parseColor(player.getColor());
        String capitalizedPlayerFirstLetter = player.getName().substring(0, 1).toUpperCase();
        TextDrawable drawable = TextDrawable.builder().buildRound(capitalizedPlayerFirstLetter, color);
        ImageView ivPlayerColor = (ImageView) convertView.findViewById(R.id.iv_player_color);
        ivPlayerColor.setImageDrawable(drawable);
        TextView tvPlayerName = (TextView) convertView.findViewById(R.id.tv_player_name);
        TextView tvPlayerScore = (TextView) convertView.findViewById(R.id.tv_player_score);
        switch (type) {
            case ORDER_BY_LEVEL:
                tvPlayerScore.setText(String.valueOf(player.getLevelScore()));
                break;
            case ORDER_BY_STRENGTH:
                tvPlayerScore.setText(String.valueOf(player.getStrengthScore()));
                break;
            case ORDER_BY_TOTAL:
                tvPlayerScore.setText(String.valueOf(player.getLevelScore() + player.getStrengthScore()));
                break;
        }
        tvPlayerName.setText(player.getName());
        return convertView;
    }


}
