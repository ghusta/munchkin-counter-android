package com.datarockets.mnchkn.activities.dashboard

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.view.WindowManager
import android.widget.Button
import android.widget.ListView
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import butterknife.OnItemClick
import com.datarockets.mnchkn.R
import com.datarockets.mnchkn.activities.BaseActivity
import com.datarockets.mnchkn.activities.dashboard.di.DaggerDashboardComponent
import com.datarockets.mnchkn.activities.dashboard.di.DashboardModule
import com.datarockets.mnchkn.activities.result.GameResultActivity
import com.datarockets.mnchkn.adapters.PlayerListAdapter
import com.datarockets.mnchkn.di.AppComponent
import com.datarockets.mnchkn.fragments.players.PlayerFragment
import com.datarockets.mnchkn.models.Player
import com.datarockets.mnchkn.utils.LogUtil
import javax.inject.Inject

class DashboardActivity : BaseActivity(), DashboardView, PlayerFragment.PlayerFragmentCallback {

    @Inject
    lateinit var presenter: DashboardPresenter
    @BindView(R.id.toolbar) lateinit var toolbar: Toolbar
    @BindView(R.id.lv_player_list) lateinit var lvPlayerList: ListView
    lateinit var lvPlayerListAdapter: PlayerListAdapter
    @BindView(R.id.btn_next_step) lateinit var btnNextStep: Button
    lateinit var playerFragment: PlayerFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        ButterKnife.bind(this)
        setSupportActionBar(toolbar)
        playerFragment = supportFragmentManager.findFragmentById(R.id.fragment_player) as PlayerFragment
        presenter.onCreate()
    }

    override fun onResume() {
        super.onResume()
        trackWithProperties("Current activity", "Activity name", TAG)
        presenter.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    override fun setUpActivityComponent(appComponent: AppComponent) {
        DaggerDashboardComponent.builder()
                .appComponent(appComponent)
                .dashboardModule(DashboardModule(this))
                .build()
                .inject(this)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.drawer, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item_finish_game -> showConfirmFinishGameDialog()
            else -> return super.onOptionsItemSelected(item)
        }
        return super.onOptionsItemSelected(item)
    }

    override fun finishGame() {
        presenter.setGameFinished()
        val intent = Intent(this, GameResultActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun setItems(players: List<Player>) {
        lvPlayerListAdapter = PlayerListAdapter(this, players)
        lvPlayerList.adapter = lvPlayerListAdapter
        lvPlayerList.setSelection(0)
        lvPlayerList.setItemChecked(0, true)
        playerFragment.loadPlayerScores(lvPlayerListAdapter.getItem(0), 0)
    }

    override fun showConfirmFinishGameDialog() {
        val confirmFinishGameDialog = AlertDialog.Builder(this).setTitle(R.string.dialog_finish_game_title).setMessage(R.string.dialog_finish_game_message).setPositiveButton(R.string.button_yes) { dialog, which -> finishGame() }.setNegativeButton(R.string.button_no) { dialog, which -> dialog.dismiss() }
        confirmFinishGameDialog.create().show()
    }


    override fun updatePlayerData(player: Player, position: Int) {
        val playerToUpdate = lvPlayerListAdapter.getItem(position)
        playerToUpdate.levelScore = player.levelScore
        playerToUpdate.strengthScore = player.strengthScore
        lvPlayerListAdapter.notifyDataSetChanged()
    }

    override fun keepScreenOn(keepActive: Boolean) {
        if (keepActive) {
            window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        } else {
            window.clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        }
    }

    @OnClick(R.id.btn_next_step) internal fun nextStep() {
        var position = lvPlayerList.checkedItemPosition
        if (position == lvPlayerList.count - 1) {
            lvPlayerList.setItemChecked(0, true)
            lvPlayerList.setSelection(0)
            position = 0
        } else {
            position++
            lvPlayerList.setItemChecked(position, true)
            lvPlayerList.setSelection(position)
        }
        playerFragment.loadPlayerScores(lvPlayerListAdapter.getItem(position), position)
    }

    @OnItemClick(R.id.lv_player_list) internal fun onItemClick(position: Int) {
        lvPlayerList.setItemChecked(position, true)
        playerFragment.loadPlayerScores(lvPlayerListAdapter.getItem(position), position)
    }

    override fun onScoreChanged(player: Player, index: Int) {
        presenter.updatePlayerListItem(player, index)
        presenter.insertStep(player)
    }

    companion object {

        val TAG = LogUtil.makeLogTag(DashboardActivity::class)
    }

}
