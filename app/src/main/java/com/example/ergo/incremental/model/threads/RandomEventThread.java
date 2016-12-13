package com.example.ergo.incremental.model.threads;

import android.app.Activity;
import android.content.Context;

import com.example.ergo.incremental.model.User;
import com.example.ergo.incremental.controller.EventFragment;
import com.example.ergo.incremental.model.utils.GameValues;

/**
 * thread RandomEventThread, ce thread permet de généré un événement aléatoire à chaque minutes parmis les 42 événements possibles
 */

public class RandomEventThread extends Activity implements Runnable, GameValues {
    Context context;
    User user;
    public static boolean eventIsOn = false;
    public static int eventTimeRemainder = 0;
    public static double newCPS = 1;
    private static String eventName;
    private static int eventIndex;
    private static boolean isThreadStopped;

    public RandomEventThread(Context context, User user) {
        this.context = context;
        this.user = user;
        isThreadStopped = false;
    }

    @Override
    public void run() {
        try {
            do{
                Thread.sleep(1000);
                if(!isThreadStopped) {
                    if (eventIsOn) {
                        eventTimeRemainder--;
                        if (eventTimeRemainder == 0) {
                            eventIsOn = false;
                            newCPS = 1;
                        }
                    } else {
                        newRandomEvent();
                        eventIsOn = true;
                    }
                }
            } while(true);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void newRandomEvent() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                eventIndex = (int)(Math.random()*GameValues.eventNames.length);
                newCPS = GameValues.eventEffects[eventIndex];
                eventName = GameValues.eventNames[eventIndex];
                EventFragment.getEventName().setText(eventName);
                eventTimeRemainder = GameValues.EVENT_DURATION;
            }
        });
    }

    public static String getEventName() {
        return eventName;
    }

    public static void setEventName(String eventName) {
        RandomEventThread.eventName = eventName;
    }

    public static double getNewCPS() {
        return newCPS;
    }

    public static void setNewCPS(double newCPS) {
        RandomEventThread.newCPS = newCPS;
    }

    public static void setIsThreadStopped(boolean isThreadStopped) {
        RandomEventThread.isThreadStopped = isThreadStopped;
    }

    public static int getEventIndex() {
        return eventIndex;
    }

    public static void setEventIndex(int eventIndex) {
        RandomEventThread.eventIndex = eventIndex;
    }
}
