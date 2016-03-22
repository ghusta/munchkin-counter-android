package com.datarockets.mnchkn.views.fonts;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class MunchkinTextView extends TextView {

    public static final String FONT_NAME = "buccaner.ttf";

    public MunchkinTextView(Context context) {
        super(context);
        init(context);
    }

    public MunchkinTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public MunchkinTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    private void init(Context context) {
        Typeface munchkinFont = FontCache.getTypeface(FONT_NAME, context);
        setTypeface(munchkinFont);
    }


}
