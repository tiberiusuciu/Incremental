package com.example.ergo.incremental;

import com.example.ergo.incremental.core_mechanics.Game;
import com.example.ergo.incremental.currency.Coiffure;
import com.example.ergo.incremental.currency.Currency;
import com.example.ergo.incremental.currency.Principe;
import com.example.ergo.incremental.farmer.Farmer;
import com.example.ergo.incremental.farmer.KevinFarmer;
import com.example.ergo.incremental.farmer.TiberiuFarmer;
import com.example.ergo.incremental.utils.CurrencyNames;
import com.example.ergo.incremental.utils.FarmersStats;
import com.example.ergo.incremental.utils.UserStats;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class UserTest {
    public User user = new User();
    public TiberiuFarmer tiberiuFarmer = new TiberiuFarmer();
    public KevinFarmer kevinFarmer = new KevinFarmer();
    public Coiffure coiffure01 = new Coiffure();
    public Coiffure coiffure02 = new Coiffure();
    public Principe principe = new Principe();

    @Test
    public void initial_monnaie_size() throws  Exception {
        assertEquals(user.getMonnaie().size(), 0);
    }

    @Test
    public void initial_farmer_size() throws  Exception {
        assertEquals(user.getTravaileurs().size(), 0);
    }

    @Test
    public void initial_codes_per_tap() throws Exception {
        assertEquals(user.getCodesPerTap(), UserStats.STARTING_CODES_PER_TAP);
    }

    @Test
    public void initial_codes_per_second() throws Exception {
        assertEquals(user.getCodesPerSecond(), UserStats.STARTING_CODES_PER_SECOND);
    }

    @Test
    public void add_monnaie() throws Exception {
        user.addMonnaie(coiffure01);
        assertEquals(user.getMonnaie().size(), 1);
    }

    @Test
    public void count_all_instances_of_specific_monnaie() throws Exception {
        user.addMonnaie(coiffure01);
        user.addMonnaie(coiffure02);
        assertEquals(user.countAllInstancesOfSpecificMonnaie(CurrencyNames.COIFFURE_NOM), 2);
    }

    @Test
    public void find_specific_amount_monnaie() throws Exception{
        user.addMonnaie(coiffure01);
        assertEquals(user.findSpecificAmountMonnaie(CurrencyNames.COIFFURE_NOM, 1), true);
    }

    @Test
    public void find_specific_amount_monnaie_not_found() throws  Exception {
        user.addMonnaie(coiffure01);
        assertEquals(user.findSpecificAmountMonnaie(CurrencyNames.COIFFURE_NOM, 2), false);
    }

    @Test
    public void remove_specific_amount_monnaie() throws Exception {
        user.addMonnaie(coiffure01);
        user.addMonnaie(coiffure02);
        user.addMonnaie(principe);
        user.removeSpecificAmountMonnaie(CurrencyNames.PRINCIPE_NOM, 1);
        assertEquals(user.getMonnaie().size(), 2);
    }

    @Test
    public void remove_specific_amount_monnaie_not_found() throws Exception {
        user.addMonnaie(coiffure01);
        user.addMonnaie(coiffure02);
        user.addMonnaie(principe);
        user.removeSpecificAmountMonnaie(CurrencyNames.PRINCIPE_NOM, 23423);
        assertEquals(user.getMonnaie().size(), 3);
    }

    @Test
    public void add_farmer() throws Exception {
        user.addFarmer(tiberiuFarmer);
        assertEquals(user.getTravaileurs().size(), 1);
    }

    @Test
    public void count_all_instances_of_specific_farmer() throws Exception{
        user.addFarmer(tiberiuFarmer);
        user.addFarmer(kevinFarmer);
        assertEquals(user.countAllInstancesOfSpecificFarmer(FarmersStats.TIBERIU_NAME), 1);
    }

    @Test
    public void count_all_instances_of_specific_farmer_not_found() throws Exception{
        user.addFarmer(kevinFarmer);
        assertEquals(user.countAllInstancesOfSpecificFarmer(FarmersStats.TIBERIU_NAME), 0);
    }

    @Test
    public void calculate_codes_per_second() throws Exception {
        user.addFarmer(tiberiuFarmer);
        user.addFarmer(kevinFarmer);
        user.calculateCodesPerSecond();
        assertEquals(user.getCodesPerSecond(), tiberiuFarmer.getCodesPerSeconds() + kevinFarmer.getCodesPerSeconds());
    }

    @Test
    public void set_monnaie() throws Exception {
        ArrayList<Currency> currencies = new ArrayList<Currency>();
        currencies.add(coiffure01);
        currencies.add(coiffure02);
        user.setMonnaie(currencies);
        assertEquals(user.getMonnaie().size(), 2);
    }

    @Test
    public void set_travaileurs() throws Exception {
        ArrayList<Farmer> farmers = new ArrayList<Farmer>();
        farmers.add(tiberiuFarmer);
        farmers.add(kevinFarmer);
        user.setTravaileurs(farmers);
        assertEquals(user.getTravaileurs().size(), 2);
    }

    @Test
    public void set_codes_per_tap() throws Exception {
        user.setCodesPerTap(50);
        assertEquals(user.getCodesPerTap(), 50);
    }

    @Test
    public void set_codes_per_tap_invalid() throws Exception {
        user.setCodesPerTap(-50);
        assertEquals(user.getCodesPerTap(), UserStats.STARTING_CODES_PER_TAP);
    }

}
