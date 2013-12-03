package com.phenix24.util;

import android.os.Process;

public class ThreadUtils {

    /**
     * Create a thread and set priority is {@link Process#THREAD_PRIORITY_AUDIO}
     * 
     * @param runnable
     *            Work task.
     * @return A thread that priority is {@link Process#THREAD_PRIORITY_AUDIO}.
     */
    public static Thread makeAudioThread(Runnable runnable) {
        return makeThread(runnable, Process.THREAD_PRIORITY_AUDIO);
    }

    /**
     * Create a thread and set priority is
     * {@link Process#THREAD_PRIORITY_BACKGROUND}.
     * 
     * @param runnable
     *            Work task.
     * @return A thread that priority is
     *         {@link Process#THREAD_PRIORITY_BACKGROUND}.
     */
    public static Thread makeBackgroundThread(Runnable runnable) {
        return makeThread(runnable, Process.THREAD_PRIORITY_BACKGROUND);
    }

    /**
     * Create a thread and set priority is
     * {@link Process#THREAD_PRIORITY_DEFAULT}.
     * 
     * @param runnable
     *            Work task.
     * @return A thread that priority is {@link Process#THREAD_PRIORITY_DEFAULT}
     */
    public static Thread makeDefaultThread(Runnable runnable) {
        return makeThread(runnable, Process.THREAD_PRIORITY_DEFAULT);
    }

    /**
     * Create a thread and set priority is
     * {@link Process#THREAD_PRIORITY_DISPLAY}.
     * 
     * @param runnable
     *            Work task.
     * @return A thread that priority is {@link Process#THREAD_PRIORITY_DISPLAY}
     */
    public static Thread makeDisplayThread(Runnable runnable) {
        return makeThread(runnable, Process.THREAD_PRIORITY_DISPLAY);
    }

    /**
     * Create a thread and set priority is
     * {@link Process#THREAD_PRIORITY_FOREGROUND}.
     * 
     * @param runnable
     *            Work task.
     * @return A thread that priority is
     *         {@link Process#THREAD_PRIORITY_FOREGROUND}.
     */
    public static Thread makeForegroundThread(Runnable runnable) {
        return makeThread(runnable, Process.THREAD_PRIORITY_FOREGROUND);
    }

    /**
     * Create a thread and set priority is
     * {@link Process#THREAD_PRIORITY_LESS_FAVORABLE}.
     * 
     * @param runnable
     *            Work task.
     * @return A thread that priority is
     *         {@link Process#THREAD_PRIORITY_LESS_FAVORABLE}.
     */
    public static Thread makeLessFavorableThread(Runnable runnable) {
        return makeThread(runnable, Process.THREAD_PRIORITY_LESS_FAVORABLE);
    }

    /**
     * Create a thread and set priority is
     * {@link Process#THREAD_PRIORITY_LOWEST}.
     * 
     * @param runnable
     *            Work task.
     * @return A thread that priority is {@link Process#THREAD_PRIORITY_LOWEST}.
     */
    public static Thread makeLowestThread(Runnable runnable) {
        return makeThread(runnable, Process.THREAD_PRIORITY_LOWEST);
    }

    /**
     * Create a thread and set priority is
     * {@link Process#THREAD_PRIORITY_MORE_FAVORABLE}.
     * 
     * @param runnable
     *            Work task.
     * @return A thread that priority is
     *         {@link Process#THREAD_PRIORITY_MORE_FAVORABLE}.
     */
    public static Thread makeMoreFavorableThread(Runnable runnable) {
        return makeThread(runnable, Process.THREAD_PRIORITY_MORE_FAVORABLE);
    }

    /**
     * Create a thread and set priority is
     * {@link Process#THREAD_PRIORITY_URGENT_AUDIO}.
     * 
     * @param runnable
     *            Work task.
     * @return A thread that priority is
     *         {@link Process#THREAD_PRIORITY_URGENT_AUDIO}.
     */
    public static Thread makeUrgentAudioThread(Runnable runnable) {
        return makeThread(runnable, Process.THREAD_PRIORITY_URGENT_AUDIO);
    }

    /**
     * Create a thread and set priority is
     * {@link Process#THREAD_PRIORITY_URGENT_DISPLAY}.
     * 
     * @param runnable
     *            Work task.
     * @return A thread that priority is
     *         {@link Process#THREAD_PRIORITY_URGENT_DISPLAY}.
     */
    public static Thread makeUrgentDisplayThread(Runnable runnable) {
        return makeThread(runnable, Process.THREAD_PRIORITY_URGENT_DISPLAY);
    }

    private static Thread makeThread(final Runnable runnable, final int priority) {
        Thread thread = new Thread(runnable) {
            @Override
            public void run() {
                Process.setThreadPriority(priority);
                super.run();
            }
        };
        return thread;
    }

}
