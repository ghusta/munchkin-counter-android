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

import butterknife.BindView;
import butterknife.ButterKnife;

public class PlayerChartListAdapter extends ArrayAdapter<Player> {

    private static final int ORDER_BY_LEVEL = 0;
    private static final int ORDER_BY_STRENGTH = 1;
    private static final int ORDER_BY_TOTAL = 2;

    private ArrayList<Player> mPlayersList;
    private Context mContext;
    private int mType;

    public PlayerChartListAdapter(Context context, ArrayList<Player> playersList, int type) {
        super(context, 0, playersList);
        this.mContext = context;
        this.mPlayersList = playersList;
        this.mType = type;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        Player player = getItem(position);

        if (convertView != null) {
            holder = (ViewHolder) convertView.getTag();
        } else {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.player_chart_item, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }

        int color = Color.parseColor(player.getColor());
        String capitalizedPlayerFirstLetter = player.getName().substring(0, 1).toUpperCase();
        TextDrawable drawable = TextDrawable.builder().
                buildRound(capitalizedPlayerFirstLetter, color);

        holder.ivPlayerColor.setImageDrawable(drawable);
        holder.tvPlayerName.setText(player.getName());
        switch (mType) {
            case ORDER_BY_LEVEL:
                String levelScore = String.valueOf(player.getLevelScore());
                holder.tvPlayerScore.setText(levelScore);
                break;
            case ORDER_BY_STRENGTH:
                String strengthScore = String.valueOf(player.getStrengthScore());
                holder.tvPlayerScore.setText(strengthScore);
                break;
            case ORDER_BY_TOTAL:
                int totalScoreAmount = player.getLevelScore() + player.getStrengthScore();
                String totalScore = String.valueOf(totalScoreAmount);
                holder.tvPlayerScore.setText(totalScore);
                break;
        }
        return convertView;
    }

    static final class ViewHolder {
        @BindView(R.id.iv_player_color) ImageView ivPlayerColor;
        @BindView(R.id.tv_player_name) TextView tvPlayerName;
        @BindView(R.id.tv_player_score) TextView tvPlayerScore;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }


}
