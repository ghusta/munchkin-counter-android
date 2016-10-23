package com.datarockets.mnchkn.ui.players

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import butterknife.BindView
import butterknife.ButterKnife
import com.datarockets.mnchkn.R
import com.datarockets.mnchkn.data.model.Player
import com.datarockets.mnchkn.ui.base.BaseActivity
import com.datarockets.mnchkn.views.fonts.MunchkinTextView
import javax.inject.Inject

class PlayerFragment : Fragment(), PlayerView, View.OnClickListener {

    private var mPlayerPosition: Int = 0
    lateinit var mPlayer: Player

    @Inject lateinit var presenter: PlayerPresenterImpl
    lateinit var currentPlayerView: View
    @BindView(R.id.btn_level_score_up) lateinit var btnLevelScoreUp: ImageButton
    @BindView(R.id.btn_level_score_down) lateinit var btnLevelScoreDown: ImageButton
    @BindView(R.id.btn_strength_score_up) lateinit var btnStrengthScoreUp: ImageButton
    @BindView(R.id.btn_strength_score_down) lateinit var btnStrengthScoreDown: ImageButton
    @BindView(R.id.tv_player_name) lateinit var tvPlayerName: MunchkinTextView
    @BindView(R.id.tv_level_score) lateinit var tvLevelScore: MunchkinTextView
    @BindView(R.id.tv_strength_score) lateinit var tvStrengthScore: MunchkinTextView
    lateinit var callback: PlayerFragmentCallback

    interface PlayerFragmentCallback {
        fun onScoreChanged(player: Player, index: Int)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        callback = activity as PlayerFragmentCallback
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, bundle: Bundle?): View? {
        (activity as BaseActivity).activityComponent().inject(this)
        currentPlayerView = inflater!!.inflate(R.layout.fragment_player, container, false)
        ButterKnife.bind(this, currentPlayerView)
        btnLevelScoreUp.setOnClickListener(this)
        btnLevelScoreDown.setOnClickListener(this)
        btnStrengthScoreUp.setOnClickListener(this)
        btnStrengthScoreDown.setOnClickListener(this)
        return currentPlayerView
    }

    override fun onClick(v: View) {
        val currentLevel = Integer.parseInt(tvLevelScore.text.toString())
        val currentStrength = Integer.parseInt(tvStrengthScore.text.toString())
        when (v.id) {
            R.id.btn_level_score_up -> presenter.increaseLevelScore(currentLevel)
            R.id.btn_level_score_down -> presenter.decreaseLevelScore(currentLevel)
            R.id.btn_strength_score_up -> presenter.increaseStrengthScore(currentStrength)
            R.id.btn_strength_score_down -> presenter.decreaseStrengthScore(currentStrength)
            else -> {
            }
        }
        mPlayer.strengthScore = Integer.parseInt(tvStrengthScore.text.toString())
        mPlayer.levelScore = Integer.parseInt(tvLevelScore.text.toString())
        callback.onScoreChanged(mPlayer, mPlayerPosition)
    }

    fun loadPlayerScores(player: Player, index: Int) {
        this.mPlayer = player
        this.mPlayerPosition = index
        tvPlayerName.text = player.name
        tvLevelScore.text = player.levelScore.toString()
        tvStrengthScore.text = player.strengthScore.toString()
    }

    override fun setLevelScore(score: String) {
        tvLevelScore.text = score
    }

    override fun setStrengthScore(score: String) {
        tvStrengthScore.text = score
    }

}
