package com.phenix24.util;

import android.os.Process;
import android.test.InstrumentationTestCase;
import android.util.Log;

public class ThreadUtilsTest extends InstrumentationTestCase {

    private static final String TAG = "ThreadUtilsTest";

    public void test_threadPriority() {
        Log.i(TAG, "----test_threadPriority----");

        class Run implements Runnable {

            String priorityName;

            public Run(String priorityName) {
                this.priorityName = priorityName;
            }

            @Override
            public void run() {
                String info = "" + priorityName + "------>" + "ThreadId:"
                        + Thread.currentThread().getId() + "," + "ThreadPriority:"
                        + Thread.currentThread().getPriority() + ","
                        + "Process_ThreadId:" + Process.myTid() + ","
                        + "Process_ThreadPriority:"
                        + Process.getThreadPriority(Process.myTid());
                Log.d(TAG, info);
            }
        }

        Thread audioThread = ThreadUtils.makeAudioThread(new Run("AudioThread"));
        Thread backgroundThread = ThreadUtils.makeBackgroundThread(new Run(
                "BackgroundThread"));
        Thread defaultThread = ThreadUtils.makeDefaultThread(new Run("DefaultThread"));
        Thread displayThread = ThreadUtils.makeDisplayThread(new Run("DisplayThread"));
        Thread foregroundThread = ThreadUtils.makeForegroundThread(new Run(
                "ForegroundThread"));
        Thread lessFavorableThread = ThreadUtils.makeLessFavorableThread(new Run(
                "LessFavorableThread"));
        Thread lowestThread = ThreadUtils.makeLowestThread(new Run("LowestThread"));
        Thread moreFavorableThread = ThreadUtils.makeMoreFavorableThread(new Run(
                "MoreFavorableThread"));
        Thread urgentAudioThread = ThreadUtils.makeUrgentAudioThread(new Run(
                "UrgentAudioThread"));
        Thread urgentDisplayThread = ThreadUtils.makeUrgentDisplayThread(new Run(
                "UrgentDisplayThread"));

        audioThread.start();
        backgroundThread.start();
        defaultThread.start();
        displayThread.start();
        foregroundThread.start();
        lessFavorableThread.start();
        lowestThread.start();
        moreFavorableThread.start();
        urgentAudioThread.start();
        urgentDisplayThread.start();

    }
}
