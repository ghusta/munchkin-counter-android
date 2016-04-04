package com.datarockets.mnchkn.adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.datarockets.mnchkn.R;

import java.util.ArrayList;
import java.util.List;

public class GameChooserAdapter extends BaseAdapter {

    private final List<String> games = new ArrayList<String>();
    private final LayoutInflater inflater;

    public GameChooserAdapter(Context context) {
        inflater = LayoutInflater.from(context);
        games.add("punchkin");
        games.add("punchkin");
        games.add("punchkin");
        games.add("punchkin");
        games.add("punchkin");
        games.add("punchkin");
    }

    @Override
    public int getCount() {
        return games.size();
    }

    @Override
    public Object getItem(int position) {
        return games.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.choose_game_item, parent, false);
        }
        textView = (TextView) convertView.findViewById(R.id.tv_game_title);
        textView.setText("Munchkin");
        return convertView;
    }

}
