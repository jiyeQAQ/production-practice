package com.example.a56520.healthmanagementapplication.fragment.detailfragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.a56520.healthmanagementapplication.fragment.detailfragment.detailtakeinfragment.DietFragment;
import com.example.a56520.healthmanagementapplication.fragment.detailfragment.detailtakeinfragment.MedicineFragment;

public class DetailTakeInFragmentPagerAdapter extends FragmentStatePagerAdapter {
    private String[] mTabTitles;

    public DetailTakeInFragmentPagerAdapter(FragmentManager fm, String[] tabTitles){
        super(fm);
        this.mTabTitles = tabTitles;
    }

    @Override
    public Fragment getItem(int position){
        switch (position){
            case 0:
                return new DietFragment();
            case 1:
                return new MedicineFragment();
        }
        return null;
    }
    @Override
    public int getCount(){
        return mTabTitles.length;
    }
}
