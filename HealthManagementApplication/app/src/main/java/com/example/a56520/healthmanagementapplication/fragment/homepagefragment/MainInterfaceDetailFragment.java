package com.example.a56520.healthmanagementapplication.fragment.homepagefragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.a56520.healthmanagementapplication.NewBloodPressureActivity;
import com.example.a56520.healthmanagementapplication.R;
import com.example.a56520.healthmanagementapplication.fragment.detailfragment.DetailDiscomfortFragment;
import com.example.a56520.healthmanagementapplication.fragment.detailfragment.DetailMeasurableFragment;
import com.example.a56520.healthmanagementapplication.fragment.detailfragment.DetailMedicalHistoryFragment;
import com.example.a56520.healthmanagementapplication.fragment.detailfragment.DetailTakeInFragment;

import java.util.List;

public class MainInterfaceDetailFragment extends Fragment {

    private Fragment firstFragment;
    private ImageButton detailMenuButton,detailSearchButton;
    private EditText detailSearchEditText;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private SharedPreferences pageTagPreferences;
    private SharedPreferences.Editor pageTagPreferencesEditor;
    private FloatingActionButton floatingActionButton;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private String detailSearchData;
    private String tabTitle[]={"测量","不适","摄入","病史"};

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_main_interface_detail_page,
                container,false);

        mTabLayout = (TabLayout)v.findViewById(R.id.detail_page_top_tabLayout);
        mViewPager = (ViewPager)v.findViewById(R.id.detail_page_viewPager);
        floatingActionButton=(FloatingActionButton)v.findViewById(R.id.detail_page_floating_button);

        initBar(v);

        initUI();
        pageTagPreferences = getActivity().getSharedPreferences("pageTag", Context.MODE_PRIVATE);
        pageTagPreferencesEditor = pageTagPreferences.edit();

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String N = pageTagPreferences.getString("itemName","default");

                Toast.makeText(getActivity(), "test take in "+N,
                        Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), NewBloodPressureActivity.class);

                switch (N){
                    case "血压":
                        intent.putExtra(NewBloodPressureActivity.ITEM_NAME,"血压");
                        intent.putExtra(NewBloodPressureActivity.ITEM_IMAGE_ID,R.drawable.apple);
                        startActivity(intent);
                        break;
                    case "血糖":
                        intent.putExtra(NewBloodPressureActivity.ITEM_NAME,"血糖");
                        intent.putExtra(NewBloodPressureActivity.ITEM_IMAGE_ID,R.drawable.banana);
                        startActivity(intent);
                        break;
                    case "体重":
                        intent.putExtra(NewBloodPressureActivity.ITEM_NAME,"体重");
                        intent.putExtra(NewBloodPressureActivity.ITEM_IMAGE_ID,R.drawable.cherry);
                        startActivity(intent);
                        break;
                    case "体温":
                        intent.putExtra(NewBloodPressureActivity.ITEM_NAME,"体温");
                        intent.putExtra(NewBloodPressureActivity.ITEM_IMAGE_ID,R.drawable.grape);
                        startActivity(intent);
                        break;
                    case "心率":
                        intent.putExtra(NewBloodPressureActivity.ITEM_NAME,"心率");
                        intent.putExtra(NewBloodPressureActivity.ITEM_IMAGE_ID,R.drawable.orange);
                        startActivity(intent);
                        break;
                    case "血氧":
                        intent.putExtra(NewBloodPressureActivity.ITEM_NAME,"血氧");
                        intent.putExtra(NewBloodPressureActivity.ITEM_IMAGE_ID,R.drawable.watermelon);
                        startActivity(intent);
                        break;
                    case "饮食":
                        intent.putExtra(NewBloodPressureActivity.ITEM_NAME,"饮食");
                        intent.putExtra(NewBloodPressureActivity.ITEM_IMAGE_ID,R.drawable.pineapple);
                        startActivity(intent);
                        break;
                    case "服药":
                        intent.putExtra(NewBloodPressureActivity.ITEM_NAME,"服药");
                        intent.putExtra(NewBloodPressureActivity.ITEM_IMAGE_ID,R.drawable.strawberry);
                        startActivity(intent);
                        break;
                    case "过敏":
                        intent.putExtra(NewBloodPressureActivity.ITEM_NAME,"过敏");
                        intent.putExtra(NewBloodPressureActivity.ITEM_IMAGE_ID,R.drawable.mango);
                        startActivity(intent);
                        break;

                }

            }
        });

        return v;
    }


    //---------------------toolBar的调用----------------------//
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState){setHasOptionsMenu(true);
        AppCompatActivity appCompatActivity = (AppCompatActivity)getActivity();
        Toolbar toolbar =(Toolbar)appCompatActivity.findViewById(R.id.detail_page_toolbar);
        collapsingToolbarLayout = (CollapsingToolbarLayout)
                appCompatActivity.findViewById(R.id.detail_page_collapsing_toolbar);
        appCompatActivity.setSupportActionBar(toolbar);
        super.onActivityCreated(savedInstanceState);

        toolbar.hideOverflowMenu();
        toolbar.setTitle("");
        toolbar.setSubtitle("");

        ActionBar actionBar =appCompatActivity.getSupportActionBar();
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(false);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        }




        //-------------左侧的返回按钮点按效果--------------------------//
//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getActivity(),"p",Toast.LENGTH_SHORT).show();
//                DrawerLayout drawerLayout =(DrawerLayout)getActivity()
//                        .findViewById(R.id.main_interface_drawer_layout);
//                drawerLayout.openDrawer(GravityCompat.START);
//            }
//        });


    }

    //---------------------fragment获取toolBar获取menu------------------------//
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater){
        menuInflater.inflate(R.menu.detail_interface_toolbar,menu);
        super.onCreateOptionsMenu(menu,menuInflater);
    }

    //---------------------监听toolBar的点按结果-------------------------------//
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
        }
        return true;
    }

    private void initUI(){
        for(int i = 0;i<tabTitle.length;i++){
            mTabLayout.addTab((mTabLayout.newTab().setText(tabTitle[i])));
            Log.d("test", "TabLayout0");
        }
        //设置文字居中
        mTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        //设置顶部标签指示条的颜色
        mTabLayout.setSelectedTabIndicatorColor(Color.parseColor("#4AC2B4"));
        //设置标签 “未选中" 和 “选中” 的颜色
        mTabLayout.setTabTextColors(Color.parseColor("#656565"),
                Color.parseColor("#4ac2b4"));
        mViewPager.setAdapter(new MainInterfaceDetailFragmentPagerAdapter(getChildFragmentManager(),tabTitle));

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));

        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                int position = tab.getPosition();
                if(position==1){
                    pageTagPreferencesEditor.putString("itemName",tabTitle[position]);
                    pageTagPreferencesEditor.commit();
                }
                collapsingToolbarLayout.setTitle(tabTitle[position]);

                mViewPager.setCurrentItem(position);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void initBar(View v){
        detailSearchEditText = v.findViewById(R.id.detail_search_editText);
        detailMenuButton = (ImageButton)v.findViewById(R.id.detail_menu_button);
        detailMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DrawerLayout drawerLayout =(DrawerLayout)getActivity()
                        .findViewById(R.id.main_interface_drawer_layout);
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
        detailSearchButton = (ImageButton)v.findViewById(R.id.detail_search_button);
        detailSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                detailSearchData = detailSearchEditText.getText().toString();
                Toast.makeText(getActivity(),"你点击了搜索按钮,正在尝试搜索"+detailSearchData,Toast.LENGTH_SHORT).show();
            }
        });
    }

    public Fragment getVisibleFragment(){
        FragmentManager fragmentManager = getChildFragmentManager();
        List<Fragment> fragments = fragmentManager.getFragments();
        for(Fragment fragment : fragments){
            if(fragment != null && fragment.isVisible())
                return fragment;
        }
        return null;
    }


}
