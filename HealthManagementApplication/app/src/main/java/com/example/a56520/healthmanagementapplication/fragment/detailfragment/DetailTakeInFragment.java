package com.example.a56520.healthmanagementapplication.fragment.detailfragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.a56520.healthmanagementapplication.R;

public class DetailTakeInFragment extends Fragment {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private SharedPreferences pageTagPreferences;
    private SharedPreferences.Editor pageTagPreferencesEditor;
    private String tabTitle[]={"饮食","服药"};

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_detail_take_in_page,
                container,false);
        mTabLayout = (TabLayout)v.findViewById(R.id.detail_take_in_tabLayout);
        mViewPager = (ViewPager)v.findViewById(R.id.detail_take_in_viewPager);
        initUI();

        pageTagPreferences = getActivity().getSharedPreferences("pageTag",Context.MODE_PRIVATE);
        pageTagPreferencesEditor = pageTagPreferences.edit();

        return v;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState){


        super.onActivityCreated(savedInstanceState);

    }


    private void initUI(){
        for(int i = 0;i<tabTitle.length;i++){
            mTabLayout.addTab((mTabLayout.newTab().setText(tabTitle[i])));
        }
        //设置文字居中
        mTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        //设置顶部标签指示条的颜色
        mTabLayout.setSelectedTabIndicatorColor(Color.parseColor("#4AC2B4"));
        //设置标签 “未选中" 和 “选中” 的颜色
        mTabLayout.setTabTextColors(Color.parseColor("#656565"), Color.parseColor("#4ac2b4"));
        /**
         * 需要注意的是:
         * 因为在fragment中创建的MyFragmentStatePagerAdapter,所以要传getSupportFragmentManager进去
         */
        mViewPager.setAdapter(new DetailTakeInFragmentPagerAdapter(getChildFragmentManager(),tabTitle));
        //在设置viewPager界面滑动时，创建tab滑动监听

        Log.d("test", "执行到了 aa");

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));

        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            //在选中的顶部标签时，为viewpager设置currentitem,显示viewPager对应的界面
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                String itemName;
                switch (tab.getPosition()){
                    case 0:{
                        itemName = tabTitle[0];
                        break;
                    }

                    case 1:{
                        itemName = tabTitle[1];
                        break;
                    }
                    default:{
                        itemName = "default";
                        break;
                    }
                }
                pageTagPreferencesEditor.putString("itemName",itemName);
                pageTagPreferencesEditor.commit();
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }
}