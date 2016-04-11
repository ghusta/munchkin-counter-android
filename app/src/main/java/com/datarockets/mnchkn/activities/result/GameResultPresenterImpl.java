package com.datarockets.mnchkn.activities.result;

public class GameResultPresenterImpl implements GameResultPresenter {

    GameResultView gameResultView;
    GameResultInteractorImpl interactor;

    public GameResultPresenterImpl(GameResultView gameResultView) {
        this.gameResultView = gameResultView;
        this.interactor = new GameResultInteractorImpl();
    }

    @Override
    public void loadPlayersStats(int type) {
        if (gameResultView != null) {
        }
    }

    @Override
    public void onResume() {
        if (gameResultView != null) {
        }
    }

    @Override
    public void onDestroy() {
        if (gameResultView != null) {
            gameResultView = null;
        }
    }

}
