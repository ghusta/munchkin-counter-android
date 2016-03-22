package com.datarockets.mnchkn.store;

import com.datarockets.mnchkn.models.Player;

import java.util.ArrayList;
import java.util.List;

public interface PlayerService {
    void addPlayer(String name);
    ArrayList<Player> deletePlayer(int index);
    List<Player> getPlayersList();
}
