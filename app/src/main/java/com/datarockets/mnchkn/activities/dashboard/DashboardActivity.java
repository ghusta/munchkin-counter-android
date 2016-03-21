package com.datarockets.mnchkn.activities.dashboard;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
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
import java.util.List;

public class DashboardActivity extends AppCompatActivity implements DashboardView,
        View.OnClickListener, Dialog.OnClickListener, View.OnLongClickListener, AddNewPlayerFragment.AddNewPlayerDialogInterface{

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
        rvPlayerListAdapter = new PlayerListAdapter(this, new ArrayList<>());
        rvPlayerList.setOnLongClickListener(this);
        rvPlayerList.setAdapter(rvPlayerListAdapter);
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
    public void setItems(List<Player> players) {
        rvPlayerListAdapter.notifyDataSetChanged();
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
                .setPositiveButton(R.string.button_yes, this)
                .setNegativeButton(R.string.button_no, this);
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
    public void onClick(DialogInterface dialog, int which) {
        switch (which) {
            case Dialog.BUTTON_POSITIVE:
                finishGame();
                break;
            case Dialog.BUTTON_NEGATIVE:
                break;
            default:
                break;
        }
    }

    @Override
    public boolean onLongClick(View v) {
        return true;
    }


    @Override
    public void onFinishEditDialog(String inputName) {
    }


}
