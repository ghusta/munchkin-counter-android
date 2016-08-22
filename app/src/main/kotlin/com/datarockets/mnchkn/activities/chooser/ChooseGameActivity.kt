package com.datarockets.mnchkn.activities.chooser

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.GridView
import butterknife.BindView
import butterknife.OnItemClick
import com.datarockets.mnchkn.R
import com.datarockets.mnchkn.adapters.GameChooserAdapter
import com.datarockets.mnchkn.fragments.dialogs.GameInfoFragment
import com.datarockets.mnchkn.utils.LogUtil

class ChooseGameActivity : AppCompatActivity(), ChooseGameView {

    lateinit var presenter: ChooseGamePresenterImpl
    lateinit var gameChooserAdapter: GameChooserAdapter
    @BindView(R.id.gv_game_chooser) lateinit var gvGameChooser: GridView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_game)
        presenter = ChooseGamePresenterImpl(this)
        gameChooserAdapter = GameChooserAdapter(this)
        gvGameChooser.adapter = gameChooserAdapter
    }

    @OnItemClick(R.id.gv_game_chooser) internal fun onItemClick(position: Int) {
        val gameInfoFragment = GameInfoFragment()
        gameInfoFragment.show(supportFragmentManager, TAG)
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    companion object {
        val TAG = LogUtil.makeLogTag(ChooseGameActivity::class)
    }
}
