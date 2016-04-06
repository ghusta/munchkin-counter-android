package com.datarockets.mnchkn.utils;

import com.amulyakhare.textdrawable.util.ColorGenerator;

public class ColorUtil {

    public static String generatePlayerAvatarColor() {
        ColorGenerator generator = ColorGenerator.MATERIAL;
        int generatedColor = generator.getRandomColor();
        return "#" + Integer.toHexString(generatedColor).substring(2);
    }

}
