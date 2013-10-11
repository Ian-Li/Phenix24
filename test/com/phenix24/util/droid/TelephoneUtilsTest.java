package com.phenix24.util.droid;

import android.content.Context;
import android.test.InstrumentationTestCase;
import android.util.Log;

public class TelephoneUtilsTest extends InstrumentationTestCase {

    private static final String TAG = "TelephoneUtilsTest";

    private Context context;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        context = getInstrumentation().getTargetContext();
    }

    public void test_getDeviceId() {
        Log.i(TAG, "----test_getDeviceId----");
        String deviceId = TelephoneUtils.getDeviceId(context);
        Log.i(TAG, "deviceId:" + deviceId);
    }
}
