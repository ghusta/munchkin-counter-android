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

    View chartsView;
    LineChartView lineChartView;
    ListView lvPlayerList;
    PlayerChartListAdapter lvPlayerListAdapter;
    ChartsPresenterImpl presenter;
    LayoutInflater layoutInflater;
    ViewGroup container;

    public static ChartsFragment newInstance(int type) {
        Bundle args = new Bundle();
        args.putInt("TYPE", type);
        ChartsFragment fragment = new ChartsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        this.layoutInflater = inflater;
        this.container = container;
        presenter = new ChartsPresenterImpl(this, getActivity());
        chartsView = inflater.inflate(R.layout.fragment_charts, container, false);
        return chartsView;
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.loadChartData(getArguments().getInt("TYPE"));
        lvPlayerList = (ListView) view.findViewById(R.id.lv_player_list);
        lineChartView = (LineChartView) view.findViewById(R.id.line_chart_view);
    }


    @Override
    public void drawChart(LineChartData lineChartData) {
        chartsView = layoutInflater.inflate(R.layout.fragment_charts, container, false);
        lineChartView = (LineChartView) chartsView.findViewById(R.id.line_chart_view);
        lineChartView.setLineChartData(lineChartData);
    }

    @Override
    public void showPlayersList(ArrayList<Player> players) {
        lvPlayerListAdapter = new PlayerChartListAdapter(getActivity(), players);
        lvPlayerList.setAdapter(lvPlayerListAdapter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

}
