package com.phenix24.util.droid;

import com.phenix24.util.droid.NetworkUtils.NetworkState;

import android.content.Context;
import android.test.InstrumentationTestCase;
import android.util.Log;

public class NetworkUtilsTest extends InstrumentationTestCase {

    private static final String TAG = "NetworkUtilsTest";

    private Context context;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        context = getInstrumentation().getTargetContext();
    }

    public void test_getNetworkState() {
        Log.i(TAG, "----test_getNetworkState----");
        NetworkState networkState = NetworkUtils.getNetworkState(context);
        Log.d(TAG, "networkState:" + networkState);
    }

}
