package com.example.ergo.incremental.model.threads;

import android.app.Activity;
import android.content.Context;

import com.example.ergo.incremental.controller.MainActivity;
import com.example.ergo.incremental.R;
import com.example.ergo.incremental.model.core_mechanics.Game;
import com.example.ergo.incremental.controller.StatsFragment;

/**
 * Thread FarmerThread, ce thread s'occupe d'appliquer le CPS de chaque programmeurs à chaque seconde
 */

public class FarmerThread extends Activity implements Runnable {
    protected Context context;
    private static boolean isThreadStopped;

    public FarmerThread(Context context) {
        this.context = context;
        isThreadStopped = false;
    }

    @Override
    public void run() {
        try {
            do{
                Thread.sleep(1000);
                if(!isThreadStopped) {
                    int codePerSecond = MainActivity.getUser().getCodesPerSecond();
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
                StatsFragment.getCodeBar().setProgress(StatsFragment.getCodeBar().getProgress() + (int)(codePerSecond * RandomEventThread.newCPS));
                if(StatsFragment.getCodeBar().getProgress() >= StatsFragment.getCodeBar().getMax()) {
                    Game.levelUp();
                    StatsFragment.getCodeBar().setProgress(0);
                    StatsFragment.getCodeBar().setMax(Game.codeToMake);
                    StatsFragment.getCodeText().setText(context.getString(R.string.beggining_code));
                }
            }
        });
    }

    private void setText(final String value) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                StatsFragment.getCodesPerSecond().setText(value);
                if(StatsFragment.getCodeBar().getProgress() != 0){
                    StatsFragment.getCodeText().setText(context.getString(R.string.remaining_code) + " " + (Game.codeToMake - StatsFragment.getCodeBar().getProgress()));
                }
            }
        });
    }

    public static void setIsThreadStopped(boolean isThreadStopped) {
        FarmerThread.isThreadStopped = isThreadStopped;
    }
}
