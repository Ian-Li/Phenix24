package com.phenix24.util.droid;

import android.util.Log;

public class Logcat {

    private static final String DEFAULT_TAG = "phenix24";

    private static final boolean IS_VERBOSE = true;
    private static final boolean IS_DEBUG = true;
    private static final boolean IS_INFO = true;
    private static final boolean IS_WARN = true;
    private static final boolean IS_ERROR = true;

    /**
     * Send a VERBOSE log message use default tag.
     * 
     * @param message
     */
    public static void v(String message) {
        if (IS_VERBOSE)
            Log.v(DEFAULT_TAG, message);
    }

    /**
     * Send a VERBOSE log message use custom tag.
     * 
     * @param tag
     * @param message
     */
    public static void v(String tag, String message) {
        if (IS_VERBOSE)
            Log.v(tag, message);
    }

    /**
     * Send a DEBUG log message use default tag.
     * 
     * @param message
     */
    public static void d(String message) {
        if (IS_DEBUG)
            Log.d(DEFAULT_TAG, message);
    }

    /**
     * Send a DEBUG log message use custom tag.
     * 
     * @param tag
     * @param message
     */
    public static void d(String tag, String message) {
        if (IS_DEBUG)
            Log.d(tag, message);
    }

    /**
     * Send a INFO log message use default tag.
     * 
     * @param message
     */
    public static void i(String message) {
        if (IS_INFO)
            Log.i(DEFAULT_TAG, message);
    }

    /**
     * Send a INFO log message use custom tag.
     * 
     * @param tag
     * @param message
     */
    public static void i(String tag, String message) {
        if (IS_INFO)
            Log.i(tag, message);
    }

    /**
     * Send a WARN log message use default tag.
     * 
     * @param message
     */
    public static void w(String message) {
        if (IS_WARN)
            Log.w(DEFAULT_TAG, message);
    }

    /**
     * Send a WARN log message use custom tag.
     * 
     * @param tag
     * @param message
     */
    public static void w(String tag, String message) {
        if (IS_WARN)
            Log.w(tag, message);
    }

    /**
     * Send a ERROR log message use default tag.
     * 
     * @param message
     */
    public static void e(String message) {
        if (IS_ERROR)
            Log.e(DEFAULT_TAG, message);
    }

    /**
     * Send a ERROR log message use custom tag.
     * 
     * @param tag
     * @param message
     */
    public static void e(String tag, String message) {
        if (IS_ERROR)
            Log.e(tag, message);
    }
}
