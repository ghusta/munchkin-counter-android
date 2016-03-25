package com.datarockets.mnchkn.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.datarockets.mnchkn.R;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.view.LineChartView;

public class ChartsFragment extends Fragment{

    View chartsView;
    LineChartView lineChartView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        chartsView = inflater.inflate(R.layout.fragment_charts, container, false);
        List<PointValue> values = new ArrayList<>();
        values.add(new PointValue(0, 2));
        values.add(new PointValue(1, 4));
        values.add(new PointValue(2, 3));
        values.add(new PointValue(3, 5));
        Line line = new Line(values);
        line.setColor(Color.BLUE);
        line.setCubic(true);
        line.setHasPoints(true);
        List<Line> lines = new ArrayList<>();
        lines.add(line);


        Axis axisX = new Axis();
        Axis axisY = new Axis();
        axisX.setName("Count");
        axisY.setName("Steps count");

        LineChartData data = new LineChartData(lines);
        data.setAxisXBottom(axisX);
        data.setAxisYLeft(axisY);

        lineChartView = (LineChartView) chartsView.findViewById(R.id.line_chart_view);
        lineChartView.setLineChartData(data);
        return chartsView;
    }

}
