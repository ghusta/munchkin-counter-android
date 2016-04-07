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
import com.datarockets.mnchkn.utils.LogUtil;

import java.util.ArrayList;

public class PlayerEditorListAdapter extends ArrayAdapter<Player> {

    public static final String TAG = LogUtil.makeLogTag(PlayerEditorListAdapter.class);

    ArrayList<Player> playersList;
    Context context;

    public PlayerEditorListAdapter(Context context, ArrayList<Player> players) {
        super(context, 0, players);
        this.context = context;
        this.playersList = players;
    }

    @Override
    public Player getItem(int position) {
        return playersList.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Player player = playersList.get(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.player_item, null);
        }

        int color = Color.parseColor(player.getColor());
        String capitalizedPlayerFirstLetter = player.getName().substring(0, 1).toUpperCase();
        TextDrawable drawable = TextDrawable.builder().buildRound(capitalizedPlayerFirstLetter, color);
        ImageView ivPlayerImage = (ImageView) convertView.findViewById(R.id.iv_player_color);
        ivPlayerImage.setImageDrawable(drawable);
        TextView tvPlayerName = (TextView) convertView.findViewById(R.id.tv_player_name);
        tvPlayerName.setText(player.getName());
        return convertView;
    }
}
