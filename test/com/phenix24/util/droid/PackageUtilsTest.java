package com.phenix24.util.droid;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
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
        Log.i(TAG, "----test_installAPK----");
        PackageUtils.installAPK(context, "/mnt/sdcard/t.apk");
    }

    public void test_uninstallAPK() {
        Log.i(TAG, "----test_uninstallAPK----");
        PackageUtils.uninstallAPK(context, "com.t");
    }

    public void test_getAppVersionCode() {
        Log.i(TAG, "----test_getAppVersionCode----");
        try {
            int appVersionCode = PackageUtils.getAppVersionCode(context, "com.t");
            Log.i(TAG, "appVersionCode:" + appVersionCode);
        } catch (NameNotFoundException e) {
            Log.i(TAG, "NameNotFoundException");
        }
    }

    public void test_getAppVersionName() {
        Log.i(TAG, "----test_getAppVersionName----");
        try {
            String appVersionName = PackageUtils.getAppVersionName(context, "com.t");
            Log.i(TAG, "appVersionName:" + appVersionName);
        } catch (NameNotFoundException e) {
            Log.i(TAG, "NameNotFoundException");
        }
    }
}
