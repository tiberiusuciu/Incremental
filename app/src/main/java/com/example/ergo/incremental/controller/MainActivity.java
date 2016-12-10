package com.example.ergo.incremental.controller;

import android.content.Context;
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
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.ergo.incremental.R;
import com.example.ergo.incremental.model.User;
import com.example.ergo.incremental.controller.threads.EllapsedTimeThread;
import com.example.ergo.incremental.controller.threads.FarmerThread;
import com.example.ergo.incremental.controller.threads.RandomCurrencyThread;
import com.example.ergo.incremental.controller.threads.RandomEventThread;
import com.example.ergo.incremental.controller.threads.TimerThread;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;


public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    public static User user = null;
    private static Context mContext;
    private static TimerThread timerThread = null;
    private static RandomCurrencyThread currencyThread = null;
    private static FarmerThread farmerThread = null;
    private static RandomEventThread randomEventThread = null;
    private static EllapsedTimeThread ellapsedTimeThread = null;
    private LinearLayout mainActivity = null;
    private Integer backgroundColorValue = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
        Intent intent = getIntent();
        String reset = intent.getStringExtra("reset");
        if(reset != null) {
            if(reset.equals("true")){
                user.setCodesPerTap(UserStats.STARTING_CODES_PER_TAP);
                user.setTravaileurs(new ArrayList<Farmer>());
                user.setMonnaie(new ArrayList<Currency>());
                user.setCodesPerSecond(UserStats.STARTING_CODES_PER_SECOND);
            }
        }
        */
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
        loadPreferences();
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(user == null) {
            user = new User();
        }
        if(timerThread == null) {
            timerThread = new TimerThread(getApplicationContext());
            Thread timer = new Thread(timerThread);
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
        if(backgroundColorValue != null) {
            mainActivity.setBackgroundColor(backgroundColorValue);
        }
    }

    private void savePreferences(){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        preferences.edit().putString("backgroundColorValue", backgroundColorValue + "").apply();
        /*
        Gson gson = new Gson();
        String json = gson.toJson(user);
        preferences.edit().putString("userObject", json).apply();
        */
    }

    private void loadPreferences() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        if(!preferences.getString("backgroundColorValue", "").equals("")) {
            backgroundColorValue = Integer.parseInt(preferences.getString("backgroundColorValue", ""));
        }
        /*
        Log.d("PREPPING TO LOAD", "PREPPING TO LOAD");
        if(!preferences.getString("userObject", "").equals("")) {
            Gson gson = new Gson();
            String json = preferences.getString("userObject", "");
            Log.d("LOADING", "LOADING USER");
            Log.d("JSON OBJ", json);
            user = gson.fromJson(json, User.class);
            Log.d("AMOUNTS OF FARMERS", user.getTravaileurs().size() + "");
        }
        */
    }

    public static Context getAppContext(){
        return mContext;
    }

    @Override
    public void onPause() {
        super.onPause();
        TimerThread.setIsThreadStopped(true);
        RandomCurrencyThread.setIsThreadStopped(true);
        FarmerThread.setIsThreadStopped(true);
        RandomEventThread.setIsThreadStopped(true);
        EllapsedTimeThread.setIsThreadStopped(true);
    }

    @Override
    public void onResume() {
        super.onResume();  // Always call the superclass method first
        TimerThread.setIsThreadStopped(false);
        RandomCurrencyThread.setIsThreadStopped(false);
        FarmerThread.setIsThreadStopped(false);
        RandomEventThread.setIsThreadStopped(false);
        EllapsedTimeThread.setIsThreadStopped(false);
    }



    @Override
    protected void onStop() {
        super.onStop();
        Log.d("SAVING", "SAVING THAT USER");
        savePreferences();
    }

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
                    return new FarmersFragment();
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.changeBackgroundColor:
                changeColor();
                return true;
            default:
                return super.onOptionsItemSelected(item);
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
                savePreferences();
            }
        });

        AlertDialog alert = builder.create();
        alert.show();
    }
}
