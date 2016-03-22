package com.datarockets.mnchkn.fragments.players;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.datarockets.mnchkn.R;
import com.datarockets.mnchkn.activities.dashboard.DashboardView;
import com.datarockets.mnchkn.views.fonts.MunchkinTextView;

import static android.widget.Toast.makeText;

public class PlayerFragment extends Fragment implements PlayerView, View.OnClickListener {

    View currentPlayerView;
    ImageButton btnLevelScoreUp, btnLevelScoreDown, btnStrengthScoreUp, btnStrengthScoreDown;
    MunchkinTextView tvLevelScore, tvStrengthScore;

    DashboardView dashboardView;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            dashboardView = (DashboardView) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "must implement listeners");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        currentPlayerView = inflater.inflate(R.layout.fragment_player, container, false);
        tvLevelScore = (MunchkinTextView) currentPlayerView.findViewById(R.id.tv_level_score);
        tvStrengthScore = (MunchkinTextView) currentPlayerView.findViewById(R.id.tv_strength_score);
        btnLevelScoreUp = (ImageButton) currentPlayerView.findViewById(R.id.btn_level_score_up);
        btnLevelScoreUp.setOnClickListener(this);
        btnLevelScoreDown = (ImageButton) currentPlayerView.findViewById(R.id.btn_level_score_down);
        btnLevelScoreDown.setOnClickListener(this);
        btnStrengthScoreUp = (ImageButton) currentPlayerView.findViewById(R.id.btn_strength_score_up);
        btnStrengthScoreUp.setOnClickListener(this);
        btnStrengthScoreDown = (ImageButton) currentPlayerView.findViewById(R.id.btn_strength_score_down);
        btnStrengthScoreDown.setOnClickListener(this);
        return currentPlayerView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onClick(View v) {
        Integer currentLevel = Integer.valueOf(tvLevelScore.getText().toString());
        Integer currentStrength = Integer.valueOf(tvStrengthScore.getText().toString());
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
    }

    @Override
    public void showToastWithMessage(CharSequence message) {
        makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

}
