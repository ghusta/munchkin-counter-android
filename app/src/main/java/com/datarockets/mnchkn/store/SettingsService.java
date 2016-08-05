package com.datarockets.mnchkn.store;

public interface SettingsService {
    boolean checkIsUserSeenOnboarding();
    void setOnboardingSeen();
    boolean isWakeLockActive();
    void setWakeLock(boolean isActive);
}
