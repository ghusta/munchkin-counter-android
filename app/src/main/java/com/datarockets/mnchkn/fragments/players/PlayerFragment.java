package com.datarockets.mnchkn.fragments.players;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.datarockets.mnchkn.R;
import com.datarockets.mnchkn.activities.dashboard.DashboardView;
import com.datarockets.mnchkn.models.Player;
import com.datarockets.mnchkn.utils.LogUtil;
import com.datarockets.mnchkn.views.fonts.MunchkinTextView;

import static android.widget.Toast.makeText;

public class PlayerFragment extends Fragment implements PlayerView, View.OnClickListener {

    public static final String TAG = LogUtil.makeLogTag(PlayerFragment.class);
    private int playerPosition;
    private Player player;

    PlayerPresenter presenter;
    View currentPlayerView;
    ImageButton btnLevelScoreUp, btnLevelScoreDown, btnStrengthScoreUp, btnStrengthScoreDown;
    TextView tvPlayerName;
    MunchkinTextView tvLevelScore, tvStrengthScore;
    PlayerFragmentCallback callback;

    public interface PlayerFragmentCallback {
        void onScoreChanged(Player player, int index);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new PlayerPresenterImpl(this);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        callback = (PlayerFragmentCallback) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        currentPlayerView = inflater.inflate(R.layout.fragment_player, container, false);
        tvPlayerName = (TextView) currentPlayerView.findViewById(R.id.tv_player_name);
        tvLevelScore = (MunchkinTextView) currentPlayerView.findViewById(R.id.tv_level_score);
        tvStrengthScore = (MunchkinTextView) currentPlayerView.findViewById(R.id.tv_strength_score);
        btnLevelScoreUp = (ImageButton) currentPlayerView.findViewById(R.id.btn_level_score_up);
        btnLevelScoreDown = (ImageButton) currentPlayerView.findViewById(R.id.btn_level_score_down);
        btnStrengthScoreUp = (ImageButton) currentPlayerView.findViewById(R.id.btn_strength_score_up);
        btnStrengthScoreDown = (ImageButton) currentPlayerView.findViewById(R.id.btn_strength_score_down);
        btnLevelScoreUp.setOnClickListener(this);
        btnLevelScoreDown.setOnClickListener(this);
        btnStrengthScoreUp.setOnClickListener(this);
        btnStrengthScoreDown.setOnClickListener(this);
        return currentPlayerView;
    }

    @Override
    public void onClick(View v) {
        int currentLevel = Integer.valueOf(tvLevelScore.getText().toString());
        int currentStrength = Integer.valueOf(tvStrengthScore.getText().toString());
        switch (v.getId()) {
            case R.id.btn_level_score_up:
                currentLevel++;
                tvLevelScore.setText(String.valueOf(currentLevel));
                break;
            case R.id.btn_level_score_down:
                currentLevel--;
                tvLevelScore.setText(String.valueOf(currentLevel));
                break;
            case R.id.btn_strength_score_up:
                currentStrength++;
                tvStrengthScore.setText(String.valueOf(currentStrength));
                break;
            case R.id.btn_strength_score_down:
                currentStrength--;
                tvStrengthScore.setText(String.valueOf(currentStrength));
                break;
            default:
                break;
        }
        player.setLevelScore(currentLevel);
        player.setStrengthScore(currentStrength);
        callback.onScoreChanged(player, playerPosition);
    }

    public void loadPlayerScores(Player player, int index) {
        this.player = player;
        this.playerPosition = index;
        tvPlayerName.setText(player.getName());
        tvLevelScore.setText(String.valueOf(player.getLevelScore()));
        tvStrengthScore.setText(String.valueOf(player.getStrengthScore()));
    }

}
