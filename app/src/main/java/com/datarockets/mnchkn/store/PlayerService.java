package com.datarockets.mnchkn.store;

import com.datarockets.mnchkn.models.Player;

import java.util.List;

public interface PlayerService {
    void addPlayer(String name);
    void deletePlayer(int index);
    List<Player> getPlayersList();
}
