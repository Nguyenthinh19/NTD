package com.example.ntd;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.example.ntd.base.BaseActivity;
import com.example.ntd.home.fragments.HomeFragment;
import com.example.ntd.home.fragments.SettingFragment;
import com.example.ntd.objects.User;
import com.google.android.material.tabs.TabLayout;

public class HomeActivity extends BaseActivity {

    ViewPager viewPager;
    TabLayout tabLayout;
    private User user;
    HomeFragment mainFlagment;
    SettingFragment settingFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        user = User.getLocalUser(getBaseContext());
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        viewPager = (ViewPager) findViewById(R.id.viewPager_home);
        viewPager.setOffscreenPageLimit(4);
        viewPager.setAdapter(new HomeViewPagerAdapter(getSupportFragmentManager()));
        viewPager.setCurrentItem(2);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:

                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        tabLayout.setupWithViewPager(viewPager);
        buildTablayout();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        mainFlagment.onActivityResult(requestCode,resultCode,data);

    }

    private class HomeViewPagerAdapter extends FragmentStatePagerAdapter {
        Drawable drawable;
        public HomeViewPagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
            drawable = ContextCompat.getDrawable(HomeActivity.this,R.drawable.ic_home);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    settingFragment = new SettingFragment();
                    return settingFragment;
                case 1:
                    mainFlagment = new HomeFragment();
                    return mainFlagment;
            }

            return null;
        }

        @Override
        public int getCount() {
            return 2;

        }
        public CharSequence getPageTitle(int position) {
            return null;
        }

    }
    private void buildTablayout(){
        tabLayout.getTabAt(0).setIcon(R.drawable.tab_settings);
        tabLayout.getTabAt(1).setIcon(R.drawable.tab_home);

    }

}
