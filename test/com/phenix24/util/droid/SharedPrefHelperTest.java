package com.phenix24.util.droid;

import android.content.Context;
import android.test.InstrumentationTestCase;
import android.util.Log;

public class SharedPrefHelperTest extends InstrumentationTestCase {

    private static final String TAG = "SharedPrefHelperTest";

    private Context context;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        context = getInstrumentation().getTargetContext();
    }

    public void test_sharedpreferences_default() {
        Log.i(TAG, "----test_sharedpreferences_default----");
        SharedPrefHelper spHelper = new SharedPrefHelper(context);

        boolean b = spHelper.getBoolean("boolean", false);
        int i = spHelper.getInt("int", 0);
        long l = spHelper.getLong("long", 0);
        float f = spHelper.getFloat("float", 0);
        String s = spHelper.getString("String", "empty");
        String log = "boolean:" + b + "\n" + "int:" + i + "\n" + "long:" + l + "\n"
                + "float:" + f + "\n" + "String:" + s + "\n";
        Log.i(TAG, "-----Get Log-----" + "\n" + log);

        spHelper.setBoolean("boolean", true);
        b = spHelper.getBoolean("boolean", false);
        spHelper.setInt("int", 10);
        i = spHelper.getInt("int", 0);
        spHelper.setLong("long", 100);
        l = spHelper.getLong("long", 0);
        spHelper.setFloat("float", (float) 1000.01);
        f = spHelper.getFloat("float", 0);
        spHelper.setString("String", "test");
        s = spHelper.getString("String", "empty");
        log = "boolean:" + b + "\n" + "int:" + i + "\n" + "long:" + l + "\n" + "float:"
                + f + "\n" + "String:" + s + "\n";
        Log.i(TAG, "-----Put Log-----" + "\n" + log);

        spHelper.cleanAll();
        b = spHelper.getBoolean("boolean", false);
        i = spHelper.getInt("int", 0);
        l = spHelper.getLong("long", 0);
        f = spHelper.getFloat("float", 0);
        s = spHelper.getString("String", "empty");
        log = "boolean:" + b + "\n" + "int:" + i + "\n" + "long:" + l + "\n" + "float:"
                + f + "\n" + "String:" + s + "\n";
        Log.i(TAG, "-----Clean Log-----" + "\n" + log);
    }

    public void test_sharedpreferences_named() {
        Log.i(TAG, "----test_sharedpreferences_named----");
        SharedPrefHelper spHelper = new SharedPrefHelper(context,
                "test_sharedpreferences_named.sp", Context.MODE_PRIVATE);

        boolean b = spHelper.getBoolean("boolean", false);
        int i = spHelper.getInt("int", 0);
        long l = spHelper.getLong("long", 0);
        float f = spHelper.getFloat("float", 0);
        String s = spHelper.getString("String", "empty");
        String log = "boolean:" + b + "\n" + "int:" + i + "\n" + "long:" + l + "\n"
                + "float:" + f + "\n" + "String:" + s + "\n";
        Log.i(TAG, "-----Get Log-----" + "\n" + log);

        spHelper.setBoolean("boolean", true);
        b = spHelper.getBoolean("boolean", false);
        spHelper.setInt("int", 10);
        i = spHelper.getInt("int", 0);
        spHelper.setLong("long", 100);
        l = spHelper.getLong("long", 0);
        spHelper.setFloat("float", (float) 1000.01);
        f = spHelper.getFloat("float", 0);
        spHelper.setString("String", "test");
        s = spHelper.getString("String", "empty");
        log = "boolean:" + b + "\n" + "int:" + i + "\n" + "long:" + l + "\n" + "float:"
                + f + "\n" + "String:" + s + "\n";
        Log.i(TAG, "-----Put Log-----" + "\n" + log);

        spHelper.cleanAll();
        b = spHelper.getBoolean("boolean", false);
        i = spHelper.getInt("int", 0);
        l = spHelper.getLong("long", 0);
        f = spHelper.getFloat("float", 0);
        s = spHelper.getString("String", "empty");
        log = "boolean:" + b + "\n" + "int:" + i + "\n" + "long:" + l + "\n" + "float:"
                + f + "\n" + "String:" + s + "\n";
        Log.i(TAG, "-----Clean Log-----" + "\n" + log);
    }

}
