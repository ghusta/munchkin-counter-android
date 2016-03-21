package com.datarockets.mnchkn.views.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.datarockets.mnchkn.R;

public class PlayerAddItemViewHolder extends RecyclerView.ViewHolder {

    public Button btnAddPlayer;

    public PlayerAddItemViewHolder(View itemView) {
        super(itemView);
        btnAddPlayer = (Button) itemView.findViewById(R.id.btn_add_new_player);
    }


}
