package com.example.ergo.incremental;

import android.app.Activity;
import android.content.Context;
import android.widget.TextView;

import com.example.ergo.incremental.core_mechanics.Game;
import com.example.ergo.incremental.fragment.ShopFragment;
import com.example.ergo.incremental.fragment.StatsFragment;
import com.example.ergo.incremental.utils.GameValues;

/**
 * Created by ergo on 02/12/16.
 */

public class FarmerThread extends Activity implements Runnable {
    protected Context context;

    public FarmerThread(Context context) {
        this.context = context;
    }
    // TODO This needs to be a singleton
    // TODO the main loop will be separated from the run method, in order to reuse the code for each level
    @Override
    public void run() {
        try {
            do{
                Thread.sleep(1000);
                int codePerSecond = MainActivity.user.codesPerSecond;
                updateCode(codePerSecond);
                setText((int)(codePerSecond * RandomEventThread.newCPS) + "");
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
}
