package com.datarockets.mnchkn.data

import com.datarockets.mnchkn.data.local.DatabaseHelper
import com.datarockets.mnchkn.data.local.Db
import com.datarockets.mnchkn.data.local.PreferenceHelper
import com.datarockets.mnchkn.data.model.GameStep
import com.datarockets.mnchkn.data.model.Player
import com.datarockets.mnchkn.utils.ColorUtil
import lecho.lib.hellocharts.model.LineChartData
import lecho.lib.hellocharts.model.PointValue
import rx.Observable
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
open class DataManager
@Inject constructor(private val mDatabaseHelper: DatabaseHelper,
                    private val mPreferenceHelper: PreferenceHelper) {

    fun getPreferenceHelper(): PreferenceHelper = mPreferenceHelper

    fun getPlayers(): Observable<ArrayList<Player>> {
        return mDatabaseHelper.getPlayers(Db.PlayersTable.ORDER_BY_ID)
    }

    fun addPlayer(name: String): Observable<Player> {
        val player = Player(
                id = 0,
                name = name,
                levelScore = 1,
                strengthScore = 1,
                totalScore = 0,
                color = ColorUtil.generatePlayerAvatarColor()
        )
        return mDatabaseHelper.addPlayer(player)
    }

    fun deletePlayer(id: Long): Observable<Void> = mDatabaseHelper.deletePlayer(id)

    fun updatePlayer(player: Player): Observable<Player> = mDatabaseHelper.updatePlayer(player)

    fun insertStep(player: Player): Observable<Void> {
        val gameStep = GameStep(
                playerId = player.id,
                playerLevel = player.levelScore,
                playerStrength = player.strengthScore
        )
        return mDatabaseHelper.insertStep(gameStep)
    }

    fun clearSteps(): Observable<Void> {
        return mDatabaseHelper.clearSteps()
    }

    fun clearPlayersStats(): Observable<Void> {
        return mDatabaseHelper.clearPlayersStats()
    }

    fun createScoresChartData(type: Int): Observable<LineChartData> {
        return Observable.create {  }

//        val playersLines = ArrayList<Line>()
//        val playerColors = ArrayList<String>()
//        val lineChartData: LineChartData
//
//        // First loop
//        for (player in gameStepsMap.keys) {
//            val color = player.color
//            playerColors.add(color)
//        }
//
//        // Second loop
//        for (gameSteps in gameStepsMap.values) {
//            val pointValues = ArrayList<PointValue>()
//
//
//            // Third loop
//            for (i in gameSteps.indices) {
//                when (type) {
//                    0 -> {
//                        val playerLevel = gameSteps[i].playerLevel
//                        pointValues.add(PointValue(i.toFloat(), playerLevel.toFloat()))
//                    }
//                    1 -> {
//                        val playerStrength = gameSteps[i].playerStrength
//                        pointValues.add(PointValue(i.toFloat(), playerStrength.toFloat()))
//                    }
//                    2 -> {
//                        val playerTotal = gameSteps[i].playerLevel + gameSteps[i].playerStrength
//                        pointValues.add(PointValue(i.toFloat(), playerTotal.toFloat()))
//                    }
//                }
//            }
//            val line = Line()
//            line.apply {
//                values = pointValues
//                setHasPoints(false)
//                isCubic = true
//            }
//            playersLines.add(line)
//        }
//
//        // Fifth Loop
//        for (i in playersLines.indices) {
//            playersLines[i].color = Color.parseColor(playerColors[i])
//        }

    }

}