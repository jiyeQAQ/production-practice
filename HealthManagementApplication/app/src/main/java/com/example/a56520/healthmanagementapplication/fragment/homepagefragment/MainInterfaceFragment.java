package com.example.a56520.healthmanagementapplication.fragment.homepagefragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.a56520.healthmanagementapplication.Adapter.Shortcut;
import com.example.a56520.healthmanagementapplication.Adapter.ShortcutAdapter;
import com.example.a56520.healthmanagementapplication.NewBloodPressureActivity;
import com.example.a56520.healthmanagementapplication.R;


import java.util.ArrayList;
import java.util.List;


public class MainInterfaceFragment extends Fragment {

    //private MainInterface mMainInterface;
    private List<Shortcut> shortcutList = new ArrayList<>();
    private ShortcutAdapter shortcutAdapter;
    private Shortcut[] shortcuts = {new Shortcut("血压",R.drawable.apple,9072344,
            "高压",160,"mmHg",
            "低压",95,"mmHg","DOUBLE"),
            new Shortcut("血糖",R.drawable.banana,9071655,
                    "空腹",160,"mmol/L",
                    "SINGLE"),
            new Shortcut("心率",R.drawable.pear,9071623,
                    "心率",160,"次/秒",
                    "SINGLE"),
            new Shortcut( "体温",R.drawable.watermelon,1234567,
                    "体温", 40,"℃","SINGLE"),
            new Shortcut( "血氧",R.drawable.cherry,2345678,
                    "血氧",80,"%","SINGLE"),
            new Shortcut( "体重",R.drawable.grape,3456789,
                    "体重",65,"kg","SINGLE"),
            new Shortcut("饮食",R.drawable.mango,"PICTURE"),
            new Shortcut("病历",R.drawable.mango,"PICTURE"),
            new Shortcut("化验单",R.drawable.mango,"PICTURE"),
            new Shortcut("服药",R.drawable.mango,"PICTURE"),
            new Shortcut("不适",R.drawable.mango,"PICTURE"),



    };

    @Override
     public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //mMainInterface = new MainInterface();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_main_interface_homepage,
                container,false);


//--------------------------主页的recyclerView的设置---------------------------------------------------//
        initShortcut();
        RecyclerView recyclerView = (RecyclerView)v
                .findViewById(R.id.main_interface_test_recyclerView);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(),2);
        recyclerView.setLayoutManager(layoutManager);
        shortcutAdapter = new ShortcutAdapter(shortcutList);
        recyclerView.setAdapter(shortcutAdapter);

//-------------------------主界面卡片的点击响应---------------------//
        shortcutAdapter.setOnItemClickListener(new ShortcutAdapter.OnItemClickListener() {


            @Override
            public void onItemLongClick(View view, int position) {
                    Toast.makeText(getActivity(), position + "click",
                            Toast.LENGTH_SHORT).show();
                            }
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(getActivity(), position + " long click",
                        Toast.LENGTH_SHORT).show();
//-------------------启动对应的新建窗口-----------------------------//
                Shortcut shortcut = shortcutList.get(position);


                switch (position){

                }
                Intent intent = new Intent(getActivity(),NewBloodPressureActivity.class);
                intent.putExtra(NewBloodPressureActivity.ITEM_NAME,shortcut.getShortcutName());
                intent.putExtra(NewBloodPressureActivity.ITEM_IMAGE_ID,
                        shortcut.getShortcutImageId());
                startActivity(intent);

            }
        });

        return v;
    }

    //---------------------toolBar的调用----------------------//
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState){
        setHasOptionsMenu(true);
        AppCompatActivity appCompatActivity = (AppCompatActivity)getActivity();
        Toolbar toolbar =(Toolbar)appCompatActivity.findViewById(R.id.main_interface_toolbar);
        appCompatActivity.setSupportActionBar(toolbar);
        super.onActivityCreated(savedInstanceState);

        ActionBar actionBar =appCompatActivity.getSupportActionBar();
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        }

        //-------------左侧的返回按钮点按效果--------------------------//
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"p",Toast.LENGTH_SHORT).show();
                DrawerLayout drawerLayout =(DrawerLayout)getActivity()
                        .findViewById(R.id.main_interface_drawer_layout);
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });




    }

//---------------------fragment获取toolBar获取menu------------------------//
    @Override
    public void onCreateOptionsMenu(Menu menu,MenuInflater menuInflater){
        menuInflater.inflate(R.menu.main_interface_toolbar,menu);
        super.onCreateOptionsMenu(menu,menuInflater);
    }

//---------------------监听toolBar的点按结果-------------------------------//
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.Comment:
                Toast.makeText(getActivity(),"test",Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
//-------------------初始化布局------------------------------------------//
    private void initShortcut(){
        shortcutList.clear();
//        for(int j=0;j<6;j++){
            for(int i=0;i<shortcuts.length;i++) {
                shortcutList.add(shortcuts[i]);
            }
//        }
    }


}
