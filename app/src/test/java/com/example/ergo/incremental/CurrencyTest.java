package com.example.ergo.incremental;

import com.example.ergo.incremental.core_mechanics.Game;
import com.example.ergo.incremental.currency.Absence;
import com.example.ergo.incremental.currency.Anime;
import com.example.ergo.incremental.currency.Backflip;
import com.example.ergo.incremental.currency.Blink;
import com.example.ergo.incremental.currency.CaffeInn;
import com.example.ergo.incremental.currency.Coiffure;
import com.example.ergo.incremental.currency.Cousin;
import com.example.ergo.incremental.currency.DarkSouls;
import com.example.ergo.incremental.currency.Dnd;
import com.example.ergo.incremental.currency.FrereJumeau;
import com.example.ergo.incremental.currency.Kirikou;
import com.example.ergo.incremental.currency.Linux;
import com.example.ergo.incremental.currency.Magic;
import com.example.ergo.incremental.currency.Motivation;
import com.example.ergo.incremental.currency.Nourriture;
import com.example.ergo.incremental.currency.Party;
import com.example.ergo.incremental.currency.Piano;
import com.example.ergo.incremental.currency.Principe;
import com.example.ergo.incremental.currency.Silence;
import com.example.ergo.incremental.currency.Sommeil;
import com.example.ergo.incremental.utils.CurrencyNames;
import com.example.ergo.incremental.utils.GameValues;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Ceci sont des tests très simple puisque les classes sont pratiquement vides
 * On ne fait que tester les getters ici
 */

public class CurrencyTest {

    public Absence absence = new Absence();
    public Anime anime = new Anime();
    public Backflip backflip = new Backflip();
    public Blink blink = new Blink();
    public CaffeInn caffeInn = new CaffeInn();
    public Coiffure coiffure = new Coiffure();
    public Cousin cousin = new Cousin();
    public DarkSouls darkSouls = new DarkSouls();
    public Dnd dnd = new Dnd();
    public FrereJumeau frereJumeau = new FrereJumeau();
    public Kirikou kirikou = new Kirikou();
    public Linux linux = new Linux();
    public Magic magic = new Magic();
    public Motivation motivation = new Motivation();
    public Nourriture nourriture = new Nourriture();
    public Party party = new Party();
    public Piano piano = new Piano();
    public Principe principe = new Principe();
    public Silence silence = new Silence();
    public Sommeil sommeil = new Sommeil();

    @Test
    public void absence_get_name() throws Exception {
        assertEquals(absence.getName(), CurrencyNames.ABSENCE_NOM);
    }
    @Test
    public void anime_get_name() throws Exception {
        assertEquals(anime.getName(), CurrencyNames.ANIME_NOM);
    }
    @Test
    public void backflip_get_name() throws Exception {
        assertEquals(backflip.getName(), CurrencyNames.BACKFLIP_NOM);
    }
    @Test
    public void blink_get_name() throws Exception {
        assertEquals(blink.getName(), CurrencyNames.BLINK_NOM);
    }
    @Test
    public void caffeinn_get_name() throws Exception {
        assertEquals(caffeInn.getName(), CurrencyNames.CAFFEINN_NOM);
    }
    @Test
    public void coiffure_get_name() throws Exception {
        assertEquals(coiffure.getName(), CurrencyNames.COIFFURE_NOM);
    }
    @Test
    public void cousin_get_name() throws Exception {
        assertEquals(cousin.getName(), CurrencyNames.COUSIN_NOM);
    }
    @Test
    public void darkSouls_get_name() throws Exception {
        assertEquals(darkSouls.getName(), CurrencyNames.DARKSOULS_NOM);
    }
    @Test
    public void dnd_get_name() throws Exception {
        assertEquals(dnd.getName(), CurrencyNames.DND_NOM);
    }
    @Test
    public void frereJumeau_get_name() throws Exception {
        assertEquals(frereJumeau.getName(), CurrencyNames.FRERE_JUMEAU_NOM);
    }
    @Test
    public void kirikou_get_name() throws Exception {
        assertEquals(kirikou.getName(), CurrencyNames.KIRIKOU_NOM);
    }
    @Test
    public void linux_get_name() throws Exception {
        assertEquals(linux.getName(), CurrencyNames.LINUX_NOM);
    }
    @Test
    public void magic_get_name() throws Exception {
        assertEquals(magic.getName(), CurrencyNames.MAGIC_NOM);
    }
    @Test
    public void motivation_get_name() throws Exception {
        assertEquals(motivation.getName(), CurrencyNames.MOTIVATION_NOM);
    }
    @Test
    public void nourriture_get_name() throws Exception {
        assertEquals(nourriture.getName(), CurrencyNames.NOURRITURE_NOM);
    }
    @Test
    public void party_get_name() throws Exception {
        assertEquals(party.getName(), CurrencyNames.PARTY_NOM);
    }
    @Test
    public void piano_get_name() throws Exception {
        assertEquals(piano.getName(), CurrencyNames.PIANO_NOM);
    }@Test
    public void principe_get_name() throws Exception {
        assertEquals(principe.getName(), CurrencyNames.PRINCIPE_NOM);
    }
    @Test
    public void silence_get_name() throws Exception {
        assertEquals(silence.getName(), CurrencyNames.SILENCE_NOM);
    }@Test
    public void sommeil_get_name() throws Exception {
        assertEquals(sommeil.getName(), CurrencyNames.SOMMEIL_NOM);
    }
}
