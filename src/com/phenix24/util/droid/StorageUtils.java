package com.phenix24.util.droid;

import java.io.File;

import android.content.Context;
import android.os.Environment;

public class StorageUtils {

    public static String getInternalCacheDir(Context context) {
        File cache = context.getCacheDir();
        return cache.getAbsolutePath();
    }

    public static String getInternalFilesDir(Context context) {
        File files = context.getFilesDir();
        return files.getAbsolutePath();
    }

    public static String getInternalDir(Context context, String dir, int mode) {
        File internalDir = context.getDir(dir, mode);
        return internalDir.getAbsolutePath();
    }

    public static String getExternalState() {
        String state = Environment.getExternalStorageState();
        return state;
    }

    public static boolean isExternalAvailable() {
        return Environment.MEDIA_MOUNTED.equals(getExternalState());
    }

    public static String getExternalDir() {
        if (!isExternalAvailable())
            return null;
        File dir = Environment.getExternalStorageDirectory();
        return dir.getAbsolutePath();
    }

    public static String getExternalDroidCacheDir(Context context) {
        if (!isExternalAvailable())
            return null;
        File cache = context.getExternalCacheDir();
        return cache.getAbsolutePath();
    }

    public static String getExternalDroidFilesDir(Context context) {
        if (!isExternalAvailable())
            return null;
        File files = context.getExternalFilesDir(null);
        return files.getAbsolutePath();
    }

    public static String getExternalDroidDir(Context context, String dir) {
        if (!isExternalAvailable())
            return null;
        File externalDroidDir = context.getExternalFilesDir(dir);
        return externalDroidDir.getAbsolutePath();
    }
}
