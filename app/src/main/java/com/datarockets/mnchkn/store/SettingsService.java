package com.datarockets.mnchkn.store;

public interface SettingsService {
    boolean checkIsUserSeenOnboarding();
    void setOnboardingSeen();
}
