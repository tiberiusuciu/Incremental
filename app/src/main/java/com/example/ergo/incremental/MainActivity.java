package com.example.ergo.incremental;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

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

    public static Context getAppContext(){
        return mContext;
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

}
