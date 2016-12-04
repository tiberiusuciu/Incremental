package com.example.ergo.incremental;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

import com.example.ergo.incremental.core_mechanics.Game;
import com.example.ergo.incremental.currency.Currency;
import com.example.ergo.incremental.fragment.EventFragment;
import com.example.ergo.incremental.fragment.StatsFragment;
import com.example.ergo.incremental.utils.GameValues;

/**
 * Created by ergo on 03/12/16.
 */

public class RandomEventThread extends Activity implements Runnable, GameValues {
    Context context;
    User user;
    boolean eventIsOn = false;
    int eventTimeRemainder = 0;
    static double newCPS = 1;

    public RandomEventThread(Context context, User user) {
        this.context = context;
        this.user = user;
    }

    @Override
    public void run() {
        try {
            do{
                Thread.sleep(1000);
                if(eventIsOn) {
                    eventTimeRemainder--;
                    if(eventTimeRemainder == 0) {
                        eventIsOn = false;
                        newCPS = 1;
                    }
                } else {
                    newRandomEvent();
                    eventIsOn = true;
                }
            } while(!Game.isGameOver);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void newRandomEvent() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                int randomEventIndex = (int)(Math.random()*GameValues.eventNames.length);
                newCPS = GameValues.eventEffects[randomEventIndex];
                EventFragment.eventName.setText(GameValues.eventNames[randomEventIndex]);
                eventTimeRemainder = 60;
            }
        });
    }


}
