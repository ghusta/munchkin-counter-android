package com.datarockets.mnchkn.activities.welcome;

public class WelcomePresenterImpl implements WelcomePresenter {

    private WelcomeView welcomeView;
    private WelcomeInteractor welcomeInteractor;

    public WelcomePresenterImpl(WelcomeView welcomeView) {
        this.welcomeView = welcomeView;
        this.welcomeInteractor = new WelcomeInteractorImpl();
    }

    @Override
    public boolean validateCredentials(String username, String password) {
        return !(username.length() == 0 || password.length() == 0);
    }

}
