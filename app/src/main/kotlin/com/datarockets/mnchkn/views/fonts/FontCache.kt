package com.datarockets.mnchkn.views.fonts

import android.content.Context
import android.graphics.Typeface
import android.util.Log
import com.datarockets.mnchkn.utils.LogUtil

object FontCache {

    private val TAG = LogUtil.makeLogTag(FontCache::class)

    private val fontNameTypefaceMap = mutableMapOf<String, Typeface>()

    fun getTypeface(fontName: String, context: Context): Typeface {
        var typeface: Typeface? = fontNameTypefaceMap[fontName]
        if (typeface == null) {
            try {
                typeface = Typeface.createFromAsset(context.assets, fontName)
            } catch (e: Exception) {
                Log.e(TAG, "Error while trying to get typeface")
            }
            fontNameTypefaceMap.put(fontName, typeface!!)

        }
        return typeface
    }

}
