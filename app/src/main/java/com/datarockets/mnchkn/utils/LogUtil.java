package com.datarockets.mnchkn.utils;

public class LogUtil {
    public static final String LOG_PREFIX = "mnchkn ";
    public static final int LOG_PREFIX_LENGTH = LOG_PREFIX.length();
    public static final int MAX_LOG_TAG_LENGTH = 23;

    private LogUtil() {}

    public static String makeLogTag(String str) {
        if (str.length() > MAX_LOG_TAG_LENGTH - LOG_PREFIX_LENGTH) {
            return LOG_PREFIX + str.substring(0, MAX_LOG_TAG_LENGTH - LOG_PREFIX_LENGTH - 1);
        }
        return LOG_PREFIX + str;
    }

    public static String makeLogTag(Class cls) {
        return makeLogTag(cls.getSimpleName());
    }

}
