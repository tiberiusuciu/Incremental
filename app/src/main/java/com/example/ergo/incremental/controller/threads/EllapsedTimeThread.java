package com.example.ergo.incremental.controller.threads;

import android.app.Activity;
import android.content.Context;

/**
 * Created by ergo on 03/12/16.
 */

public class EllapsedTimeThread extends Activity implements Runnable {
    protected Context context;
    protected static int ellapsedTime;
    private static boolean isThreadStopped;

    public EllapsedTimeThread(Context context) {
        this.context = context;
        ellapsedTime = 0;
        isThreadStopped = false;
    }
    @Override
    public void run() {
        try {
            do{
                Thread.sleep(1000);
                if(!isThreadStopped) {
                    ellapsedTime++;
                }
            } while(true);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void setEllapsedTime(int ellapsedTime) {
        EllapsedTimeThread.ellapsedTime = ellapsedTime;
    }

    public static int getEllapsedTime() {
        return ellapsedTime;
    }

    public static boolean isThreadStopped() {
        return isThreadStopped;
    }

    public static void setIsThreadStopped(boolean isThreadStopped) {
        EllapsedTimeThread.isThreadStopped = isThreadStopped;
    }
}
