package com.phenix24.util.droid;

public class SystemUtils {

    private static long lastClickTime = 0;

    /**
     * Check if user click "Button" fast.
     * 
     * @return true,fast click;otherwise false.
     */
    public static boolean isFastClick() {
        long currentTime = System.currentTimeMillis();
        long timeDelta = currentTime - lastClickTime;
        if (timeDelta > 0 && timeDelta < 500) {
            return true;
        }

        lastClickTime = currentTime;
        return false;
    }
}
