package com.phenix24.util.droid;

import android.content.Context;
import android.test.InstrumentationTestCase;
import android.util.Log;

public class DisplayUtilsTest extends InstrumentationTestCase {

    private static final String TAG = "DisplayUtilsTest";

    private Context context;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        context = getInstrumentation().getTargetContext();
    }

    public void test_getWidth() {
        Log.i(TAG, "----test_getWidth----");
        int width = DisplayUtils.getWidth(context);
        Log.i(TAG, "width:" + width);
    }

    public void test_getHeight() {
        Log.i(TAG, "----test_getHeight----");
        int height = DisplayUtils.getHeight(context);
        Log.i(TAG, "height:" + height);
    }

    public void test_getDensity() {
        Log.i(TAG, "----test_getDensity----");
        float density = DisplayUtils.getDensity(context);
        Log.i(TAG, "density:" + density);
    }

    public void test_getDensityDPI() {
        Log.i(TAG, "----test_getDensityDPI----");
        int densityDPI = DisplayUtils.getDensityDPI(context);
        Log.i(TAG, "densityDPI:" + densityDPI);
    }
}
