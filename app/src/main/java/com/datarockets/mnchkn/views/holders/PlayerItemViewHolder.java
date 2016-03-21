package com.datarockets.mnchkn.views.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.datarockets.mnchkn.R;


public class PlayerItemViewHolder extends RecyclerView.ViewHolder {

    public TextView tvPlayerItemName;
    public TextView tvPlayerItemLevelScore;
    public TextView tvPlayerItemStrengthScore;

    public PlayerItemViewHolder(View itemView) {
        super(itemView);
        tvPlayerItemName = (TextView) itemView.findViewById(R.id.tv_player_item_name);
        tvPlayerItemLevelScore = (TextView) itemView.findViewById(R.id.tv_player_item_level_score);
        tvPlayerItemStrengthScore = (TextView) itemView.findViewById(R.id.tv_player_item_strength_score);
    }

}
