package com.phenix24.util.droid;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

public class DisplayUtils {

    public static int getWidth(Context context) {
        DisplayMetrics displayMetr = getDisplayMetrics(context);
        return displayMetr.widthPixels;
    }

    public static int getHeight(Context context) {
        DisplayMetrics displayMetr = getDisplayMetrics(context);
        return displayMetr.heightPixels;
    }

    public static float getDensity(Context context) {
        DisplayMetrics displayMetr = getDisplayMetrics(context);
        return displayMetr.density;
    }

    public static int getDensityDPI(Context context) {
        DisplayMetrics displayMetr = getDisplayMetrics(context);
        return displayMetr.densityDpi;
    }

    private static DisplayMetrics getDisplayMetrics(Context context) {
        WindowManager windowMng = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        Display display = windowMng.getDefaultDisplay();

        DisplayMetrics displayMetr = new DisplayMetrics();
        display.getMetrics(displayMetr);
        return displayMetr;
    }
}
