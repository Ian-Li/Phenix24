package com.phenix24.util;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import android.test.InstrumentationTestCase;
import android.util.Log;

public class SerializeUtilsTest extends InstrumentationTestCase {

    private static final String TAG = "SerializeUtilsTest";

    private static final String FILE_PATH = "/mnt/sdcard/serializable.ser";

    private static class S implements Serializable {

        private static final long serialVersionUID = 1L;

        public static int v0;
        public int v1;
        public String v2;

        @Override
        public String toString() {
            return "v0:" + v0 + "\n" + "v1:" + v1 + "\n" + "v2:" + v2;
        }

    }

    public void test_serialize() {
        Log.i(TAG, "----test_serialize----");

        S s = new S();
        S.v0 = 99;
        s.v1 = 100;
        s.v2 = "Serializable";

        File f = new File(FILE_PATH);
        try {
            f.delete();
            f.createNewFile();
        } catch (IOException e) {
        }

        boolean isSuccess = SerializeUtils.serialize(s, f.getAbsolutePath());

        Log.i(TAG, "isSuccess:" + isSuccess);
    }

    public void test_deserialize() {
        Log.i(TAG, "----test_deserialize----");

        S s = (S) SerializeUtils.deserialize(FILE_PATH);

        Log.i(TAG, s.toString());
    }
}
