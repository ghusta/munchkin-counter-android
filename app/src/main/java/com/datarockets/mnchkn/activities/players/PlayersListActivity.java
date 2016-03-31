package com.datarockets.mnchkn.activities.players;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.datarockets.mnchkn.R;
import com.datarockets.mnchkn.activities.dashboard.DashboardActivity;
import com.datarockets.mnchkn.activities.settings.SettingsActivity;
import com.datarockets.mnchkn.adapters.PlayerListAdapter;
import com.datarockets.mnchkn.fragments.dialogs.AddNewPlayerFragment;
import com.datarockets.mnchkn.models.Player;
import com.datarockets.mnchkn.utils.LogUtil;

import java.util.ArrayList;

import static android.widget.Toast.makeText;

public class PlayersListActivity extends AppCompatActivity implements PlayersListView,
        AdapterView.OnItemLongClickListener, View.OnClickListener, AddNewPlayerFragment.AddNewPlayerDialogInterface {

    public static final String TAG = LogUtil.makeLogTag(PlayersListActivity.class);

    PlayersListPresenter presenter;
    Toolbar toolbar;
    ListView lvPlayersList;
    PlayerListAdapter lvPlayerListAdapter;
    FloatingActionButton fabAddPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new PlayersListPresenterImpl(this, this);
        setContentView(R.layout.activity_players);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        lvPlayersList = (ListView) findViewById(R.id.lv_player_list);
        lvPlayersList.setOnItemLongClickListener(this);
        fabAddPlayer = (FloatingActionButton) findViewById(R.id.fab_add_player);
        fabAddPlayer.setOnClickListener(this);
        presenter.onCreate();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.players_list_activity_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void addPlayerToList(Player player) {
        lvPlayerListAdapter.add(player);
        lvPlayerListAdapter.notifyDataSetChanged();
    }

    @Override
    public void deletePlayerFromList(int position) {
        lvPlayerListAdapter.remove(lvPlayerListAdapter.getItem(position));
        lvPlayerListAdapter.notifyDataSetChanged();
    }

    @Override
    public void setPlayersList(ArrayList<Player> players) {
        lvPlayerListAdapter = new PlayerListAdapter(this, players);
        lvPlayersList.setAdapter(lvPlayerListAdapter);
    }

    @Override
    public void showAddNewPlayerDialog() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        AddNewPlayerFragment addNewPlayerFragment = AddNewPlayerFragment.newInstance();
        addNewPlayerFragment.show(fragmentManager, TAG);
    }

    @Override
    public void launchDashboard() {
        presenter.setGameStarted();
        Intent intent = new Intent(this, DashboardActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setTitle(R.string.dialog_player_delete_title)
                .setMessage(R.string.dialog_player_delete_message)
                .setPositiveButton(R.string.button_yes, (dialog, which) -> {
                    presenter.deletePlayerListItem(position, lvPlayerListAdapter.getItem(position).getId());
                })
                .setNegativeButton(R.string.button_no, (dialog, which) -> {
                    dialog.dismiss();
                })
                .create();
        alertDialog.show();
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fab_add_player:
                showAddNewPlayerDialog();
                break;
            default:
                break;
        }
    }

    @Override
    public void showStartContinueDialog() {
        AlertDialog startContinueDialog = new AlertDialog.Builder(this)
                .setTitle(R.string.dialog_start_continue_game_title)
                .setMessage(R.string.dialog_start_continue_game_message)
                .setPositiveButton(R.string.button_continue, (dialog, which) -> {
                    launchDashboard();
                })
                .setNegativeButton(R.string.button_start, (dialog, which) -> {
                    dialog.dismiss();
                    presenter.setGameFinished();
                })
                .setCancelable(false)
                .create();
        startContinueDialog.show();
    }

    @Override
    public void showWarning() {
        makeText(this, R.string.text_player_add_warning, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_start_game:
                presenter.checkIsEnoughPlayers();
                break;
            case R.id.item_settings:
                launchSettings();
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFinishEditDialog(String inputName) {
        presenter.addPlayer(inputName);
    }

    private void launchSettings() {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }

}
