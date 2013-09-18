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
        context = getInstrumentation().getContext();
    }

    public void test_getWidth() {
        Log.d(TAG, "----test_getWidth----");
        int width = DisplayUtils.getWidth(context);
        Log.d(TAG, "width:" + width);
    }

    public void test_getHeight() {
        Log.d(TAG, "----test_getHeight----");
        int height = DisplayUtils.getHeight(context);
        Log.d(TAG, "height:" + height);
    }

    public void test_getDensity() {
        Log.d(TAG, "----test_getDensity----");
        float density = DisplayUtils.getDensity(context);
        Log.d(TAG, "density:" + density);
    }

    public void test_getDensityDPI() {
        Log.d(TAG, "----test_getDensityDPI----");
        int densityDPI = DisplayUtils.getDensityDPI(context);
        Log.d(TAG, "densityDPI:" + densityDPI);
    }
}
