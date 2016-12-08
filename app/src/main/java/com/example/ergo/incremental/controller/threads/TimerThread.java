package com.example.ergo.incremental.controller.threads;

import android.app.Activity;
import android.content.Context;
import android.widget.TextView;

import com.example.ergo.incremental.R;
import com.example.ergo.incremental.controller.core_mechanics.Game;
import com.example.ergo.incremental.view.StatsFragment;
import com.example.ergo.incremental.model.utils.GameValues;

/**
 * Ce Thread gère le temps qui avance
 */

public class TimerThread extends Activity implements Runnable {

    protected Context context;
    private static boolean isThreadStopped;

    public TimerThread(Context context) {
        this.context = context;
        isThreadStopped = false;
    }
    // TODO This needs to be a singleton
    // TODO the main loop will be separated from the run method, in order to reuse the code for each level
    @Override
    public void run() {
        try {
            do{
                Thread.sleep(1000);
                if(!isThreadStopped) {
                    if(StatsFragment.timeBar.getProgress() == StatsFragment.timeBar.getMax()) {
                        runDowngrade();
                    }
                    else {
                        StatsFragment.timeBar.setProgress(StatsFragment.timeBar.getProgress() + 1);
                        String textForTime = this.context.getString(R.string.time_indicator) + " " + Game.formatTime(GameValues.TEMPS_PAR_NIVEAU - StatsFragment.timeBar.getProgress());
                        setText(StatsFragment.timeText, textForTime);
                    }
                }
            } while(StatsFragment.timeBar.getProgress() <= GameValues.TEMPS_PAR_NIVEAU);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void runDowngrade() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Game.downgrade();
                StatsFragment.codeText.setText(context.getString(R.string.beggining_code));
            }
        });
    }

    private void setText(final TextView text, final String value) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                text.setText(value);
            }
        });
    }

    public static boolean isThreadStopped() {
        return isThreadStopped;
    }

    public static void setIsThreadStopped(boolean isThreadStopped) {
        TimerThread.isThreadStopped = isThreadStopped;
    }
}
