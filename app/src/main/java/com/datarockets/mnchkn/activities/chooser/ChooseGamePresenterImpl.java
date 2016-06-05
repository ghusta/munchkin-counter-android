package com.datarockets.mnchkn.activities.chooser;

public class ChooseGamePresenterImpl implements ChooseGamePresenter {

    private ChooseGameView mChooseGameView;
    private ChooseGameInteractor mInteractor;

    public ChooseGamePresenterImpl(ChooseGameView chooseGameView) {
        this.mChooseGameView = chooseGameView;
        this.mInteractor = new ChooseGameInteractorImpl();
    }

    @Override
    public void onResume() {
    }

    @Override
    public void onDestroy() {
        if (mChooseGameView != null) {
            mChooseGameView = null;
        }
    }

}
