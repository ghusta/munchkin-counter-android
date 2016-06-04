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

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PlayerEditorListAdapter extends ArrayAdapter<Player> {

    public static final String TAG = LogUtil.makeLogTag(PlayerEditorListAdapter.class);

    private List<Player> mPlayersList;
    private Context mContext;

    public PlayerEditorListAdapter(Context context, List<Player> players) {
        super(context, 0, players);
        this.mContext = context;
        this.mPlayersList = players;
    }

    @Override
    public Player getItem(int position) {
        return mPlayersList.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        Player player = mPlayersList.get(position);
        if (convertView != null) {
            holder = (ViewHolder) convertView.getTag();
        } else {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.player_item, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }

        int color = Color.parseColor(player.getColor());
        String capitalizedPlayerFirstLetter = player.getName().substring(0, 1).toUpperCase();
        TextDrawable drawable = TextDrawable.builder()
                .buildRound(capitalizedPlayerFirstLetter, color);
        holder.ivPlayerImage.setImageDrawable(drawable);
        holder.tvPlayerName.setText(player.getName());
        return convertView;
    }

    static final class ViewHolder {
        @BindView(R.id.iv_player_color) ImageView ivPlayerImage;
        @BindView(R.id.tv_player_name) TextView tvPlayerName;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

}
