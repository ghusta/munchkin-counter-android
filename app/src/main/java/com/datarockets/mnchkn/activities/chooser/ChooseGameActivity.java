package com.datarockets.mnchkn.activities.chooser;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import com.datarockets.mnchkn.R;
import com.datarockets.mnchkn.adapters.GameChooserAdapter;
import com.datarockets.mnchkn.fragments.dialogs.GameInfoFragment;
import com.datarockets.mnchkn.utils.LogUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

public class ChooseGameActivity extends AppCompatActivity implements ChooseGameView {

    public static final String TAG = LogUtil.makeLogTag(ChooseGameActivity.class);

    ChooseGamePresenter presenter;
    GameChooserAdapter gameChooserAdapter;
    @BindView(R.id.gv_game_chooser) GridView gvGameChooser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_game);
        ButterKnife.bind(this);
        presenter = new ChooseGamePresenterImpl(this);
        gameChooserAdapter = new GameChooserAdapter(this);
        gvGameChooser.setAdapter(gameChooserAdapter);
    }

    @OnItemClick(R.id.gv_game_chooser) void onItemClick(int position) {
        GameInfoFragment gameInfoFragment = new GameInfoFragment();
        gameInfoFragment.show(getSupportFragmentManager(), TAG);
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
