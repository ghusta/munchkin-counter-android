package com.datarockets.mnchkn.store;

import com.datarockets.mnchkn.models.Player;

import java.util.ArrayList;
import java.util.List;

public interface PlayerService {
    /**
     * An action to add a new player to the list
     *
     * @param name - the name of the player
     * @return Updated players list
     */
    ArrayList<Player> addPlayer(String name);

    /**
     * An action to delete player
     *
     * @param index - position of the player in the list
     * @return Updated players list
     */
    ArrayList<Player> deletePlayer(int index);
    List<Player> getPlayersList();
}
