package com.example.ergo.incremental.threads;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ergo.incremental.MainActivity;
import com.example.ergo.incremental.User;
import com.example.ergo.incremental.core_mechanics.Game;
import com.example.ergo.incremental.currency.Currency;
import com.example.ergo.incremental.fragment.ShopFragment;
import com.example.ergo.incremental.fragment.StatsFragment;
import com.example.ergo.incremental.utils.GameValues;
import com.example.ergo.incremental.utils.ShopFragmentInterface;

/**
 * Cette classe va offrir une monnaie à l'utilisateur de facon aléatoire à chaque x secondes
 */

public class RandomCurrencyThread extends Activity implements Runnable, GameValues {

    Context context;
    User user;
    Currency newCurrency = null;
    private static boolean isThreadStopped;

    public RandomCurrencyThread(Context context, User user) {
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
                    if (StatsFragment.timeBar.getProgress() % MONNAIE_A_CHAQUE_X_SECONDES == 0 && StatsFragment.timeBar.getProgress() != 0 && StatsFragment.timeBar.getProgress() != GameValues.TEMPS_PAR_NIVEAU) {
                        newCurrency = randomCurrency();
                        if (newCurrency != null) {
                            addCurrencyToUser(newCurrency);
                            displayNewCurrency(newCurrency);
                        }
                    }
                }
            } while(true);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private Currency randomCurrency() {
        int randomNumber = (int)(Math.random() * GameValues.currencyNames.length);
        Class<?> myClass = null;
        Currency currency = null;
        try {
            myClass = Class.forName("com.example.ergo.incremental.currency." + GameValues.currencyNames[randomNumber]);
            currency = (Currency) myClass.newInstance();
            return currency;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } finally {
            return currency;
        }
    }

    private void displayNewCurrency(final Currency currency) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(context, "You've receiced currency " + currency.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void addCurrencyToUser(Currency currency) {
        user.addMonnaie(currency);
    }

    public static boolean isThreadStopped() {
        return isThreadStopped;
    }

    public static void setIsThreadStopped(boolean isThreadStopped) {
        RandomCurrencyThread.isThreadStopped = isThreadStopped;
    }
}
