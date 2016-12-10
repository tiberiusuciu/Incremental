package com.example.ergo.incremental;

import com.example.ergo.incremental.model.utils.FarmersStats;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Ceci sont des tests très simple puisque les classes sont pratiquement vides
 */


public class FarmerTest {
    public AdamFarmer adamFarmer = new AdamFarmer();
    public DavidFarmer davidFarmer = new DavidFarmer();
    public GregFarmer gregFarmer = new GregFarmer();
    public GuillaumeFarmer guillaumeFarmer = new GuillaumeFarmer();
    public HerveFarmer herveFarmer = new HerveFarmer();
    public JeanDanielFarmer jeanDanielFarmer = new JeanDanielFarmer();
    public JebFarmer jebFarmer = new JebFarmer();
    public JessFarmer jessFarmer = new JessFarmer();
    public JimmyFarmer jimmyFarmer = new JimmyFarmer();
    public JonathanFarmer jonathanFarmer = new JonathanFarmer();
    public KevinFarmer kevinFarmer = new KevinFarmer();
    public MichaelFarmer michaelFarmer = new MichaelFarmer();
    public MiechkoFarmer miechkoFarmer = new MiechkoFarmer();
    public NicolasFarmer nicolasFarmer = new NicolasFarmer();
    public SamuelFarmer samuelFarmer = new SamuelFarmer();
    public SebFarmer sebFarmer = new SebFarmer();
    public SoaresFarmer soaresFarmer = new SoaresFarmer();
    public TiberiuFarmer tiberiuFarmer = new TiberiuFarmer();
    public VincentFarmer vincentFarmer = new VincentFarmer();
    public XavierFarmer xavierFarmer = new XavierFarmer();

    @Test
    public void adamFarmer_get_cps() throws Exception {
        assertEquals(adamFarmer.getCodesPerSeconds(), FarmersStats.ADAM_CPS);
    }
    @Test
    public void davidFarmer_get_cps() throws Exception {
        assertEquals(davidFarmer.getCodesPerSeconds(), FarmersStats.DAVID_CPS);
    }@Test
    public void gregFarmer_get_cps() throws Exception {
        assertEquals(gregFarmer.getCodesPerSeconds(), FarmersStats.GREG_CPS);
    }@Test
    public void guillaumeFarmer_get_cps() throws Exception {
        assertEquals(guillaumeFarmer.getCodesPerSeconds(), FarmersStats.GUILLAUME_CPS);
    }@Test
    public void herveFarmer_get_cps() throws Exception {
        assertEquals(herveFarmer.getCodesPerSeconds(), FarmersStats.HERVE_CPS);
    }@Test
    public void jeanDanielFarmer_get_cps() throws Exception {
        assertEquals(jeanDanielFarmer.getCodesPerSeconds(), FarmersStats.JEAN_DANIEL_CPS);
    }@Test
    public void jebFarmer_get_cps() throws Exception {
        assertEquals(jebFarmer.getCodesPerSeconds(), FarmersStats.JEB_CPS);
    }@Test
    public void jessFarmer_get_cps() throws Exception {
        assertEquals(jessFarmer.getCodesPerSeconds(), FarmersStats.JESS_CPS);
    }@Test
    public void jimmyFarmer_get_cps() throws Exception {
        assertEquals(jimmyFarmer.getCodesPerSeconds(), FarmersStats.JIMMY_CPS);
    }@Test
    public void jonathanFarmer_get_cps() throws Exception {
        assertEquals(jonathanFarmer.getCodesPerSeconds(), FarmersStats.JONATHAN_CPS);
    }@Test
    public void kevinFarmer_get_cps() throws Exception {
        assertEquals(kevinFarmer.getCodesPerSeconds(), FarmersStats.KEVIN_CPS);
    }@Test
    public void michaelFarmer_get_cps() throws Exception {
        assertEquals(michaelFarmer.getCodesPerSeconds(), FarmersStats.MICHAEL_CPS);
    }@Test
    public void miechkoFarmer_get_cps() throws Exception {
        assertEquals(miechkoFarmer.getCodesPerSeconds(), FarmersStats.MIECHKO_CPS);
    }@Test
    public void nicolasFarmer_get_cps() throws Exception {
        assertEquals(nicolasFarmer.getCodesPerSeconds(), FarmersStats.NICOLAS_CPS);
    }@Test
    public void samuelFarmer_get_cps() throws Exception {
        assertEquals(samuelFarmer.getCodesPerSeconds(), FarmersStats.SAMUEL_CPS);
    }@Test
    public void sebFarmer_get_cps() throws Exception {
        assertEquals(sebFarmer.getCodesPerSeconds(), FarmersStats.SEB_CPS);
    }@Test
    public void soaresFarmer_get_cps() throws Exception {
        assertEquals(soaresFarmer.getCodesPerSeconds(), FarmersStats.SOARES_CPS);
    }@Test
    public void tiberiuFarmer_get_cps() throws Exception {
        assertEquals(tiberiuFarmer.getCodesPerSeconds(), FarmersStats.TIBERIU_CPS);
    }@Test
    public void vincentFarmer_get_cps() throws Exception {
        assertEquals(vincentFarmer.getCodesPerSeconds(), FarmersStats.VINCENT_CPS);
    }@Test
    public void xavierFarmer_get_cps() throws Exception {
        assertEquals(xavierFarmer.getCodesPerSeconds(), FarmersStats.XAVIER_CPS);
    }

    @Test
    public void adamFarmer_get_name() throws Exception {
        assertEquals(adamFarmer.getName(), FarmersStats.ADAM_NAME);
    }
    @Test
    public void davidFarmer_get_name() throws Exception {
        assertEquals(davidFarmer.getName(), FarmersStats.DAVID_NAME);
    }@Test
    public void gregFarmer_get_name() throws Exception {
        assertEquals(gregFarmer.getName(), FarmersStats.GREG_NAME);
    }@Test
    public void guillaumeFarmer_get_name() throws Exception {
        assertEquals(guillaumeFarmer.getName(), FarmersStats.GUILLAUME_NAME);
    }@Test
    public void herveFarmer_get_name() throws Exception {
        assertEquals(herveFarmer.getName(), FarmersStats.HERVE_NAME);
    }@Test
    public void jeanDanielFarmer_get_name() throws Exception {
        assertEquals(jeanDanielFarmer.getName(), FarmersStats.JEAN_DANIEL_NAME);
    }@Test
    public void jebFarmer_get_name() throws Exception {
        assertEquals(jebFarmer.getName(), FarmersStats.JEB_NAME);
    }@Test
    public void jessFarmer_get_name() throws Exception {
        assertEquals(jessFarmer.getName(), FarmersStats.JESS_NAME);
    }@Test
    public void jimmyFarmer_get_name() throws Exception {
        assertEquals(jimmyFarmer.getName(), FarmersStats.JIMMY_NAME);
    }@Test
    public void jonathanFarmer_get_name() throws Exception {
        assertEquals(jonathanFarmer.getName(), FarmersStats.JONATHAN_NAME);
    }@Test
    public void kevinFarmer_get_name() throws Exception {
        assertEquals(kevinFarmer.getName(), FarmersStats.KEVIN_NAME);
    }@Test
    public void michaelFarmer_get_name() throws Exception {
        assertEquals(michaelFarmer.getName(), FarmersStats.MICHAEL_NAME);
    }@Test
    public void miechkoFarmer_get_name() throws Exception {
        assertEquals(miechkoFarmer.getName(), FarmersStats.MIECHKO_NAME);
    }@Test
    public void nicolasFarmer_get_name() throws Exception {
        assertEquals(nicolasFarmer.getName(), FarmersStats.NICOLAS_NAME);
    }@Test
    public void samuelFarmer_get_name() throws Exception {
        assertEquals(samuelFarmer.getName(), FarmersStats.SAMUEL_NAME);
    }@Test
    public void sebFarmer_get_name() throws Exception {
        assertEquals(sebFarmer.getName(), FarmersStats.SEB_NAME);
    }@Test
    public void soaresFarmer_get_name() throws Exception {
        assertEquals(soaresFarmer.getName(), FarmersStats.SOARES_NAME);
    }@Test
    public void tiberiuFarmer_get_name() throws Exception {
        assertEquals(tiberiuFarmer.getName(), FarmersStats.TIBERIU_NAME);
    }@Test
    public void vincentFarmer_get_name() throws Exception {
        assertEquals(vincentFarmer.getName(), FarmersStats.VINCENT_NAME);
    }@Test
    public void xavierFarmer_get_name() throws Exception {
        assertEquals(xavierFarmer.getName(), FarmersStats.XAVIER_NAME);
    }

    @Test
    public void adamFarmer_set_cps() throws Exception {
        adamFarmer.setCodesPerSeconds(0);
        assertEquals(adamFarmer.getCodesPerSeconds(), 0);
    }
    @Test
    public void davidFarmer_set_cps() throws Exception {
        davidFarmer.setCodesPerSeconds(0);
        assertEquals(davidFarmer.getCodesPerSeconds(), 0);
    }@Test
    public void gregFarmer_set_cps() throws Exception {
        gregFarmer.setCodesPerSeconds(0);
        assertEquals(gregFarmer.getCodesPerSeconds(), 0);
    }@Test
    public void guillaumeFarmer_set_cps() throws Exception {
        guillaumeFarmer.setCodesPerSeconds(0);
        assertEquals(guillaumeFarmer.getCodesPerSeconds(), 0);
    }@Test
    public void herveFarmer_set_cps() throws Exception {
        herveFarmer.setCodesPerSeconds(0);
        assertEquals(herveFarmer.getCodesPerSeconds(), 0);
    }@Test
    public void jeanDanielFarmer_set_cps() throws Exception {
        jeanDanielFarmer.setCodesPerSeconds(0);
        assertEquals(jeanDanielFarmer.getCodesPerSeconds(), 0);
    }@Test
    public void jebFarmer_set_cps() throws Exception {
        jebFarmer.setCodesPerSeconds(0);
        assertEquals(jebFarmer.getCodesPerSeconds(), 0);
    }@Test
    public void jessFarmer_set_cps() throws Exception {
        jessFarmer.setCodesPerSeconds(0);
        assertEquals(jessFarmer.getCodesPerSeconds(), 0);
    }@Test
    public void jimmyFarmer_set_cps() throws Exception {
        jimmyFarmer.setCodesPerSeconds(0);
        assertEquals(jimmyFarmer.getCodesPerSeconds(), 0);
    }@Test
    public void jonathanFarmer_set_cps() throws Exception {
        jonathanFarmer.setCodesPerSeconds(0);
        assertEquals(jonathanFarmer.getCodesPerSeconds(), 0);
    }@Test
    public void kevinFarmer_set_cps() throws Exception {
        kevinFarmer.setCodesPerSeconds(0);
        assertEquals(kevinFarmer.getCodesPerSeconds(), 0);
    }@Test
    public void michaelFarmer_set_cps() throws Exception {
        michaelFarmer.setCodesPerSeconds(0);
        assertEquals(michaelFarmer.getCodesPerSeconds(), 0);
    }@Test
    public void miechkoFarmer_set_cps() throws Exception {
        miechkoFarmer.setCodesPerSeconds(0);
        assertEquals(miechkoFarmer.getCodesPerSeconds(), 0);
    }@Test
    public void nicolasFarmer_set_cps() throws Exception {
        nicolasFarmer.setCodesPerSeconds(0);
        assertEquals(nicolasFarmer.getCodesPerSeconds(), 0);
    }@Test
    public void samuelFarmer_set_cps() throws Exception {
        samuelFarmer.setCodesPerSeconds(0);
        assertEquals(samuelFarmer.getCodesPerSeconds(), 0);
    }@Test
    public void sebFarmer_set_cps() throws Exception {
        sebFarmer.setCodesPerSeconds(0);
        assertEquals(sebFarmer.getCodesPerSeconds(), 0);
    }@Test
    public void soaresFarmer_set_cps() throws Exception {
        soaresFarmer.setCodesPerSeconds(0);
        assertEquals(soaresFarmer.getCodesPerSeconds(), 0);
    }@Test
    public void tiberiuFarmer_set_cps() throws Exception {
        tiberiuFarmer.setCodesPerSeconds(0);
        assertEquals(tiberiuFarmer.getCodesPerSeconds(), 0);
    }@Test
    public void vincentFarmer_set_cps() throws Exception {
        vincentFarmer.setCodesPerSeconds(0);
        assertEquals(vincentFarmer.getCodesPerSeconds(), 0);
    }@Test
    public void xavierFarmer_set_cps() throws Exception {
        xavierFarmer.setCodesPerSeconds(0);
        assertEquals(xavierFarmer.getCodesPerSeconds(), 0);
    }

}
