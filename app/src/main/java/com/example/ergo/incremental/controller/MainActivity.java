package com.example.ergo.incremental.controller;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.preference.PreferenceManager;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.content.DialogInterface;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.ergo.incremental.R;
import com.example.ergo.incremental.model.core_mechanics.Game;
import com.example.ergo.incremental.model.Team;
import com.example.ergo.incremental.model.User;
import com.example.ergo.incremental.model.threads.EllapsedTimeThread;
import com.example.ergo.incremental.model.threads.FarmerThread;
import com.example.ergo.incremental.model.threads.RandomCurrencyThread;
import com.example.ergo.incremental.model.threads.RandomEventThread;
import com.example.ergo.incremental.model.threads.TimerThread;
import com.example.ergo.incremental.model.Wallet;
import com.example.ergo.incremental.model.utils.UserStats;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Map;

/**
 * MainActivity de mon application, ici on déclenche nos threads, on s'occupe de charger et sauvegarder la partie
 */

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    private static User user = null;
    private static Context mContext;
    private static TimerThread timerThread = null;
    private static RandomCurrencyThread currencyThread = null;
    private static FarmerThread farmerThread = null;
    private static RandomEventThread randomEventThread = null;
    private static EllapsedTimeThread ellapsedTimeThread = null;
    private static int prestigeCount = 0;
    private LinearLayout mainActivity = null;
    private Integer backgroundColorValue = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        String reset = intent.getStringExtra("reset");
        if(reset != null) {
            if(reset.equals("true")){
                String prestigeDecision = intent.getStringExtra("prestige");
                if(prestigeDecision != null) {
                    if(prestigeDecision.equals("true")){
                        prestige();
                    }
                    Log.d("DECISION FAILED", "WE ARE NOT RESTARTING!!!" + prestigeDecision);
                }
                reset();
                getIntent().removeExtra("reset");
                getIntent().removeExtra("prestige");
            }
        }

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        viewPager.setAdapter(new CustomAdapter(getSupportFragmentManager(), getApplicationContext()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }
        });
        mContext = this.getApplicationContext();
        viewPager.setOffscreenPageLimit(3);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

        // On restaure la partie d'avant si il y a n'a une
        loadPreferences();
    }

    private void prestige() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        prestigeCount = Integer.parseInt(preferences.getString("prestigeCount", "0"));
        prestigeCount++;
    }

    @Override
    protected void onStart() {
        super.onStart();
        // Une fois que l'application est prête, on déclenche nos threads
        if(user == null) {
            user = new User();
        }
        // Ceci est un feature que j'ai ajouté à la fin de la création de cette application,
        // Je récompense le joueur selon le nombre de fois qu'il recommence après avoir atteint la fin du jeu
        user.setCodesPerTap((int)Math.pow(2, prestigeCount));
        Log.d("This is my prestige", prestigeCount + "");
        if(timerThread == null) {
            timerThread = new TimerThread(getApplicationContext());
            new Thread(timerThread).start();
        }
        if(currencyThread == null) {
            currencyThread = new RandomCurrencyThread(getApplicationContext(), user);
            new Thread(currencyThread).start();
        }
        if(farmerThread == null) {
            farmerThread = new FarmerThread(getApplicationContext());
            new Thread(farmerThread).start();
        }
        if(randomEventThread == null) {
            randomEventThread = new RandomEventThread(getApplicationContext(), user);
            new Thread(randomEventThread).start();
        }
        if(ellapsedTimeThread == null) {
            ellapsedTimeThread = new EllapsedTimeThread(getApplicationContext());
            new Thread(ellapsedTimeThread).start();
        }

        mainActivity = (LinearLayout) findViewById(R.id.activity_main);
        // On applique le fond d'écran spécifié si il existe
        if(backgroundColorValue != null) {
            mainActivity.setBackgroundColor(backgroundColorValue);
        }
    }

    // Méthode de sauvegarde
    private void savePreferences(){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        preferences.edit().putString("backgroundColorValue", backgroundColorValue + "").apply();
        preferences.edit().putString("currentLevel", Game.currentLevel + "").apply();
        preferences.edit().putString("isGameOver", Game.isGameOver + "").apply();
        preferences.edit().putString("prestigeCount", prestigeCount + "").apply();
        // On sauve l'état de nos threads
        preferences.edit().putString("ellapsedTimeThreadEllapsedTime", EllapsedTimeThread.getEllapsedTime() + "").apply();
        preferences.edit().putString("randomEventThreadEventIsOn", RandomEventThread.eventIsOn + "").apply();
        preferences.edit().putString("randomEventThreadEventTimeRemainder", RandomEventThread.eventTimeRemainder + "").apply();
        preferences.edit().putString("randomEventThreadNewCPS", RandomEventThread.newCPS + "").apply();
        preferences.edit().putString("randomEventThreadEventName", RandomEventThread.getEventName()).apply();

        // On sauve l'état de nos progress bars
        preferences.edit().putString("timeBarProgress", StatsFragment.getTimeBar().getProgress() + "").apply();

        preferences.edit().putString("codeBarMax", StatsFragment.getCodeBar().getMax() + "").apply();
        preferences.edit().putString("codeBarProgress", StatsFragment.getCodeBar().getProgress() + "").apply();

        // On sauvegarde nos objets (user, wallet, team)
        Gson gson = new Gson();

        String jsonUser = gson.toJson(user);
        String jsonTeam = gson.toJson(Team.getAmount());
        String jsonWallet = gson.toJson(Wallet.getAmount());

        preferences.edit().putString("userObject", jsonUser).apply();
        preferences.edit().putString("teamObject", jsonTeam).apply();
        preferences.edit().putString("walletObject", jsonWallet).apply();
    }

    // Méthode qui charge la partie d'auparavant
    private void loadPreferences() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);

        // Si il y a un fond d'écran spécifique
        if(!preferences.getString("backgroundColorValue", "").equals("") &&
                !preferences.getString("backgroundColorValue", "").equals("null")) {
            backgroundColorValue = Integer.parseInt(preferences.getString("backgroundColorValue", ""));
        }

        // Si tout les objets d'auparavant ont été sauvegardé
        if(!preferences.getString("userObject", "").equals("") &&
                !preferences.getString("teamObject", "").equals("") &&
                !preferences.getString("walletObject", "").equals("")) {

            Gson gson = new Gson();

            String jsonUser = preferences.getString("userObject", "");
            String jsonTeam = preferences.getString("teamObject", "");
            String jsonWallet = preferences.getString("walletObject", "");

            Type typeTeam = new TypeToken<Map<Team.Programmers, Integer>>(){}.getType();
            Type typeWallet = new TypeToken<Map<Wallet.Currency, Integer>>(){}.getType();

            Map<Team.Programmers, Integer> team = gson.fromJson(jsonTeam, typeTeam);
            Map<Wallet.Currency, Integer> wallet = gson.fromJson(jsonWallet, typeWallet);

            user = gson.fromJson(jsonUser, User.class);
            Team.setAmount(team);
            Wallet.setAmount(wallet);
        }

        // On vérifie que le niveau courant a été bien sauvegardé
        if(!preferences.getString("currentLevel", "").equals("")) {
            Game.currentLevel = Integer.parseInt(preferences.getString("currentLevel", ""));
        }

        // On vérifie que l'état de la partie a été bien sauvegardé
        if(!preferences.getString("isGameOver", "").equals("")) {
            Game.isGameOver = Boolean.parseBoolean(preferences.getString("isGameOver", ""));
        }

        // On vérifie que le thread EllapsedTimeThread a été bien sauvegardé
        if(!preferences.getString("ellapsedTimeThreadEllapsedTime", "").equals("")) {
            EllapsedTimeThread.setEllapsedTime(Integer.parseInt(preferences.getString("ellapsedTimeThreadEllapsedTime", "")));
        }

        // On vérifie que le thread RandomEventThread a été bien sauvegardé
        if(!preferences.getString("randomEventThreadEventIsOn", "").equals("") &&
                !preferences.getString("randomEventThreadEventTimeRemainder", "").equals("") &&
                !preferences.getString("randomEventThreadNewCPS", "").equals("") &&
                !preferences.getString("randomEventThreadEventName", "").equals("")) {
            RandomEventThread.eventIsOn = Boolean.parseBoolean(preferences.getString("randomEventThreadEventIsOn", ""));
            RandomEventThread.eventTimeRemainder = Integer.parseInt(preferences.getString("randomEventThreadEventTimeRemainder", ""));
            RandomEventThread.setNewCPS(Double.parseDouble(preferences.getString("randomEventThreadNewCPS", "")));
            RandomEventThread.setEventName(preferences.getString("randomEventThreadEventName", ""));
        }

        // On vérifie que le progres du progress bar du temps a été bien sauvegardé
        if(!preferences.getString("timeBarProgress", "").equals("")) {
            StatsFragment.setTimeProgress(Integer.parseInt(preferences.getString("timeBarProgress", "")));
        }

        // On vérifie que le progres du progress bar du code ainsi que le max de cette bar ont été bien sauvegardés
        if(!preferences.getString("codeBarMax", "").equals("") &&
                !preferences.getString("codeBarProgress", "").equals("")) {
            Game.codeToMake = Integer.parseInt(preferences.getString("codeBarMax", ""));
            StatsFragment.setCodeProgress(Integer.parseInt(preferences.getString("codeBarProgress", "")));
        }

        // On essayer d'aller cherche le nombre de fois que l'usage a fait un prestige, si on échoue on retourne 0
        prestigeCount = Integer.parseInt(preferences.getString("prestigeCount", "0"));
    }

    public static Context getAppContext(){
        return mContext;
    }

    @Override
    public void onPause() {
        super.onPause();

        // Si l'utilisateur met l'application en pause, on demande aux threads de rien en arrière plan alors

        TimerThread.setIsThreadStopped(true);
        RandomCurrencyThread.setIsThreadStopped(true);
        FarmerThread.setIsThreadStopped(true);
        RandomEventThread.setIsThreadStopped(true);
        EllapsedTimeThread.setIsThreadStopped(true);
    }

    @Override
    public void onResume() {
        super.onResume();

        // Lorsque l'application revient en premier plan, on indique on threads de reprendre leurs fonctionnements
        TimerThread.setIsThreadStopped(false);
        RandomCurrencyThread.setIsThreadStopped(false);
        FarmerThread.setIsThreadStopped(false);
        RandomEventThread.setIsThreadStopped(false);
        EllapsedTimeThread.setIsThreadStopped(false);
    }



    @Override
    protected void onStop() {
        super.onStop();
        // Si l'application se ferme, on sauvegarde le tout
        savePreferences();
    }

    // Méthodes pour le viewPager
    private class CustomAdapter extends FragmentPagerAdapter {

        private String fragments[] = {
                getString(R.string.clicker_page),
                getString(R.string.worker_page),
                getString(R.string.shop_page)
        };

        public CustomAdapter(FragmentManager supportFragmentManager, Context applicationContext) {
            super(supportFragmentManager);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new FarmingFragment();
                case 1:
                    return new ProgrammersFragment();
                case 2:
                    return new ShopFragment();
                default:
                    return null;
            }

        }

        @Override
        public int getCount() { return fragments.length; }

        @Override
        public CharSequence getPageTitle(int position) {
            return fragments[position];
        }
    }


    // Méthodes pour le menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    // Switch case pour diriger l'usager selon sa selection dans le menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.changeBackgroundColor:
                // Changer la couleur du fond d'écran
                changeColor();
                return true;
            case R.id.reset:
                // Demander une confirmation pour tout effacer et recommencer
                resetDialog();
                return true;
            case R.id.info:
                // Afficher de l'information sur l'application
                about();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void about() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.about_info );
        builder.setCancelable(true);

        builder.setNeutralButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private void resetDialog() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.restart_game_dialogue);
        builder.setCancelable(true);

        builder.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                reset();
            }
        });

        builder.setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private void reset() {
        // On réinitialise le tout
        user.setCodesPerTap(UserStats.STARTING_CODES_PER_TAP);
        user.getWallet().reset();
        user.getTeam().reset();
        user.setCodesPerSecond(UserStats.STARTING_CODES_PER_SECOND);
        Game.currentLevel = 1;
        Game.calculateCodeToMake();
        Game.renderUI();

        ((BaseAdapter)ShopFragment.getShopListView().getAdapter()).notifyDataSetChanged();
        ((BaseAdapter) ProgrammersFragment.getListViewofProgrammers().getAdapter()).notifyDataSetChanged();

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        Integer tmpBackgroundColor = null;
        if(!preferences.getString("backgroundColorValue", "").equals("") &&
                !preferences.getString("backgroundColorValue", "").equals("null")) {
            tmpBackgroundColor = Integer.parseInt(preferences.getString("backgroundColorValue", "-1"));
        }

        preferences.edit().clear().apply();

        // on va conserver le fond d'écran, ceci est une décision que j'ai choisit, car je me dit que
        // le fond d'écran n'a rien a avoir avec la partie vraiment
        if(tmpBackgroundColor != null) {
            preferences.edit().putString("backgroundColorValue", tmpBackgroundColor + "").apply();
        }
        Intent intent = getIntent();
        String prestigeDescision = intent.getStringExtra("prestige");
        if(prestigeDescision != null) {
            if (prestigeDescision.equals("true")) {
                preferences.edit().putString("prestigeCount", prestigeCount + "").apply();
            }
        } else {
            Intent myIntent = new Intent(getAppContext(), GameOver.class);
            myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            int ellapsedTime = EllapsedTimeThread.getEllapsedTime();
            int totalProgrammers = MainActivity.getUser().getTeam().getTotalAmountOfAllProgrammers();
            myIntent.putExtra("ellapsedTime", ellapsedTime + "");
            myIntent.putExtra("totalProgrammers", totalProgrammers + "");
            myIntent.putExtra("abandon", "true");
            MainActivity.getAppContext().startActivity(myIntent);
        }
    }

    private void changeColor() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.choose_color);
        LayoutInflater factory = LayoutInflater.from(MainActivity.this);
        final View view = factory.inflate(R.layout.color_selection_dialogue, null);
        builder.setView(view);
        builder.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // On fonctionne avec du RGB de 0 à 255
                EditText red = (EditText) view.findViewById(R.id.redAmount);
                EditText green = (EditText) view.findViewById(R.id.greenAmount);
                EditText blue = (EditText) view.findViewById(R.id.blueAmount);
                String redText = red.getText().toString();
                String greenText = green.getText().toString();
                String blueText = blue.getText().toString();
                if(redText.equals("")){
                    redText = "255";
                }
                if(greenText.equals("")){
                    greenText = "255";
                }
                if(blueText.equals("")){
                    blueText = "255";
                }

                int redValue = Integer.parseInt(redText);
                int greenValue = Integer.parseInt(greenText);
                int blueValue = Integer.parseInt(blueText);

                // Les conditions suivantes sont pour s'assurer que l'usager ne fait pas le malin

                if(redValue < 0) {
                    redValue = 0;
                } else if (redValue >= 255) {
                    redValue = 255;
                }
                if(greenValue < 0) {
                    greenValue = 0;
                } else if (greenValue >= 255) {
                    greenValue = 255;
                }
                if(blueValue < 0) {
                    blueValue = 0;
                } else if (blueValue >= 255) {
                    blueValue = 255;
                }

                backgroundColorValue = Color.rgb(redValue, greenValue, blueValue);
                mainActivity.setBackgroundColor(backgroundColorValue);

                // On sauvegarde l'application une fois que la couleur est établie
                savePreferences();
            }
        });

        AlertDialog alert = builder.create();
        alert.show();
    }

    public static User getUser() {
        return user;
    }
}
