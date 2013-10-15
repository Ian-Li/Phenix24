package com.phenix24.util.droid;

import android.test.InstrumentationTestCase;
import android.util.Log;

public class BuildUtilsTest extends InstrumentationTestCase {

    private static final String TAG = "BuildUtilsTest";

    @Override
    protected void setUp() throws Exception {
        super.setUp();
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
}
