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
        context = getInstrumentation().getContext();
    }

    public void test_getInternalCacheDir() {
        Log.d(TAG, "----test_getInternalCacheDir----");
        String cacheDir = StorageUtils.getInternalCacheDir(context);
        Log.d(TAG, "cacheDir:" + cacheDir);
    }

    public void test_getInternalFilesDir() {
        Log.d(TAG, "----test_getInternalFilesDir----");
        String filesDir = StorageUtils.getInternalFilesDir(context);
        Log.d(TAG, "filesDir:" + filesDir);

    }

    public void test_getInternalDir() {
        Log.d(TAG, "----test_getInternalDir----");
        String dir = StorageUtils
                .getInternalDir(context, "testdir", Context.MODE_PRIVATE);
        Log.d(TAG, "dir:" + dir);
    }

    public void test_getExternalState() {
        Log.d(TAG, "----test_getExternalState----");
        String state = StorageUtils.getExternalState();
        Log.d(TAG, "state:" + state);
    }

    public void test_isExternalAvailable() {
        Log.d(TAG, "----test_isExternalAvailable----");
        boolean isAvailable = StorageUtils.isExternalAvailable();
        Log.d(TAG, "isAvailable:" + isAvailable);
    }

    public void test_getExternalDir() {
        Log.d(TAG, "----test_getExternalDir----");
        String dir = StorageUtils.getExternalDir();
        Log.d(TAG, "dir:" + dir);
    }

    public void test_getExternalDroidCacheDir() {
        Log.d(TAG, "----test_getExternalDroidCacheDir----");
        String cache = StorageUtils.getExternalDroidCacheDir(context);
        Log.d(TAG, "cache:" + cache);
    }

    public void test_getExternalDroidFilesDir() {
        Log.d(TAG, "----test_getExternalDroidFilesDir----");
        String files = StorageUtils.getExternalDroidFilesDir(context);
        Log.d(TAG, "files:" + files);
    }

    public void test_getExternalDroidDir() {
        Log.d(TAG, "----test_getExternalDroidDir----");
        String dir = StorageUtils.getExternalDroidDir(context, "test_dir");
        Log.d(TAG, "dir:" + dir);
    }

    public void test_getInternalTotalSize() {
        Log.d(TAG, "----test_getInternalTotalSize----");
        long internalTotalSize = StorageUtils.getInternalTotalSize();
        Log.d(TAG,
                "internalTotalSize:"
                        + Formatter.formatFileSize(context, internalTotalSize));
    }

    public void test_getInternalAvailableSize() {
        Log.d(TAG, "----test_getInternalAvailableSize----");
        long internalAvailableSize = StorageUtils.getInternalAvailableSize();
        Log.d(TAG,
                "internalAvailableSize:"
                        + Formatter.formatFileSize(context, internalAvailableSize));
    }

    public void test_getExternalTotalSize() {
        Log.d(TAG, "----test_getExternalTotalSize----");
        long externalTotalSize = StorageUtils.getExternalTotalSize();
        Log.d(TAG,
                "externalTotalSize:"
                        + Formatter.formatFileSize(context, externalTotalSize));
    }

    public void test_getExternalAvailableSize() {
        Log.d(TAG, "----test_getExternalAvailableSize----");
        long externalAvailableSize = StorageUtils.getExternalAvailableSize();
        Log.d(TAG,
                "externalAvailableSize:"
                        + Formatter.formatFileSize(context, externalAvailableSize));
    }
}
