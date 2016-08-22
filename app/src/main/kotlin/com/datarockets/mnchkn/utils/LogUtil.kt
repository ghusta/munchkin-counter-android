package com.datarockets.mnchkn.utils

import kotlin.reflect.KClass

object LogUtil {

    val LOG_PREFIX = "mnchkn "
    val LOG_PREFIX_LENGTH = LOG_PREFIX.length
    val MAX_LOG_TAG_LENGTH = 23

    fun makeLogTag(str: String): String {
        if (str.length > MAX_LOG_TAG_LENGTH - LOG_PREFIX_LENGTH) {
            return LOG_PREFIX + str.substring(0, MAX_LOG_TAG_LENGTH - LOG_PREFIX_LENGTH - 1)
        }
        return LOG_PREFIX + str
    }

    fun makeLogTag(cls: KClass<*>): String {
        return makeLogTag(cls.simpleName!!)
    }

}
