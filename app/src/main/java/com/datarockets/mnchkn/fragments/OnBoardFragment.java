package com.datarockets.mnchkn.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.datarockets.mnchkn.R;

public class OnBoardFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";
    private int[] bgs = new int[] {R.drawable.ic_dice, R.drawable.ic_dice, R.drawable.ic_dice};
    private String[] titles = new String[] {"Title 1", "Title 2", "Title 3"};
    private String[] descs = new String[] {"Rich description","Rich description","Rich description"};

    View onBoardView;
    ImageView ivSectionImage;
    TextView tvSectionLabel;
    TextView tvSectionDescription;

    public OnBoardFragment() {}

    public static OnBoardFragment newInstance(int sectionNumber) {
        OnBoardFragment fragment = new OnBoardFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        onBoardView = inflater.inflate(R.layout.fragment_onboard, container, false);
        tvSectionLabel = (TextView) onBoardView.findViewById(R.id.tv_section_label);
        tvSectionLabel.setText(titles[getArguments().getInt(ARG_SECTION_NUMBER) - 1]);
        tvSectionDescription = (TextView) onBoardView.findViewById(R.id.tv_section_description);
        tvSectionDescription.setText(descs[getArguments().getInt(ARG_SECTION_NUMBER) - 1]);
        ivSectionImage = (ImageView) onBoardView.findViewById(R.id.iv_section_image);
        ivSectionImage.setBackgroundResource(bgs[getArguments().getInt(ARG_SECTION_NUMBER) - 1]);

        return onBoardView;
    }

}
