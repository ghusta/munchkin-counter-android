package com.datarockets.mnchkn.fragments.charts;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.datarockets.mnchkn.R;
import com.datarockets.mnchkn.adapters.PlayerChartListAdapter;
import com.datarockets.mnchkn.models.Player;
import com.datarockets.mnchkn.utils.LogUtil;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.view.LineChartView;

public class ChartsFragment extends Fragment implements ChartsView {

    public static final String TAG = LogUtil.makeLogTag(ChartsFragment.class);

    private static final String CHART_TYPE = "chart_type";

    View chartsView;
    @BindView(R.id.line_chart_view) LineChartView lineChartView;
    LineChartData lineChartData;
    @BindView(R.id.lv_player_list) ListView lvPlayerList;
    PlayerChartListAdapter lvPlayerListAdapter;
    ChartsPresenterImpl presenter;

    public static ChartsFragment newInstance(int type) {
        Bundle args = new Bundle();
        args.putInt(CHART_TYPE, type);
        ChartsFragment fragment = new ChartsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        chartsView = inflater.inflate(R.layout.fragment_charts, container, false);
        ButterKnife.bind(this, chartsView);
        presenter = new ChartsPresenterImpl(this, getActivity());
        lineChartData = presenter.loadChartData(getArguments().getInt(CHART_TYPE));
        return chartsView;
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        lineChartData.setAxisXBottom(new Axis().setName(getResources().getString(R.string.text_steps)));
        lineChartData.setAxisYLeft(new Axis().setHasLines(true));
        lineChartView.setLineChartData(lineChartData);
        presenter.loadPlayersList(getArguments().getInt(CHART_TYPE) + 1);
    }


    @Override
    public void showPlayersList(ArrayList<Player> players) {
        lvPlayerListAdapter = new PlayerChartListAdapter(getActivity(), players, getArguments().getInt(CHART_TYPE));
        lvPlayerList.setAdapter(lvPlayerListAdapter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

}
