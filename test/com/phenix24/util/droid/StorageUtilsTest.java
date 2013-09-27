package com.phenix24.util.droid;

import android.content.Context;
import android.test.InstrumentationTestCase;
import android.text.format.Formatter;
import android.util.Log;

public class StorageUtilsTest extends InstrumentationTestCase {

    private static final String TAG = "StorageUtilsTest";

    private Context context;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        context = getInstrumentation().getTargetContext();
    }

    public void test_getInternalCacheDir() {
        Log.i(TAG, "----test_getInternalCacheDir----");
        String cacheDir = StorageUtils.getInternalCacheDir(context);
        Log.i(TAG, "cacheDir:" + cacheDir);
    }

    public void test_getInternalFilesDir() {
        Log.i(TAG, "----test_getInternalFilesDir----");
        String filesDir = StorageUtils.getInternalFilesDir(context);
        Log.i(TAG, "filesDir:" + filesDir);

    }

    public void test_getInternalDir() {
        Log.i(TAG, "----test_getInternalDir----");
        String dir = StorageUtils
                .getInternalDir(context, "testdir", Context.MODE_PRIVATE);
        Log.i(TAG, "dir:" + dir);
    }

    public void test_getExternalState() {
        Log.i(TAG, "----test_getExternalState----");
        String state = StorageUtils.getExternalState();
        Log.i(TAG, "state:" + state);
    }

    public void test_isExternalAvailable() {
        Log.i(TAG, "----test_isExternalAvailable----");
        boolean isAvailable = StorageUtils.isExternalAvailable();
        Log.i(TAG, "isAvailable:" + isAvailable);
    }

    public void test_getExternalDir() {
        Log.i(TAG, "----test_getExternalDir----");
        String dir = StorageUtils.getExternalDir();
        Log.i(TAG, "dir:" + dir);
    }

    public void test_getExternalDroidCacheDir() {
        Log.i(TAG, "----test_getExternalDroidCacheDir----");
        String cache = StorageUtils.getExternalDroidCacheDir(context);
        Log.i(TAG, "cache:" + cache);
    }

    public void test_getExternalDroidFilesDir() {
        Log.i(TAG, "----test_getExternalDroidFilesDir----");
        String files = StorageUtils.getExternalDroidFilesDir(context);
        Log.i(TAG, "files:" + files);
    }

    public void test_getExternalDroidDir() {
        Log.i(TAG, "----test_getExternalDroidDir----");
        String dir = StorageUtils.getExternalDroidDir(context, "test_dir");
        Log.i(TAG, "dir:" + dir);
    }

    public void test_getInternalTotalSize() {
        Log.i(TAG, "----test_getInternalTotalSize----");
        long internalTotalSize = StorageUtils.getInternalTotalSize();
        Log.i(TAG,
                "internalTotalSize:"
                        + Formatter.formatFileSize(context, internalTotalSize));
    }

    public void test_getInternalAvailableSize() {
        Log.i(TAG, "----test_getInternalAvailableSize----");
        long internalAvailableSize = StorageUtils.getInternalAvailableSize();
        Log.i(TAG,
                "internalAvailableSize:"
                        + Formatter.formatFileSize(context, internalAvailableSize));
    }

    public void test_getExternalTotalSize() {
        Log.i(TAG, "----test_getExternalTotalSize----");
        long externalTotalSize = StorageUtils.getExternalTotalSize();
        Log.i(TAG,
                "externalTotalSize:"
                        + Formatter.formatFileSize(context, externalTotalSize));
    }

    public void test_getExternalAvailableSize() {
        Log.i(TAG, "----test_getExternalAvailableSize----");
        long externalAvailableSize = StorageUtils.getExternalAvailableSize();
        Log.i(TAG,
                "externalAvailableSize:"
                        + Formatter.formatFileSize(context, externalAvailableSize));
    }
}
