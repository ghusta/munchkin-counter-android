package com.datarockets.mnchkn.activities.players

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AlertDialog
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.widget.ListView
import android.widget.Toast
import android.widget.Toast.makeText
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import butterknife.OnItemLongClick
import com.datarockets.mnchkn.R
import com.datarockets.mnchkn.activities.BaseActivity
import com.datarockets.mnchkn.activities.dashboard.DashboardActivity
import com.datarockets.mnchkn.activities.players.di.DaggerPlayersListComponent
import com.datarockets.mnchkn.activities.players.di.PlayersListModule
import com.datarockets.mnchkn.activities.settings.SettingsActivity
import com.datarockets.mnchkn.adapters.PlayerEditorListAdapter
import com.datarockets.mnchkn.di.AppComponent
import com.datarockets.mnchkn.fragments.dialogs.AddNewPlayerFragment
import com.datarockets.mnchkn.models.Player
import com.datarockets.mnchkn.utils.LogUtil
import javax.inject.Inject

class PlayersListActivity : BaseActivity(), PlayersListView, AddNewPlayerFragment.AddNewPlayerDialogInterface {

    @Inject
    lateinit var presenter: PlayersListPresenter
    @BindView(R.id.toolbar) lateinit var toolbar: Toolbar
    @BindView(R.id.lv_player_list) lateinit var lvPlayersList: ListView
    lateinit var lvPlayerEditorListAdapter: PlayerEditorListAdapter
    @BindView(R.id.fab_add_player) lateinit var fabAddPlayer: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_players)
        ButterKnife.bind(this)
        setSupportActionBar(toolbar)
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

    override fun onStop() {
        super.onStop()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.players_list_activity_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun addPlayerToList(player: Player) {
        lvPlayerEditorListAdapter.add(player)
        lvPlayerEditorListAdapter.notifyDataSetChanged()
    }

    override fun deletePlayerFromList(position: Int) {
        lvPlayerEditorListAdapter.remove(lvPlayerEditorListAdapter.getItem(position))
        lvPlayerEditorListAdapter.notifyDataSetChanged()
    }

    override fun setPlayersList(players: List<Player>) {
        lvPlayerEditorListAdapter = PlayerEditorListAdapter(this, players)
        lvPlayersList.adapter = lvPlayerEditorListAdapter
    }

    override fun showAddNewPlayerDialog() {
        val dialog = AddNewPlayerFragment()
        dialog.show(supportFragmentManager, TAG)
    }

    override fun launchDashboard() {
        presenter.setGameStarted()
        val intent = Intent(this, DashboardActivity::class.java)
        startActivity(intent)
        finish()
    }

    @OnItemLongClick(R.id.lv_player_list) internal fun onItemLongClick(position: Int): Boolean {
        val alertDialog = AlertDialog.Builder(this).setTitle(R.string.dialog_player_delete_title).setMessage(R.string.dialog_player_delete_message).setPositiveButton(R.string.button_yes) { dialog, which ->
            presenter.deletePlayerListItem(position,
                    lvPlayerEditorListAdapter.getItem(position)!!.id)
        }.setNegativeButton(R.string.button_no) { dialog, which -> dialog.dismiss() }.create()
        alertDialog.show()
        return true
    }

    @OnClick(R.id.fab_add_player) internal fun onClick() {
        showAddNewPlayerDialog()
    }

    override fun showStartContinueDialog() {
        val startContinueDialog = AlertDialog.Builder(this).setTitle(R.string.dialog_start_continue_game_title).setMessage(R.string.dialog_start_continue_game_message).setPositiveButton(R.string.button_continue) { dialog, which -> launchDashboard() }.setNegativeButton(R.string.button_start) { dialog, which ->
            dialog.dismiss()
            presenter.setGameFinished()
            presenter.clearPlayersStats()
            presenter.clearGameSteps()
        }.setCancelable(false).create()
        startContinueDialog.show()
    }

    override fun showWarning() {
        makeText(this, R.string.text_player_add_warning, Toast.LENGTH_SHORT).show()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item_start_game -> presenter.checkIsEnoughPlayers()
            R.id.item_settings -> {
                val intent = Intent(this, SettingsActivity::class.java)
                startActivity(intent)
            }
            else -> {
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onFinishEditDialog(inputName: String) {
        presenter.addPlayer(inputName)
    }

    override fun setUpActivityComponent(appComponent: AppComponent) {
        DaggerPlayersListComponent.builder().appComponent(appComponent).playersListModule(PlayersListModule(this)).build().inject(this)
    }

    companion object {

        val TAG = LogUtil.makeLogTag(PlayersListActivity::class)
    }

}
