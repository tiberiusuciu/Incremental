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


public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;

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

        viewPager.setOffscreenPageLimit(3);

    }

    @Override
    protected void onStart() {
        super.onStart();
        TimerThread timerThread = new TimerThread(getApplicationContext());
        new Thread(timerThread).start();
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
