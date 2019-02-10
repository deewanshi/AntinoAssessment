package com.example.deewanshigrover.navigationdrawer;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by DEEWANSHI GROVER on 29-09-2018.
 */

public class TabPager extends FragmentStatePagerAdapter {
    String[] titles=new String[]{"First","Second","Third"};

    public TabPager(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:
                return new First();
            case 1:
                return new Second();
            case 2:
                return new Third();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

}
