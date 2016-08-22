package com.datarockets.mnchkn.store

import com.datarockets.mnchkn.models.Player
import java.util.*

interface PlayerService {
    /**
     * An action to add a new player to the list

     * @param name - the name of the player
     * *
     * @return Updated players list
     */
    fun addPlayer(name: String): Player

    /**
     * An action to delete player

     * @param position - position of the player in the list
     * *
     * @param id - id of the player in the database
     * *
     * @return Return position of the player the list which should be deleted
     */
    fun deletePlayer(position: Int, id: Long): Int

    /**
     * An action to update player in the list

     * @param player - updated player
     * *
     * @return Updated player item to list
     */
    fun updatePlayer(player: Player): Player

    /**
     * An action to clear players stats

     */
    fun clearPlayersStats()

    val playersList: ArrayList<Player>
    /**
     * An action to get players by id, score, strength or total sum of scores

     * @param orderValue - type of data to sort
     * *
     * @return players list
     */
    fun getPlayersList(orderValue: Int): ArrayList<Player>

}
