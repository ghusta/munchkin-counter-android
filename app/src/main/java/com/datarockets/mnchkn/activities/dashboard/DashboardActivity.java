package com.datarockets.mnchkn.activities.dashboard;

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
import android.widget.Button;
import android.widget.ListView;

import com.datarockets.mnchkn.R;
import com.datarockets.mnchkn.activities.result.GameResultActivity;
import com.datarockets.mnchkn.activities.settings.SettingsActivity;
import com.datarockets.mnchkn.adapters.PlayerListAdapter;
import com.datarockets.mnchkn.fragments.dialogs.AddNewPlayerFragment;
import com.datarockets.mnchkn.fragments.dialogs.DiceRollResultFragment;
import com.datarockets.mnchkn.models.Player;
import com.datarockets.mnchkn.utils.LogUtil;

import java.util.ArrayList;

public class DashboardActivity extends AppCompatActivity implements DashboardView,
        View.OnClickListener, AdapterView.OnItemLongClickListener,
        AdapterView.OnItemClickListener, AddNewPlayerFragment.AddNewPlayerDialogInterface{

    public static final String TAG = LogUtil.makeLogTag(DashboardActivity.class);

    DashboardPresenter presenter;
    Toolbar toolbar;
    FloatingActionButton fabDiceRoll;
    ListView rvPlayerList;
    PlayerListAdapter rvPlayerListAdapter;
    Button btnNextStep;
    DiceRollResultFragment diceRollResultFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new DashboardPresenterImpl(this);
        setContentView(R.layout.activity_dashboard);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        fabDiceRoll = (FloatingActionButton) findViewById(R.id.fab_dice_roll);
        fabDiceRoll.setOnClickListener(this);
        btnNextStep = (Button) findViewById(R.id.btn_next_step);
        rvPlayerList = (ListView) findViewById(R.id.rv_player_list);
        rvPlayerList.setOnItemClickListener(this);
        rvPlayerList.setOnItemLongClickListener(this);
        rvPlayerList.setAdapter(rvPlayerListAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.drawer, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_finish_game:
                showConfirmFinishGameDialog();
                break;
            case R.id.item_settings:
                openSettingsActivity();
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void showDiceRollResultDialog() {
        diceRollResultFragment = new DiceRollResultFragment();
        diceRollResultFragment.show(getSupportFragmentManager(), TAG);
    }

    @Override
    public void finishGame() {
        Intent intent = new Intent(this, GameResultActivity.class);
        startActivity(intent);
    }

    @Override
    public void setItems(ArrayList<Player> players) {
        rvPlayerList.setAdapter(new PlayerListAdapter(this, players));
    }

    @Override
    public void openSettingsActivity() {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }

    @Override
    public void showConfirmFinishGameDialog() {
        AlertDialog.Builder confirmFinishGameDialog = new AlertDialog.Builder(this)
                .setTitle(R.string.dialog_finish_game_title)
                .setMessage(R.string.dialog_finish_game_message)
                .setPositiveButton(R.string.button_yes, (dialog, which) -> {
                    finishGame();
                })
                .setNegativeButton(R.string.button_no, (dialog, which) -> {
                    dialog.dismiss();
                });
        confirmFinishGameDialog.create().show();
    }

    @Override
    public void showAddNewPlayerDialog() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        AddNewPlayerFragment addNewPlayerFragment = AddNewPlayerFragment.newInstance("");
        addNewPlayerFragment.show(fragmentManager, TAG);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fab_dice_roll:
                showDiceRollResultDialog();
                break;
            case R.id.btn_add_new_player:
                showAddNewPlayerDialog();
                break;
            default:
                break;
        }
    }

    @Override
    public void onFinishEditDialog(String inputName) {
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setTitle(R.string.dialog_player_delete_title)
                .setMessage(R.string.dialog_player_delete_message)
                .setPositiveButton(R.string.button_yes, (dialog, which) -> {
                    presenter.deletePlayerListItem(position);
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

    }

}
