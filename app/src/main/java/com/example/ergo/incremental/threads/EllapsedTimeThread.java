package com.example.ergo.incremental.threads;

import android.app.Activity;
import android.content.Context;

import com.example.ergo.incremental.MainActivity;
import com.example.ergo.incremental.R;
import com.example.ergo.incremental.core_mechanics.Game;
import com.example.ergo.incremental.fragment.StatsFragment;

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
            } while(!Game.isGameOver);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
