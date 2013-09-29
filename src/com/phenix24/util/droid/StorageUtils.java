package com.phenix24.util.droid;

import java.io.File;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;

public class StorageUtils {

    /**
     * Get the absolute path to the application specific cache directory on the
     * Internal Storage.
     * 
     * @param context
     * @return the cache directory "/data/data/[packgae]/cache"
     */
    public static String getInternalCacheDir(Context context) {
        File cache = context.getCacheDir();
        return cache.getAbsolutePath();
    }

    /**
     * Get the absolute path to the application specific files directory on the
     * Internal Storage.
     * 
     * @param context
     * @return the files directory "/data/data/[packgae]/files"
     */
    public static String getInternalFilesDir(Context context) {
        File files = context.getFilesDir();
        return files.getAbsolutePath();
    }

    /**
     * Get the absolute path to the custom directory on the Internal Storage.
     * 
     * @param context
     * @param dir
     *            custom directory name
     * @param mode
     *            Operating mode,use one of
     *            Context.MODE_PRIVATE,Context.MODE_WORLD_READABLE,Conext.
     *            MODE_WORLD_WRITEABLE.
     * @return the custom directory "/data/data/[packgae]/[custom directory]"
     */
    public static String getInternalDir(Context context, String dir, int mode) {
        File internalDir = context.getDir(dir, mode);
        return internalDir.getAbsolutePath();
    }

    /**
     * Gets the current state of the primary "external" storage device
     * 
     * @return state of
     *         Environment.MEDIA_BAD_REMOVAL,Environment.MEDIA_CHECKING,
     *         Environment.MEDIA_MOUNTED,Environment
     *         .MEDIA_MOUNTED_READ_ONLY,Environment
     *         .MEDIA_NOFS,Environment.MEDIA_REMOVED
     *         ,Environment.MEDIA_SHARED,Environment
     *         .MEDIA_UNMOUNTABLE,Environment.MEDIA_UNMOUNTED
     */
    public static String getExternalState() {
        String state = Environment.getExternalStorageState();
        return state;
    }

    /**
     * Whether the primary "external" storage device is available.
     * 
     * @return true available,otherwise false.
     */
    public static boolean isExternalAvailable() {
        return Environment.MEDIA_MOUNTED.equals(getExternalState());
    }

    /**
     * Gets the Android external storage directory.e.g"/mnt/sdcard".
     * 
     * @return the absolute path to the primary "external" storage,return NULL
     *         if the "external" storage is unavailabel.
     */
    public static String getExternalDir() {
        if (!isExternalAvailable())
            return null;
        File dir = Environment.getExternalStorageDirectory();
        return dir.getAbsolutePath();
    }

    /**
     * Get the absolute path to application's cache directory on the "external"
     * filesystem.the directory and files under this directory will be deteled
     * when application uninstalled.
     * 
     * @param context
     * @return the cache directory
     *         e.g."/mnt/sdcard/Android/data/[package]/cache",return NULL if the
     *         "external" storage is unavailabel.
     */
    public static String getExternalDroidCacheDir(Context context) {
        if (!isExternalAvailable())
            return null;
        File cache = context.getExternalCacheDir();
        return cache.getAbsolutePath();
    }

    /**
     * Get the absolute path to application's files directory on the "external"
     * filesystem.the directory and files under this directory will be deteled
     * when application uninstalled.
     * 
     * @param context
     * @return the files directory
     *         e.g."/mnt/sdcard/Android/data/[package]/files",return NULL if the
     *         "external" storage is unavailabel.
     */
    public static String getExternalDroidFilesDir(Context context) {
        if (!isExternalAvailable())
            return null;
        File files = context.getExternalFilesDir(null);
        return files.getAbsolutePath();
    }

    /**
     * Get the absolute path to application's custom directory on the "external"
     * filesystem.the directory and files under this directory will be deteled
     * when application uninstalled.
     * 
     * @param context
     * @param dir
     *            custom directory name
     * @return the custom directory
     *         e.g."/mnt/sdcard/Android/data/[package]/[custom directory]"
     *         ,return NULL if the "external" storage is unavailabel.
     */
    public static String getExternalDroidDir(Context context, String dir) {
        if (!isExternalAvailable())
            return null;
        File externalDroidDir = context.getExternalFilesDir(dir);
        return externalDroidDir.getAbsolutePath();
    }

    /**
     * Get total size to "internal" storage device
     * 
     * @return total size,in bytes.
     */
    public static long getInternalTotalSize() {
        File dataDir = Environment.getDataDirectory();
        StatFs statFs = new StatFs(dataDir.getAbsolutePath());
        long blockSize = statFs.getBlockSize();
        long blockCount = statFs.getBlockCount();
        return blockSize * blockCount;
    }

    /**
     * Get available size to "internal" storage device
     * 
     * @return available size,in bytes.
     */
    public static long getInternalAvailableSize() {
        File dataDir = Environment.getDataDirectory();
        StatFs statFs = new StatFs(dataDir.getAbsolutePath());
        long blockSize = statFs.getBlockSize();
        long availableBlocks = statFs.getAvailableBlocks();
        return blockSize * availableBlocks;
    }

    /**
     * Get total size to "external" storage device
     * 
     * @return total size,in bytes.
     */
    public static long getExternalTotalSize() {
        if (!isExternalAvailable())
            return 0;
        StatFs statFs = new StatFs(getExternalDir());
        long blockSize = statFs.getBlockSize();
        long blockCount = statFs.getBlockCount();
        return blockSize * blockCount;
    }

    /**
     * Get available size to "external" storage device
     * 
     * @return available size,in bytes.
     */
    public static long getExternalAvailableSize() {
        if (!isExternalAvailable())
            return 0;
        StatFs statFs = new StatFs(getExternalDir());
        long blockSize = statFs.getBlockSize();
        long availableBlocks = statFs.getAvailableBlocks();
        return blockSize * availableBlocks;
    }
}
