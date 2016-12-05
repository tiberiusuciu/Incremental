package com.example.ergo.incremental;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.PreferenceManager;
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
import android.widget.Toast;

import com.example.ergo.incremental.fragment.FarmersFragment;
import com.example.ergo.incremental.fragment.FarmingFragment;
import com.example.ergo.incremental.fragment.ShopFragment;
import com.example.ergo.incremental.threads.EllapsedTimeThread;
import com.example.ergo.incremental.threads.FarmerThread;
import com.example.ergo.incremental.threads.RandomCurrencyThread;
import com.example.ergo.incremental.threads.RandomEventThread;
import com.example.ergo.incremental.threads.TimerThread;


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
    private int colorValue = -1;
    private boolean colorChanged = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
        mainActivity = (LinearLayout) findViewById(R.id.activity_main);
        if(colorValue != -1) {
            mainActivity.setBackgroundColor(colorValue);
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        if(user == null) {
            user = new User();
        }
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
    }

    private void savePreferences(int colorValue){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        preferences.edit().putString("colorValue", colorValue + "").apply();
    }

    private void loadPreferences() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        if(preferences.getString("colorValue", "").length() > 0) {
            colorValue = Integer.parseInt(preferences.getString("colorValue", ""));
        }
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
            case R.id.changeColor:
                changeColor();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void changeColor() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Please choose your color preferences");
        LayoutInflater factory = LayoutInflater.from(MainActivity.this);
        final View view = factory.inflate(R.layout.color_selection_dialogue, null);
        builder.setView(view);
        builder.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
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
                } else if (redValue > 255) {
                    redValue = 255;
                }
                if(greenValue < 0) {
                    greenValue = 0;
                } else if (greenValue > 255) {
                    greenValue = 255;
                }
                if(blueValue < 0) {
                    blueValue = 0;
                } else if (blueValue > 255) {
                    blueValue = 255;
                }
                colorValue = Color.rgb(redValue, greenValue, blueValue);
                mainActivity.setBackgroundColor(colorValue);
                savePreferences(colorValue);
            }
        });

        AlertDialog alert = builder.create();
        alert.show();
    }
}
