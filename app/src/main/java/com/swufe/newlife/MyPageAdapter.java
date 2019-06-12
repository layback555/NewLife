package com.swufe.newlife;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MyPageAdapter extends FragmentPagerAdapter {
    public MyPageAdapter(FragmentManager manager) {
        super(manager);
    }
    @Override
    public Fragment getItem(int i) {
        if(i==0){
            return new FirstFragment();
        }else if(i==1){
            return new SecondFragment();
        }else{
            return new EndFragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
