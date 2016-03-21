package com.datarockets.mnchkn.activities.welcome;

public interface WelcomePresenter {
    void onDestroy();
    boolean validateCredentials(String username, String password);
}
