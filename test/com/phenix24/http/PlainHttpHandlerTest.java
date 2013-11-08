package com.phenix24.http;

import java.io.IOException;

import android.content.Context;
import android.test.InstrumentationTestCase;
import android.util.Log;

public class PlainHttpHandlerTest extends InstrumentationTestCase {

    private static final String TAG = "PlainHttpHandlerTest";

    private Context context;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        context = getInstrumentation().getTargetContext();
    }

    public void test_GET() {
        Log.i(TAG, "----test_GET----");

        PlainHttpHandler httpHandler = new PlainHttpHandler(context);
        String response = null;
        try {
            response = httpHandler.GET("http://www.baidu.com");
        } catch (HttpException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            httpHandler.shutdown();
        }

        Log.i(TAG, "response:" + response);
    }
}
