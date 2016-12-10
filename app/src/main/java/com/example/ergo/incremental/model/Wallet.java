package com.example.ergo.incremental.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ergo on 09/12/16.
 */

public class Wallet {
    public enum Currency { ABSCENCE, ANIME, BACKFLIP, BLINK, CAFFEINN, COIFFURE, COUSIN, DARKSOULS,
                            DND, FREREJUMEAU, KIRIKOU, LINUX, MAGIC, MOTIVATION, NOURRITURE, PARTY,
                            PIANO, PRINCIPE, SILENCE, SOMMEIL }

    private static Map<Currency, Integer> amount = initCurrenciesMap();

    private static Map<Currency,Integer> initCurrenciesMap() {
        HashMap<Currency, Integer> map = new HashMap<>();
        for(Currency currency : Currency.values()){
            map.put(currency, 0);
        }
        return map;
    }

    public void addCurrency(Currency currency, int amountOfCurrency) {
        amount.put(currency, amount.get(currency) + amountOfCurrency);
    }

    public void removeCurrency(Currency currency, int amountOfCurrency) {
        amount.put(currency, amount.get(currency) - amountOfCurrency);
    }

    public int getAmountOfCurrency(Currency currency){
        return amount.get(currency);
    }

    public int getTotalAmountOfAllCurrencies() {
        int total = 0;
        for(Currency currency : Currency.values()){
            total += getAmountOfCurrency(currency);
        }
        return total;
    }

    public void reset() {
        amount = initCurrenciesMap();
    }

    public static Map<Currency, Integer> getAmount() {
        return amount;
    }

    public static void setAmount(Map<Currency, Integer> amount) {
        Wallet.amount = amount;
    }
}
