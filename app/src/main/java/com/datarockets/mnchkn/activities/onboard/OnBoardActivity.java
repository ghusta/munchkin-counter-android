package com.datarockets.mnchkn.activities.onboard;

import android.animation.ArgbEvaluator;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.datarockets.mnchkn.R;
import com.datarockets.mnchkn.adapters.OnBoardPagerAdapter;
import com.datarockets.mnchkn.utils.LogUtil;

public class OnBoardActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener, View.OnClickListener {

    public static final String TAG = LogUtil.makeLogTag(OnBoardActivity.class);

    OnBoardPagerAdapter onBoardPagerAdapter;
    ViewPager vpOnBoard;
    ImageButton ibNext;
    Button btnSkip, btnFinish;
    ImageView ivZero, ivOne, ivTwo;
    ImageView[] indicators;
    int lastLeftValue = 0;
    int page = 0;
    CoordinatorLayout coordinatorLayout;
    ArgbEvaluator evaluator;
    int[] colorList;
    int color1;
    int color2;
    int color3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.black_transparent));
        }

        setContentView(R.layout.activity_onboard);
        onBoardPagerAdapter = new OnBoardPagerAdapter(getSupportFragmentManager());
        ibNext = (ImageButton) findViewById(R.id.ib_next);
        btnSkip = (Button) findViewById(R.id.btn_skip);
        btnFinish = (Button) findViewById(R.id.btn_finish);
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.cl_main_content);
        ivZero = (ImageView) findViewById(R.id.intro_indicator_0);
        ivOne = (ImageView) findViewById(R.id.intro_indicator_1);
        ivTwo = (ImageView) findViewById(R.id.intro_indicator_2);
        indicators = new ImageView[] {ivZero, ivOne, ivTwo};
        vpOnBoard = (ViewPager) findViewById(R.id.vp_onboard);
        vpOnBoard.setAdapter(onBoardPagerAdapter);
        vpOnBoard.setCurrentItem(0);
        updateIndicators(page);
        vpOnBoard.addOnPageChangeListener(this);

        color1 = ContextCompat.getColor(this, R.color.card_corner);
        color2 = ContextCompat.getColor(this, R.color.card_background);
        color3 = ContextCompat.getColor(this, R.color.card_light);


        colorList = new int[] {color1, color2, color3};

        evaluator = new ArgbEvaluator();

        ibNext.setOnClickListener(this);
        btnSkip.setOnClickListener(this);
        btnFinish.setOnClickListener(this);

    }

    private void updateIndicators(int position) {
        for (int i = 0; i < indicators.length; i++) {
            indicators[i].setBackgroundResource(i == position ? R.drawable.indicator_selected : R.drawable.indicator_unselected);
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        int colorUpdate = (Integer) evaluator.evaluate(positionOffset, colorList[position], colorList[position == 2 ? position : position + 1]);
        vpOnBoard.setBackgroundColor(colorUpdate);
    }

    @Override
    public void onPageSelected(int position) {
        page = position;
        updateIndicators(page);
        switch (position) {
            case 0:
                vpOnBoard.setBackgroundColor(color1);
                break;
            case 1:
                vpOnBoard.setBackgroundColor(color2);
                break;
            case 2:
                vpOnBoard.setBackgroundColor(color3);
                break;
        }

        ibNext.setVisibility(position == 2 ? View.GONE : View.VISIBLE);
        btnFinish.setVisibility(position == 2 ? View.VISIBLE : View.GONE);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ib_next:
                page += 1;
                vpOnBoard.setCurrentItem(page, true);
                break;
            case R.id.btn_skip:
                finish();
                break;
            case R.id.btn_finish:
                finish();
                break;
        }
    }

}
