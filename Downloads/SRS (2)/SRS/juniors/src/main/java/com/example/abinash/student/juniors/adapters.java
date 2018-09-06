package com.example.abinash.student.juniors;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;

public class adapters extends FragmentStatePagerAdapter {
    int Nooftabs;
    public adapters(FragmentManager fm,int ntabs)
    {
        super(fm);
        this.Nooftabs=ntabs;
    }
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                tab1 t1=new tab1();
                return t1;
            case 1:
                tab2 t2=new tab2();
                return t2;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return Nooftabs;
    }
}