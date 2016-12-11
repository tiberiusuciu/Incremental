package com.example.ergo.incremental;

import com.example.ergo.incremental.model.Team;
import com.example.ergo.incremental.model.User;
import com.example.ergo.incremental.model.Wallet;
import com.example.ergo.incremental.model.utils.ProgrammersStats;
import com.example.ergo.incremental.model.utils.UserStats;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest {
    public User user = new User();

    @Test
    public void initial_monnaie_size() throws  Exception {
        user.getWallet().reset();
        assertEquals(user.getWallet().getTotalAmountOfAllCurrencies(), 0);
    }

    @Test
    public void initial_farmer_size() throws  Exception {
        user.getTeam().reset();
        assertEquals(user.getTeam().getTotalAmountOfAllProgrammers(), 0);
    }

    @Test
    public void initial_codes_per_tap() throws Exception {
        assertEquals(user.getCodesPerTap(), UserStats.STARTING_CODES_PER_TAP);
    }

    @Test
    public void initial_codes_per_second() throws Exception {
        user.getTeam().reset();
        assertEquals(user.getCodesPerSecond(), UserStats.STARTING_CODES_PER_SECOND);
    }

    @Test
    public void add_monnaie() throws Exception {
        user.getWallet().reset();
        user.addMonnaie(Wallet.Currency.LINUX);
        assertEquals(user.countAllInstancesOfSpecificMonnaie(Wallet.Currency.LINUX), 1);
    }

    @Test
    public void find_specific_amount_monnaie() throws Exception{
        user.getWallet().reset();
        user.addMonnaie(Wallet.Currency.LINUX);
        assertEquals(user.findSpecificAmountMonnaie(Wallet.Currency.LINUX, 1), true);
    }

    @Test
    public void find_specific_amount_monnaie_not_found() throws  Exception {
        user.getWallet().reset();
        user.addMonnaie(Wallet.Currency.LINUX);
        assertEquals(user.findSpecificAmountMonnaie(Wallet.Currency.LINUX, 2), false);
    }

    @Test
    public void remove_specific_amount_monnaie() throws Exception {
        user.getWallet().reset();
        user.addMonnaie(Wallet.Currency.LINUX);
        user.addMonnaie(Wallet.Currency.LINUX);
        user.addMonnaie(Wallet.Currency.PRINCIPE);
        user.removeSpecificAmountMonnaie(Wallet.Currency.PRINCIPE, 1);
        assertEquals(user.findSpecificAmountMonnaie(Wallet.Currency.PRINCIPE, 1), false);
    }

    @Test
    public void remove_specific_amount_monnaie_not_found() throws Exception {
        user.getWallet().reset();
        user.addMonnaie(Wallet.Currency.LINUX);
        user.addMonnaie(Wallet.Currency.LINUX);
        user.addMonnaie(Wallet.Currency.PRINCIPE);
        user.removeSpecificAmountMonnaie(Wallet.Currency.PRINCIPE, 23423);
        assertEquals(user.findSpecificAmountMonnaie(Wallet.Currency.PRINCIPE, 1), true);
    }

    @Test
    public void add_farmer() throws Exception {
        user.getTeam().reset();
        user.addFarmer(Team.Programmers.ADAM);
        assertEquals(user.getTeam().getTotalAmountOfAllProgrammers(), 1);
    }

    @Test
    public void count_all_instances_of_specific_farmer() throws Exception{
        user.getTeam().reset();
        user.addFarmer(Team.Programmers.ADAM);
        user.addFarmer(Team.Programmers.KEVIN);
        assertEquals(user.countAllInstancesOfSpecificFarmer(Team.Programmers.ADAM), 1);
    }

    @Test
    public void count_all_instances_of_specific_farmer_not_found() throws Exception{
        user.getTeam().reset();
        user.addFarmer(Team.Programmers.KEVIN);
        assertEquals(user.countAllInstancesOfSpecificFarmer(Team.Programmers.ADAM), 0);
    }

    @Test
    public void calculate_codes_per_second() throws Exception {
        user.getTeam().reset();
        user.addFarmer(Team.Programmers.ADAM); // index 0 dans CPS
        user.addFarmer(Team.Programmers.KEVIN); // index 10 dans CPS
        user.calculateCodesPerSecond();
        assertEquals(user.getCodesPerSecond(), ProgrammersStats.cps[0] + ProgrammersStats.cps[10]);
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

    @Test
    public void reset_wallet() {
        user.addMonnaie(Wallet.Currency.LINUX);
        user.addMonnaie(Wallet.Currency.LINUX);
        user.addMonnaie(Wallet.Currency.LINUX);
        user.addMonnaie(Wallet.Currency.BACKFLIP);
        user.addMonnaie(Wallet.Currency.BACKFLIP);
        user.addMonnaie(Wallet.Currency.BACKFLIP);
        user.resetWallet();
        assertEquals(user.getWallet().getTotalAmountOfAllCurrencies(), 0);
    }
    
    @Test
    public void reset_team() {
        user.addFarmer(Team.Programmers.DAVID);
        user.addFarmer(Team.Programmers.DAVID);
        user.addFarmer(Team.Programmers.JEANDANIEL);
        user.addFarmer(Team.Programmers.JEANDANIEL);
        user.resetTeam();
        assertEquals(user.getTeam().getTotalAmountOfAllProgrammers(), 0);
    }

}
