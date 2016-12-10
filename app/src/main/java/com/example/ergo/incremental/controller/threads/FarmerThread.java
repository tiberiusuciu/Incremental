package com.example.ergo.incremental.controller.threads;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import com.example.ergo.incremental.controller.MainActivity;
import com.example.ergo.incremental.R;
import com.example.ergo.incremental.controller.core_mechanics.Game;
import com.example.ergo.incremental.controller.StatsFragment;

/**
 * Created by ergo on 02/12/16.
 */

public class FarmerThread extends Activity implements Runnable {
    protected Context context;
    private static boolean isThreadStopped;

    public FarmerThread(Context context) {
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
                    int codePerSecond = MainActivity.user.getCodesPerSecond();
                    updateCode(codePerSecond);
                    setText((int) (codePerSecond * RandomEventThread.newCPS) + "");
                }
            } while(true);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void updateCode(final int codePerSecond) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                StatsFragment.codeBar.setProgress(StatsFragment.codeBar.getProgress() + (int)(codePerSecond * RandomEventThread.newCPS));
                if(StatsFragment.codeBar.getProgress() >= StatsFragment.codeBar.getMax()) {
                    Game.levelUp();
                    StatsFragment.codeBar.setProgress(0);
                    StatsFragment.codeBar.setMax(Game.codeToMake);
                    StatsFragment.codeText.setText(context.getString(R.string.beggining_code));
                }
            }
        });
    }

    private void setText(final String value) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                StatsFragment.codesPerSecond.setText(value);
                if(StatsFragment.codeBar.getProgress() != 0){
                    StatsFragment.codeText.setText(context.getString(R.string.remaining_code) + " " + (Game.codeToMake - StatsFragment.codeBar.getProgress()));
                }
            }
        });
    }

    public static boolean isThreadStopped() {
        return isThreadStopped;
    }

    public static void setIsThreadStopped(boolean isThreadStopped) {
        FarmerThread.isThreadStopped = isThreadStopped;
    }
}
