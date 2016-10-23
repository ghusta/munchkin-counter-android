package com.datarockets.mnchkn.ui.onboard

import android.content.Intent
import android.os.Bundle
import com.chyrta.onboarder.OnboarderActivity
import com.chyrta.onboarder.OnboarderPage
import com.datarockets.mnchkn.MunchkinApplication
import com.datarockets.mnchkn.R
import com.datarockets.mnchkn.data.DataManager
import com.datarockets.mnchkn.injection.component.ActivityComponent
import com.datarockets.mnchkn.injection.component.DaggerActivityComponent
import com.datarockets.mnchkn.injection.module.ActivityModule
import com.datarockets.mnchkn.ui.base.BaseActivity
import com.datarockets.mnchkn.ui.playerslist.PlayersListActivity
import java.util.*
import javax.inject.Inject

class OnboardActivity : OnboarderActivity(), OnboardView {

    private var mActivityComponent: ActivityComponent? = null

    @Inject lateinit var presenter: OnboardPresenter
    lateinit var onboarderPages: MutableList<OnboarderPage>
    lateinit var onboarderPageOne: OnboarderPage
    lateinit var onboarderPageTwo: OnboarderPage
    lateinit var onboarderPageThree: OnboarderPage

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityComponent().inject(this)
        presenter.attachView(this)

        presenter.checkIsUserSeenOnboarding()
        onboarderPages = ArrayList<OnboarderPage>()
        onboarderPageOne = OnboarderPage(
                R.string.onboarder_page1_title,
                R.string.onboarder_page1_description,
                R.drawable.ic_munchkin)
        onboarderPageOne.setBackgroundColor(R.color.card_general)
        onboarderPageTwo = OnboarderPage(
                R.string.onboarder_page2_title,
                R.string.onboarder_page2_description,
                R.drawable.ic_infinite)
        onboarderPageTwo.setBackgroundColor(R.color.card_light)
        onboarderPageThree = OnboarderPage(
                R.string.onboarder_page3_title,
                R.string.onboarder_page3_description,
                R.drawable.ic_dice)
        onboarderPageThree.setBackgroundColor(R.color.card_corner)
        onboarderPages.add(onboarderPageOne)
        onboarderPages.add(onboarderPageTwo)
        onboarderPages.add(onboarderPageThree)
        setOnboardPagesReady(onboarderPages)

    }

    public override fun onSkipButtonPressed() {
        super.onSkipButtonPressed()
    }

    override fun onFinishButtonPressed() {
        openPlayersActivity()
    }

    override fun openPlayersActivity() {
        presenter.setOnboardingSeen()
        val intent = Intent(this, PlayersListActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun activityComponent() : ActivityComponent {
        if (mActivityComponent == null) {
            mActivityComponent = DaggerActivityComponent.builder()
                    .activityModule(ActivityModule(this))
                    .applicationComponent(MunchkinApplication.get(this).getComponent())
                    .build()
        }
        return mActivityComponent!!
    }

    override fun onDestroy() {
        presenter.detachView()
        super.onDestroy()
    }

}
