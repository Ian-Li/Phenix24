package com.phenix24.util.droid;

import android.os.Build;

public class BuildUtils {

    /**
     * @return A string that uniquely identifies this build.
     */
    public static String getFingerprint() {
        return Build.FINGERPRINT;
    }

    /**
     * @return The manufacturer of the product/hardware.
     */
    public static String getManufacturer() {
        return Build.MANUFACTURER;
    }

    /**
     * @return The end-user-visible name for the end product.
     */
    public static String getModel() {
        return Build.MODEL;
    }

    /**
     * @return A hardware serial number, if available. Alphanumeric only,
     *         case-insensitive.
     */
    public static String getSerial() {
        return Build.SERIAL;
    }

    /**
     * @return The user-visible android version string.
     */
    public static String getVersionRelease() {
        return Build.VERSION.RELEASE;
    }

    /**
     * @return The user-visible SDK version of the framework.
     */
    public static int getVersionSDK() {
        return Build.VERSION.SDK_INT;
    }
}
