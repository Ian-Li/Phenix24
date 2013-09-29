package com.phenix24.util;

import java.security.NoSuchAlgorithmException;

import android.test.InstrumentationTestCase;
import android.util.Log;

public class DigestTest extends InstrumentationTestCase {

    private static final String TAG = "DigestTest";

    public void test_generate() {
        Log.i(TAG, "----test_generate----");
        try {
            String messageDigest = Digest.generate("SHA-1", "password");
            Log.i(TAG, "messageDigest:" + messageDigest);
        } catch (NoSuchAlgorithmException e) {
            Log.i(TAG, "NoSuchAlgorithmException");
        }
    }
}
