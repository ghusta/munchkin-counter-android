package com.datarockets.mnchkn.activities.chooser;

public class ChooseGamePresenterImpl implements ChooseGamePresenter{

    private ChooseGameView chooseGameView;
    private ChooseGameInteractorImpl interactor;

    public ChooseGamePresenterImpl(ChooseGameView chooseGameView) {
        this.chooseGameView = chooseGameView;
        this.interactor = new ChooseGameInteractorImpl();
    }

    @Override
    public void onResume() {
        if (chooseGameView != null) {
        }
    }

    @Override
    public void onDestroy() {
        if (chooseGameView != null) {
            chooseGameView = null;
        }
    }

}
