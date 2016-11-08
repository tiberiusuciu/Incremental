package com.example.ergo.incremental;

import android.util.Log;

import com.example.ergo.incremental.fragment.StatsFragment;

/**
 * Ce Thread gère le temps qui avance
 */

public class TimerThread implements Runnable {

    // TODO This needs to be a singleton
    @Override
    public void run() {
        try {
            while(true){
                Log.d("THREAD OF TIME", "THIS IS A TEST!!");
                Thread.sleep(1000);
                StatsFragment.timeBar.setProgress(StatsFragment.timeBar.getProgress() + 1);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
