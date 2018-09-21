package com.example.a56520.healthmanagementapplication.fragment.detailfragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.a56520.healthmanagementapplication.fragment.detailfragment.detailmeasurablefragment.MeasurableBloodGlucoseFragment;
import com.example.a56520.healthmanagementapplication.fragment.detailfragment.detailmeasurablefragment.MeasurableBloodOxygenFragment;
import com.example.a56520.healthmanagementapplication.fragment.detailfragment.detailmeasurablefragment.MeasurableBloodPressureFragment;
import com.example.a56520.healthmanagementapplication.fragment.detailfragment.detailmeasurablefragment.MeasurableBodyTemperatureFragment;
import com.example.a56520.healthmanagementapplication.fragment.detailfragment.detailmeasurablefragment.MeasurableBodyWeightFragment;
import com.example.a56520.healthmanagementapplication.fragment.detailfragment.detailmeasurablefragment.MeasurableHeartRateFragment;

public class DetailMeasurableFragmentPagerAdapter extends FragmentStatePagerAdapter {
    private String[] mTabTitles;

    public DetailMeasurableFragmentPagerAdapter(FragmentManager fm,String[] tabTitles){
        super(fm);
        this.mTabTitles = tabTitles;
    }

    @Override
    public Fragment getItem(int position){
        switch (position){
            case 0:
                return new MeasurableBloodGlucoseFragment();
            case 1:
                return new MeasurableBloodOxygenFragment();
            case 2:
                return new MeasurableBloodPressureFragment();
            case 3:
                return new MeasurableBodyTemperatureFragment();
            case 4:
                return new MeasurableBodyWeightFragment();
            case 5:
                return new MeasurableHeartRateFragment();
        }
        return null;
    }
    @Override
    public int getCount(){
        return mTabTitles.length;
    }
}
