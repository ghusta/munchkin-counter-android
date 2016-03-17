package com.datarockets.mnchkn.utils;

import android.util.Log;

public class LogUtil {
    public static final String LOG_PREFIX = "mnchkn ";
    public static final int LOG_PREFIX_LENGTH = LOG_PREFIX.length();
    public static final int MAX_LOG_TAG_LENGTH = 23;

    public static boolean LOGGING_ENABLED = true;

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

    public static void LOGD(String tag, String message) {
        if (LOGGING_ENABLED) {
            if (Log.isLoggable(tag, Log.DEBUG)) {
                Log.d(tag, message);
            }
        }
    }

    public static void LOGE(String tag, String message) {
        if (LOGGING_ENABLED) {
            if (Log.isLoggable(tag, Log.ERROR)) {
                Log.e(tag, message);
            }
        }
    }

    public static void LOGV(String tag, String message) {
        if (LOGGING_ENABLED) {
            if (Log.isLoggable(tag, Log.VERBOSE)) {
                Log.v(tag, message);
            }
        }
    }

}
