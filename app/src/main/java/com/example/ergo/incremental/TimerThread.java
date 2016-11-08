package com.example.ergo.incremental;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.TextView;

import com.example.ergo.incremental.core_mechanics.Game;
import com.example.ergo.incremental.fragment.StatsFragment;
import com.example.ergo.incremental.utils.GameValues;

/**
 * Ce Thread gère le temps qui avance
 */

public class TimerThread extends Activity implements Runnable {

    protected Context context;

    public TimerThread(Context context) {
        this.context = context;
    }
    // TODO This needs to be a singleton
    // TODO make strings from values reach here
    @Override
    public void run() {
        try {
            do{
                Thread.sleep(1000);
                StatsFragment.timeBar.setProgress(StatsFragment.timeBar.getProgress() + 1);
                String textForTime = this.context.getString(R.string.time_indicator) + " " + Game.formatTime(GameValues.TEMPS_PAR_NIVEAU - StatsFragment.timeBar.getProgress());
                setText(StatsFragment.timeText, textForTime);
            } while(StatsFragment.timeBar.getProgress() <= GameValues.TEMPS_PAR_NIVEAU);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void setText(final TextView text, final String value) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                text.setText(value);
            }
        });
    }
}
