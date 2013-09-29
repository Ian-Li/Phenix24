package com.phenix24.util;

import android.test.InstrumentationTestCase;
import android.util.Log;

public class StringUtilsTest extends InstrumentationTestCase {

    private static final String TAG = "StringUtilsTest";

    public void test_bytesToHexStr() {
        Log.i(TAG, "----test_bytesToHexStr----");
        byte[] bytes = new byte[] { (byte) 0x01, (byte) 0xAF };
        String hexString = StringUtils.bytesToHexStr(bytes);
        Log.i(TAG, "hexString:" + hexString);
    }

    public void test_hexStrToBytes() {
        Log.i(TAG, "----test_hexStrToBytes----");
        byte[] bytes = StringUtils.hexStrToBytes("01AF");
        String hexString = StringUtils.bytesToHexStr(bytes);
        Log.i(TAG, "hexString:" + hexString);
    }
}
