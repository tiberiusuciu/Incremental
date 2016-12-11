package com.example.ergo.incremental.model.threads;

import android.app.Activity;
import android.content.Context;

import com.example.ergo.incremental.R;
import com.example.ergo.incremental.controller.MainActivity;
import com.example.ergo.incremental.model.core_mechanics.Game;
import com.example.ergo.incremental.controller.StatsFragment;
import com.example.ergo.incremental.model.utils.GameValues;

/**
 * Ce Thread gère le temps qui avance dans un niveau qui va jusqu'à 3 minutes
 */

public class TimerThread extends Activity implements Runnable {

    protected Context context;
    private static boolean isThreadStopped;

    public TimerThread(Context context) {
        this.context = context;
        isThreadStopped = false;
    }

    @Override
    public void run() {
        try {
            do{
                Thread.sleep(1000);
                if(!isThreadStopped) {
                    if(StatsFragment.getTimeBar().getProgress() == StatsFragment.getTimeBar().getMax()) {
                        runDowngrade();
                    }
                    else {
                        displayTime();
                    }
                }
            } while(StatsFragment.getTimeBar().getProgress() <= GameValues.TEMPS_PAR_NIVEAU);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void runDowngrade() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Game.downgrade();
            }
        });
    }

    private void displayTime() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                StatsFragment.getTimeBar().setProgress(StatsFragment.getTimeBar().getProgress() + 1);
                String textForTime = MainActivity.getAppContext().getResources().getString(R.string.time_indicator) + " " + Game.formatTime(GameValues.TEMPS_PAR_NIVEAU - StatsFragment.getTimeBar().getProgress());
                StatsFragment.getTimeText().setText(textForTime);
            }
        });
    }

    public static void setIsThreadStopped(boolean isThreadStopped) {
        TimerThread.isThreadStopped = isThreadStopped;
    }
}
