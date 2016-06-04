package com.datarockets.mnchkn.views.fonts;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;

import com.datarockets.mnchkn.utils.LogUtil;

import java.util.HashMap;

public class FontCache {

    private static final String TAG = LogUtil.makeLogTag(FontCache.class);

    private static HashMap<String, Typeface> fontNameTypefaceMap = new HashMap<>();

    public static Typeface getTypeface(String fontName, Context context) {
        Typeface typeface = fontNameTypefaceMap.get(fontName);
        if (typeface == null) {
            try {
                typeface = Typeface.createFromAsset(context.getAssets(), fontName);
            } catch (Exception e) {
                Log.e(TAG, "Error while trying to get typeface");
            }
            fontNameTypefaceMap.put(fontName, typeface);
        }
        return typeface;
    }

}
