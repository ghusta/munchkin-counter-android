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

import java.util.ArrayList;

import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.view.LineChartView;

public class ChartsFragment extends Fragment implements ChartsView {

    public static final String DATA_TYPE = "dataType";

    View chartsView;
    LineChartView lineChartView;
    ListView lvPlayerList;
    PlayerChartListAdapter lvPlayerListAdapter;
    ChartsPresenter presenter;

    public static ChartsFragment newInstance(int type) {
        ChartsFragment fragment = new ChartsFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(DATA_TYPE, type);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new ChartsPresenterImpl(this, getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        chartsView = inflater.inflate(R.layout.fragment_charts, container, false);
        lineChartView = (LineChartView) chartsView.findViewById(R.id.line_chart_view);
        lvPlayerList = (ListView) chartsView.findViewById(R.id.lv_player_list);
        return chartsView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.onViewCreated();
    }

    @Override
    public void loadCharts(LineChartData lineChartData) {
        lineChartView.setLineChartData(lineChartData);
    }

    @Override
    public void loadPlayers(ArrayList<Player> players) {
        lvPlayerListAdapter = new PlayerChartListAdapter(getActivity(), players);
        lvPlayerList.setAdapter(lvPlayerListAdapter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }
}
