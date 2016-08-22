package com.datarockets.mnchkn.store

import android.content.Context
import com.datarockets.mnchkn.MunchkinApplication
import com.datarockets.mnchkn.models.Player
import com.datarockets.mnchkn.utils.ColorUtil
import com.datarockets.mnchkn.utils.LogUtil
import java.util.*
import javax.inject.Inject

class PlayerServiceImpl(context: Context) : PlayerService {

    @Inject
    lateinit var mPlayerDatabase: MunchkinDatabaseHelper

    init {
        MunchkinApplication.get(context).appComponent.inject(this)
    }

    override fun addPlayer(name: String): Player {
        val player = Player(id = 0, totalScore = 0, name = name, levelScore = 1, strengthScore = 1, color = ColorUtil.generatePlayerAvatarColor())
        val id = mPlayerDatabase.addPlayer(player)
        player.id = id
        return player
    }

    override fun deletePlayer(position: Int, id: Long): Int {
        mPlayerDatabase.deletePlayer(id)
        return position
    }

    override fun updatePlayer(player: Player): Player {
        return mPlayerDatabase.updatePlayer(player)
    }

    override fun clearPlayersStats() {
        mPlayerDatabase.clearPlayersStats()
    }

    override val playersList: ArrayList<Player>
        get() = mPlayerDatabase.players

    override fun getPlayersList(orderValue: Int): ArrayList<Player> {
        return mPlayerDatabase.getPlayers(orderValue)
    }

    companion object {

        val TAG = LogUtil.makeLogTag(PlayerServiceImpl::class)
    }

}
