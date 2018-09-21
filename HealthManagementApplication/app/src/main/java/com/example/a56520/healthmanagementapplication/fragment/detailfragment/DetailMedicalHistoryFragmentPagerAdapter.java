package com.example.a56520.healthmanagementapplication.fragment.detailfragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.a56520.healthmanagementapplication.fragment.detailfragment.detailmedicalhistoryfragment.AllergyFragment;
import com.example.a56520.healthmanagementapplication.fragment.detailfragment.detailmedicalhistoryfragment.MedicalHistoryFragment;

public class DetailMedicalHistoryFragmentPagerAdapter extends FragmentStatePagerAdapter {
    private String[] mTabTitles;

    public DetailMedicalHistoryFragmentPagerAdapter(FragmentManager fm, String[] tabTitles){
        super(fm);
        this.mTabTitles = tabTitles;
    }

    @Override
    public Fragment getItem(int position){
        switch (position){
            case 0:
                return new MedicalHistoryFragment();
            case 1:
                return new AllergyFragment();
        }
        return null;
    }
    @Override
    public int getCount(){
        return mTabTitles.length;
    }
}
