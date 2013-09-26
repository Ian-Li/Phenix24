package com.phenix24.util.droid;

import android.content.Context;
import android.test.InstrumentationTestCase;
import android.util.Log;

public class PackageUtilsTest extends InstrumentationTestCase {

    private static final String TAG = "PackageUtilsTest";

    private Context context;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        context = getInstrumentation().getTargetContext();
    }

    public void test_installAPK() {
        Log.d(TAG, "----test_installAPK----");
        PackageUtils.installAPK(context, "/mnt/sdcard/t.apk");
    }

    public void test_uninstallAPK() {
        Log.d(TAG, "----test_uninstallAPK----");
        PackageUtils.uninstallAPK(context, "com.t");
    }

}
