package com.datarockets.mnchkn.activities.chooser;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import com.datarockets.mnchkn.R;
import com.datarockets.mnchkn.adapters.GameChooserAdapter;
import com.datarockets.mnchkn.fragments.dialogs.GameInfoFragment;
import com.datarockets.mnchkn.utils.LogUtil;

public class ChooseGameActivity extends AppCompatActivity implements ChooseGameView {

    public static final String TAG = LogUtil.makeLogTag(ChooseGameActivity.class);

    ChooseGamePresenterImpl presenter;
    GridView gvGameChooser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_game);
        presenter = new ChooseGamePresenterImpl(this);
        gvGameChooser = (GridView) findViewById(R.id.gv_game_chooser);
        gvGameChooser.setAdapter(new GameChooserAdapter(this));
        gvGameChooser.setOnItemClickListener((parent, view, position, id) -> {
            GameInfoFragment gameInfoFragment = new GameInfoFragment();
            gameInfoFragment.show(getSupportFragmentManager(), TAG);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }
}
