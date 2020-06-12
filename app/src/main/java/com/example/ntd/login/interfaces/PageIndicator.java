package com.example.ntd.login.interfaces;


import androidx.viewpager.widget.ViewPager;

/**
 * Created by TuanLA on 11/25/2016.
 */
public interface PageIndicator extends ViewPager.OnPageChangeListener {

    void setViewPager(ViewPager view);

    void setViewPager(ViewPager view, int initialPosition);

    void setCurrentItem(int item);

    void setOnPageChangeListener(ViewPager.OnPageChangeListener listener);

    void notifyDataSetChanged();
}
