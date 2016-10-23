package com.datarockets.mnchkn.ui.charts

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import butterknife.BindView
import butterknife.ButterKnife
import com.datarockets.mnchkn.R
import com.datarockets.mnchkn.data.model.Player
import com.datarockets.mnchkn.utils.LogUtil
import lecho.lib.hellocharts.model.Axis
import lecho.lib.hellocharts.model.LineChartData
import lecho.lib.hellocharts.view.LineChartView
import java.util.*
import javax.inject.Inject

class ChartsFragment : Fragment(), ChartsView {

    @Inject lateinit var presenter: ChartsPresenterImpl

    lateinit var chartsView: View
    lateinit var lineChartData: LineChartData
    lateinit var lvPlayerListAdapter: PlayerChartListAdapter

    @BindView(R.id.line_chart_view) lateinit var lineChartView: LineChartView
    @BindView(R.id.lv_player_list) lateinit var lvPlayerList: ListView

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, bundle: Bundle?): View? {
        super.onCreateView(inflater, container, bundle)
        chartsView = inflater!!.inflate(R.layout.fragment_charts, container, false)
        ButterKnife.bind(this, chartsView)
        return chartsView
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        lineChartData = presenter.loadChartData(arguments.getInt(CHART_TYPE))
        lineChartData.axisXBottom = Axis().setName(
                resources.getString(R.string.text_steps))
        lineChartData.axisYLeft = Axis().setHasLines(true)
        lineChartView.lineChartData = lineChartData
        presenter.loadPlayersList(arguments.getInt(CHART_TYPE) + 1)
    }


    override fun showPlayersList(players: ArrayList<Player>) {
        lvPlayerListAdapter = PlayerChartListAdapter(activity, players,
                arguments.getInt(CHART_TYPE))
        lvPlayerList.adapter = lvPlayerListAdapter
    }


    override fun onDestroy() {
        presenter.detachView()
        super.onDestroy()
    }

    companion object {

        val TAG = LogUtil.makeLogTag(ChartsFragment::class)

        private val CHART_TYPE = "chart_type"

        fun newInstance(type: Int): ChartsFragment {
            val args = Bundle()
            args.putInt(CHART_TYPE, type)
            val fragment = ChartsFragment()
            fragment.arguments = args
            return fragment
        }
    }
}
