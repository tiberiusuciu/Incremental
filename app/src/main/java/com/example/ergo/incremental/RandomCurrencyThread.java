package com.example.ergo.incremental;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.ergo.incremental.core_mechanics.Game;
import com.example.ergo.incremental.currency.Currency;
import com.example.ergo.incremental.currency.Magic;
import com.example.ergo.incremental.fragment.StatsFragment;
import com.example.ergo.incremental.utils.GameValues;

/**
 * Cette classe va offrir une monnaie à l'utilisateur de facon aléatoire à chaque x secondes
 */

public class RandomCurrencyThread extends Activity implements Runnable, GameValues {

    Context context;
    User user;
    Currency newCurrency = null;

    public RandomCurrencyThread(Context context, User user) {
        this.context = context;
        this.user = user;
    }

    @Override
    public void run() {
        try {
            do{
                Thread.sleep(1000);
                if(StatsFragment.timeBar.getProgress() % MONNAIE_A_CHAQUE_X_SECONDES == 0 && StatsFragment.timeBar.getProgress() != 0 && StatsFragment.timeBar.getProgress() != GameValues.TEMPS_PAR_NIVEAU){
                    newCurrency = randomCurrency();
                    if(newCurrency != null){
                        addCurrencyToUser(newCurrency);
                        displayNewCurrency(newCurrency);
                    }
                }
            } while(!Game.isGameOver);
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
}
