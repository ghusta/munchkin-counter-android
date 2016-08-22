package com.datarockets.mnchkn.store

import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color
import com.datarockets.mnchkn.MunchkinApplication
import com.datarockets.mnchkn.models.GameStep
import com.datarockets.mnchkn.models.Player
import lecho.lib.hellocharts.model.Line
import lecho.lib.hellocharts.model.LineChartData
import lecho.lib.hellocharts.model.PointValue
import java.util.*
import javax.inject.Inject

class GameServiceImpl(context: Context) : GameService {

    @Inject
    lateinit var mDatabase: MunchkinDatabaseHelper
    @Inject
    lateinit var mPreferences: SharedPreferences
    @Inject
    lateinit var mPreferencesEditor: SharedPreferences.Editor

    override var scoresChartData = mutableMapOf<Player, List<GameStep>>()
        private set

    init {
        MunchkinApplication.get(context).appComponent.inject(this)
    }

    override fun insertStep(player: Player) {
        val gameStep = GameStep(
                playerId = player.id,
                playerLevel = player.levelScore,
                playerStrength = player.strengthScore
        )
        mDatabase.insertStep(gameStep)
    }

    override fun createPlayerIdGameStepsMap() {
        val playersList = mDatabase.players
        val gameSteps = mDatabase.gameSteps

        val playerGameStepsMap = HashMap<Player, List<GameStep>>()
        for (player in playersList) {
            val playerSteps = ArrayList<GameStep>()
            for (step in gameSteps) {
                if (step.playerId == player.id) {
                    playerSteps.add(step)
                }
            }
            playerGameStepsMap.put(player, playerSteps)
        }
        scoresChartData = playerGameStepsMap
    }

    override fun createScoresChartData(type: Int, gameStepsMap: Map<Player, List<GameStep>>): LineChartData {
        val playersLines = ArrayList<Line>()
        val playerColors = ArrayList<String>()
        val lineChartData: LineChartData

        for (player in gameStepsMap.keys) {
            val color = player.color
            playerColors.add(color)
        }

        for (gameSteps in gameStepsMap.values) {
            val pointValues = ArrayList<PointValue>()
            for (i in gameSteps.indices) {
                when (type) {
                    0 -> {
                        val playerLevel = gameSteps[i].playerLevel
                        pointValues.add(PointValue(i.toFloat(), playerLevel.toFloat()))
                    }
                    1 -> {
                        val playerStrength = gameSteps[i].playerStrength
                        pointValues.add(PointValue(i.toFloat(), playerStrength.toFloat()))
                    }
                    2 -> {
                        val playerTotal = gameSteps[i].playerLevel + gameSteps[i].playerStrength
                        pointValues.add(PointValue(i.toFloat(), playerTotal.toFloat()))
                    }
                }
            }
            val line = Line()
            line.values = pointValues
            line.setHasPoints(false)
            line.isCubic = true
            playersLines.add(line)
        }

        for (i in playersLines.indices) {
            playersLines[i].color = Color.parseColor(playerColors[i])
        }

        lineChartData = LineChartData(playersLines)

        return lineChartData
    }

    override fun clearSteps() {
        mDatabase.clearSteps()
    }

    override fun setGameStatus(status: Boolean) {
        mPreferencesEditor = mPreferences.edit()
        mPreferencesEditor.putBoolean(IS_GAME_STARTED, status)
        mPreferencesEditor.apply()
    }

    override val isGameStarted: Boolean
        get() = mPreferences.getBoolean(IS_GAME_STARTED, false)

    companion object {

        private val IS_GAME_STARTED = "is_game_started"
    }

}
