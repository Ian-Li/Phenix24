package com.phenix24.util.droid;

import android.os.Build;
import android.test.InstrumentationTestCase;
import android.util.Log;

public class BuildUtilsTest extends InstrumentationTestCase {

    private static final String TAG = "BuildUtilsTest";

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    public void test_build() {
        Log.i(TAG, "----test_build----");
        String build = "BOARD:" + Build.BOARD + "\n" + "BOOTLOADER:" + Build.BOOTLOADER
                + "\n" + "BRAND:" + Build.BRAND + "\n" + "CPU_ABI:" + Build.CPU_ABI
                + "\n" + "CPU_ABI2:" + Build.CPU_ABI2 + "\n" + "DEVICE:" + Build.DEVICE
                + "\n" + "DISPLAY:" + Build.DEVICE + "\n" + "FINGERPRINT:"
                + Build.FINGERPRINT + "\n" + "HARDWARE:" + Build.HARDWARE + "\n"
                + "HOST:" + Build.HOST + "\n" + "ID:" + Build.ID + "\n" + "MANUFACTURER:"
                + Build.MANUFACTURER + "\n" + "MODEL:" + Build.MODEL + "\n" + "PRODUCT:"
                + Build.PRODUCT + "\n" + "RADIO:" + Build.RADIO + "\n" + "SERIAL:"
                + Build.SERIAL + "\n" + "TAGS:" + Build.TAGS + "\n" + "TIME:"
                + Build.TIME + "\n" + "TYPE:" + Build.TYPE + "\n" + "USER:" + Build.USER
                + "\n" + "Build.VERSION.CODENAME:" + Build.VERSION.CODENAME + "\n"
                + "Build.VERSION.INCREMENTAL:" + Build.VERSION.INCREMENTAL + "\n"
                + "Build.VERSION.RELEASE:" + Build.VERSION.RELEASE + "\n"
                + "Build.VERSION.SDK_INT:" + Build.VERSION.SDK_INT;
        Log.i(TAG, build);
    }

    public void test_getFingerprint() {
        Log.i(TAG, "----test_getFingerprint----");
        String fingerprint = BuildUtils.getFingerprint();
        Log.i(TAG, "fingerprint:" + fingerprint);
    }

    public void test_getManufacturer() {
        Log.i(TAG, "----test_getManufacturer----");
        String manufacturer = BuildUtils.getManufacturer();
        Log.i(TAG, "manufacturer:" + manufacturer);
    }

    public void test_getModel() {
        Log.i(TAG, "----test_getModel----");
        String model = BuildUtils.getModel();
        Log.i(TAG, "model:" + model);
    }

    public void test_getSerial() {
        Log.i(TAG, "----test_getSerial----");
        String serial = BuildUtils.getSerial();
        Log.i(TAG, "serial:" + serial);
    }

    public void test_getVersionRelease() {
        Log.i(TAG, "----test_getVersionRelease----");
        String versionRelease = BuildUtils.getVersionRelease();
        Log.i(TAG, "versionRelease:" + versionRelease);
    }

    public void test_getVersionSDK() {
        Log.i(TAG, "----getVersionSDK----");
        int versionSDK = BuildUtils.getVersionSDK();
        Log.i(TAG, "versionSDK:" + versionSDK);
    }
}
