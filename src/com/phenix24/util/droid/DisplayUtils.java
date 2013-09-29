package com.phenix24.util.droid;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

public class DisplayUtils {

    /**
     * Get the absolute width of the display in pixels.
     * 
     * @param context
     * @return width in pixels
     */
    public static int getWidth(Context context) {
        DisplayMetrics displayMetr = getDisplayMetrics(context);
        return displayMetr.widthPixels;
    }

    /**
     * Get the absolute height of the display in pixels.
     * 
     * @param context
     * @return height in pixels
     */
    public static int getHeight(Context context) {
        DisplayMetrics displayMetr = getDisplayMetrics(context);
        return displayMetr.heightPixels;
    }

    /**
     * Get the logical density of the display.
     * 
     * @param context
     * @return density of the display
     */
    public static float getDensity(Context context) {
        DisplayMetrics displayMetr = getDisplayMetrics(context);
        return displayMetr.density;
    }

    /**
     * Get the screen density expressed as dots-per-inch
     * 
     * @param context
     * @return the screen density
     */
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
