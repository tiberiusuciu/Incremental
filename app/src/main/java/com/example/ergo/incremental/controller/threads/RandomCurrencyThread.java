package com.example.ergo.incremental.controller.threads;

import android.app.Activity;
import android.content.Context;
import android.widget.BaseAdapter;
import android.widget.Toast;

import com.example.ergo.incremental.R;
import com.example.ergo.incremental.model.User;
import com.example.ergo.incremental.model.currency.Currency;
import com.example.ergo.incremental.controller.MainActivity;
import com.example.ergo.incremental.controller.ShopFragment;
import com.example.ergo.incremental.controller.StatsFragment;
import com.example.ergo.incremental.model.utils.GameValues;

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
            myClass = Class.forName("com.example.ergo.incremental.model.currency." + GameValues.currencyNames[randomNumber]);
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
                Toast.makeText(context, MainActivity.getAppContext().getString(R.string.receive_notification) + currency.getName(), Toast.LENGTH_SHORT).show();
                // Mettre a jour la liste de fermiers
                ((BaseAdapter)ShopFragment.listView.getAdapter()).notifyDataSetChanged();
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
