package com.datarockets.mnchkn.activities.dashboard;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.datarockets.mnchkn.R;
import com.datarockets.mnchkn.adapters.PlayerListAdapter;
import com.datarockets.mnchkn.fragments.dialogs.AddNewPlayerFragment;
import com.datarockets.mnchkn.fragments.players.PlayerFragment;
import com.datarockets.mnchkn.fragments.players.PlayerWarningFragment;
import com.datarockets.mnchkn.models.Player;
import com.datarockets.mnchkn.utils.LogUtil;

import java.util.ArrayList;

public class DashboardActivity extends AppCompatActivity implements DashboardView,
        View.OnClickListener, AdapterView.OnItemLongClickListener,
        AdapterView.OnItemClickListener, AddNewPlayerFragment.AddNewPlayerDialogInterface,
        PlayerFragment.PlayerFragmentCallback {

    public static final String TAG = LogUtil.makeLogTag(DashboardActivity.class);

    DashboardPresenter presenter;
    Toolbar toolbar;
    ListView lvPlayerList;
    View lvPlayerListFooterView;
    PlayerListAdapter lvPlayerListAdapter;
    Button btnNextStep, btnAddNewPlayer;
    PlayerFragment playerFragment;
    PlayerWarningFragment playerWarningFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new DashboardPresenterImpl(this, this);
        setContentView(R.layout.activity_dashboard);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        btnNextStep = (Button) findViewById(R.id.btn_next_step);
        btnNextStep.setOnClickListener(this);
        lvPlayerList = (ListView) findViewById(R.id.lv_player_list);
        lvPlayerListFooterView = getLayoutInflater().inflate(R.layout.player_add_list_item, null);
        lvPlayerList.addFooterView(lvPlayerListFooterView);
        btnAddNewPlayer = (Button) lvPlayerListFooterView.findViewById(R.id.btn_add_new_player);
        btnAddNewPlayer.setOnClickListener(this);
        lvPlayerList.setOnItemClickListener(this);
        lvPlayerList.setOnItemLongClickListener(this);
        playerFragment = new PlayerFragment();
        playerWarningFragment = new PlayerWarningFragment();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onResume();
        presenter.checkIsEnoughPlayers();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.drawer, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_start_game:
                btnAddNewPlayer.setEnabled(true);
                break;
            case R.id.item_finish_game:
                showConfirmFinishGameDialog();
                break;
            case R.id.item_settings:
                openSettingsActivity();
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void finishGame() {
        // TODO
    }

    @Override
    public void setItems(ArrayList<Player> players) {
        lvPlayerListAdapter = new PlayerListAdapter(this, players);
        lvPlayerList.setAdapter(lvPlayerListAdapter);
    }

    @Override
    public void openSettingsActivity() {
        // TODO
    }

    @Override
    public void showConfirmFinishGameDialog() {
        AlertDialog.Builder confirmFinishGameDialog = new AlertDialog.Builder(this)
                .setTitle(R.string.dialog_finish_game_title)
                .setMessage(R.string.dialog_finish_game_message)
                .setPositiveButton(R.string.button_yes, (dialog, which) -> {
                    dialog.dismiss();
                })
                .setNegativeButton(R.string.button_no, (dialog, which) -> {
                    dialog.dismiss();
                });
        confirmFinishGameDialog.create().show();
    }

    @Override
    public void showAddNewPlayerDialog() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        AddNewPlayerFragment addNewPlayerFragment = AddNewPlayerFragment.newInstance();
        addNewPlayerFragment.show(fragmentManager, TAG);
    }

    @Override
    public void updatePlayerData(Player player, int position) {
        Player playerToUpdate = lvPlayerListAdapter.getItem(position);
        playerToUpdate.levelScore = player.levelScore;
        playerToUpdate.strengthScore = player.strengthScore;
        lvPlayerListAdapter.notifyDataSetChanged();
    }

    @Override
    public void addPlayerToList(Player player) {
        lvPlayerListAdapter.add(player);
        lvPlayerListAdapter.notifyDataSetChanged();
        presenter.checkIsEnoughPlayers();
        lvPlayerList.setSelection(0);
        lvPlayerList.setItemChecked(0, true);
    }

    @Override
    public void deletePlayerFromList(int position) {
        lvPlayerListAdapter.remove(lvPlayerListAdapter.getItem(position));
        lvPlayerListAdapter.notifyDataSetChanged();
        presenter.checkIsEnoughPlayers();
    }

    @Override
    public void showStartContinueDialog() {
        AlertDialog startContinueDialog = new AlertDialog.Builder(this)
                .setTitle(R.string.dialog_start_continue_game_title)
                .setMessage(R.string.dialog_start_continue_game_message)
                .setPositiveButton(R.string.button_continue, (dialog, which) -> {
                    dialog.dismiss();
                })
                .setNegativeButton(R.string.button_start, (dialog, which) -> {
                    dialog.dismiss();
                })
                .create();
        startContinueDialog.show();
    }

    @Override
    public void showPlayerCounter() {
        FragmentTransaction ftrans = getSupportFragmentManager().beginTransaction();
        ftrans.replace(R.id.fragment_player, playerFragment).commit();
    }

    @Override
    public void showPlayerAddWarning() {
        FragmentTransaction ftrans = getSupportFragmentManager().beginTransaction();
        ftrans.replace(R.id.fragment_player, playerWarningFragment).commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add_new_player:
                showAddNewPlayerDialog();
                break;
            case R.id.btn_next_step:
                int position = lvPlayerList.getCheckedItemPosition();
                if (position == lvPlayerList.getCount() - 2) {
                    lvPlayerList.setItemChecked(0, true);
                    lvPlayerList.setSelection(0);
                    position = 0;
                } else {
                    position++;
                    lvPlayerList.setItemChecked(position, true);
                    lvPlayerList.setSelection(position);
                }
                playerFragment.loadPlayerScores(lvPlayerListAdapter.getItem(position), position);
                break;
        }
    }

    @Override
    public void onFinishEditDialog(String inputName) {
        presenter.addNewPlayer(inputName);
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setTitle(R.string.dialog_player_delete_title)
                .setMessage(R.string.dialog_player_delete_message)
                .setPositiveButton(R.string.button_yes, (dialog, which) -> {
                    presenter.deletePlayerListItem(position, lvPlayerListAdapter.getItem(position).getId());
                    presenter.checkIsEnoughPlayers();
                })
                .setNegativeButton(R.string.button_no, (dialog, which) -> {
                    dialog.dismiss();
                })
                .create();
        alertDialog.show();
        return true;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        lvPlayerList.setItemChecked(position, true);
        playerFragment.loadPlayerScores(lvPlayerListAdapter.getItem(position), position);
    }

    @Override
    public void onScoreChanged(Player player, int index) {
        presenter.updatePlayerListItem(player, index);
    }

}
