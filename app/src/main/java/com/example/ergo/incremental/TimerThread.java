package com.example.ergo.incremental;

import android.util.Log;

/**
 * Ce Thread gère le temps qui avance
 */

public class TimerThread implements Runnable {

    @Override
    public void run() {
        try {
            while(true){
                Log.d("THREAD OF TIME", "THIS IS A TEST!!");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
