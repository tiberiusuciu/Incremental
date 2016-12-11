package com.example.ergo.incremental.model.threads;

import android.app.Activity;
import android.content.Context;
import android.widget.BaseAdapter;
import android.widget.Toast;

import com.example.ergo.incremental.R;
import com.example.ergo.incremental.model.User;
import com.example.ergo.incremental.controller.MainActivity;
import com.example.ergo.incremental.controller.ShopFragment;
import com.example.ergo.incremental.controller.StatsFragment;
import com.example.ergo.incremental.model.Wallet;
import com.example.ergo.incremental.model.utils.GameValues;

/**
 * Cette classe va offrir une monnaie à l'utilisateur de facon aléatoire à chaque x secondes
 */

public class RandomCurrencyThread extends Activity implements Runnable, GameValues {

    Context context;
    User user;
    Wallet.Currency newCurrency = null;
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

    private Wallet.Currency randomCurrency() {
        int randomNumber = (int)(Math.random() * GameValues.currencyNames.length);
        return Wallet.Currency.values()[randomNumber];
    }

    private void displayNewCurrency(final Wallet.Currency currency) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(context, MainActivity.getAppContext().getString(R.string.receive_notification) + currency.name(), Toast.LENGTH_SHORT).show();
                // Mettre a jour la liste de fermiers
                ((BaseAdapter)ShopFragment.listView.getAdapter()).notifyDataSetChanged();
            }
        });
    }

    private void addCurrencyToUser(Wallet.Currency currency) {
        user.addMonnaie(currency);
    }

    public static boolean isThreadStopped() {
        return isThreadStopped;
    }

    public static void setIsThreadStopped(boolean isThreadStopped) {
        RandomCurrencyThread.isThreadStopped = isThreadStopped;
    }
}
