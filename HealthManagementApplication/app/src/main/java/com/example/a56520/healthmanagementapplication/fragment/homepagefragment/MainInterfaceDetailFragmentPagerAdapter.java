package com.example.a56520.healthmanagementapplication.fragment.homepagefragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.a56520.healthmanagementapplication.fragment.detailfragment.DetailDiscomfortFragment;
import com.example.a56520.healthmanagementapplication.fragment.detailfragment.DetailMeasurableFragment;
import com.example.a56520.healthmanagementapplication.fragment.detailfragment.DetailMedicalHistoryFragment;
import com.example.a56520.healthmanagementapplication.fragment.detailfragment.DetailTakeInFragment;

public class MainInterfaceDetailFragmentPagerAdapter extends FragmentStatePagerAdapter {
    private String[] mTabTitles;

    public MainInterfaceDetailFragmentPagerAdapter(FragmentManager fm, String[] tabTitles){
        super(fm);
        this.mTabTitles = tabTitles;
    }

    @Override
    public Fragment getItem(int position){
        switch (position){
            case 0:
                return new DetailMeasurableFragment();
            case 1:
                return new DetailDiscomfortFragment();
            case 2:
                return new DetailTakeInFragment();
            case 3:
                return new DetailMedicalHistoryFragment();
        }
        return null;
    }
    @Override
    public int getCount(){
        return mTabTitles.length;
    }
}
