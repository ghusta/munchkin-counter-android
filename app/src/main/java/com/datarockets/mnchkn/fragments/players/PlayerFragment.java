package com.datarockets.mnchkn.fragments.players;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.datarockets.mnchkn.R;
import com.datarockets.mnchkn.di.AppComponent;
import com.datarockets.mnchkn.fragments.BaseFragment;
import com.datarockets.mnchkn.fragments.players.di.DaggerPlayerComponent;
import com.datarockets.mnchkn.fragments.players.di.PlayerModule;
import com.datarockets.mnchkn.models.Player;
import com.datarockets.mnchkn.views.fonts.MunchkinTextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PlayerFragment extends BaseFragment implements PlayerView, View.OnClickListener {

    private int mPlayerPosition;
    private Player mPlayer;

    @Inject PlayerPresenter presenter;
    View currentPlayerView;
    @BindView(R.id.btn_level_score_up) ImageButton btnLevelScoreUp;
    @BindView(R.id.btn_level_score_down) ImageButton btnLevelScoreDown;
    @BindView(R.id.btn_strength_score_up) ImageButton btnStrengthScoreUp;
    @BindView(R.id.btn_strength_score_down) ImageButton btnStrengthScoreDown;
    @BindView(R.id.tv_player_name) MunchkinTextView tvPlayerName;
    @BindView(R.id.tv_level_score) MunchkinTextView tvLevelScore;
    @BindView(R.id.tv_strength_score) MunchkinTextView tvStrengthScore;
    PlayerFragmentCallback callback;

    public interface PlayerFragmentCallback {
        void onScoreChanged(Player player, int index);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        callback = (PlayerFragmentCallback) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle bundle) {
        currentPlayerView = inflater.inflate(R.layout.fragment_player, container, false);
        ButterKnife.bind(this, currentPlayerView);
        btnLevelScoreUp.setOnClickListener(this);
        btnLevelScoreDown.setOnClickListener(this);
        btnStrengthScoreUp.setOnClickListener(this);
        btnStrengthScoreDown.setOnClickListener(this);
        return currentPlayerView;
    }

    @Override
    protected void setUpComponent(AppComponent appComponent) {
        DaggerPlayerComponent.builder()
                .appComponent(appComponent)
                .playerModule(new PlayerModule(this))
                .build()
                .inject(this);
    }

    @Override
    public void onClick(View v) {
        int currentLevel = Integer.parseInt(tvLevelScore.getText().toString());
        int currentStrength = Integer.parseInt(tvStrengthScore.getText().toString());
        switch (v.getId()) {
            case R.id.btn_level_score_up:
                presenter.increaseLevelScore(currentLevel);
                break;
            case R.id.btn_level_score_down:
                presenter.decreaseLevelScore(currentLevel);
                break;
            case R.id.btn_strength_score_up:
                presenter.increaseStrengthScore(currentStrength);
                break;
            case R.id.btn_strength_score_down:
                presenter.decreaseStrengthScore(currentStrength);
                break;
            default:
                break;
        }
        mPlayer.setStrengthScore(Integer.parseInt(tvStrengthScore.getText().toString()));
        mPlayer.setLevelScore(Integer.parseInt(tvLevelScore.getText().toString()));
        callback.onScoreChanged(mPlayer, mPlayerPosition);
    }

    public void loadPlayerScores(Player player, int index) {
        this.mPlayer = player;
        this.mPlayerPosition = index;
        tvPlayerName.setText(player.getName());
        tvLevelScore.setText(String.valueOf(player.getLevelScore()));
        tvStrengthScore.setText(String.valueOf(player.getStrengthScore()));
    }

    @Override
    public void setLevelScore(String score) {
        tvLevelScore.setText(score);
    }

    @Override
    public void setStrengthScore(String score) {
        tvStrengthScore.setText(score);
    }

}
