package com.example.a56520.healthmanagementapplication;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.a56520.healthmanagementapplication.fragment.homepagefragment.MainInterfaceEmergencyFragment;
import com.example.a56520.healthmanagementapplication.fragment.homepagefragment.MainInterfaceFragment;
import com.example.a56520.healthmanagementapplication.fragment.homepagefragment.MainInterfaceDetailFragment;
import com.example.a56520.healthmanagementapplication.fragment.homepagefragment.MainInterfaceMessageFragment;
import com.example.a56520.healthmanagementapplication.fragment.homepagefragment.MainInterfaceOverviewFragment;

public class MainInterfaceActivity extends AppCompatActivity {

    private FragmentManager fm;
    private Fragment homepageFragment,detailPageFragment,emergencyFragment,messageFragment,
            overviewFragment,from,to;
    private DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_interface);
//--------------------调用fragment-----------------------------//
        fm =getSupportFragmentManager();
        homepageFragment = fm.findFragmentById(R.id.main_interface_frameLayout);


        if(homepageFragment == null) {
            homepageFragment = new MainInterfaceFragment();
            if(detailPageFragment == null) {
                detailPageFragment = new MainInterfaceDetailFragment();
            }
            if (emergencyFragment == null) {
                emergencyFragment = new MainInterfaceEmergencyFragment();
            }
            if(messageFragment == null){
                messageFragment = new MainInterfaceMessageFragment();
            }
            if(overviewFragment == null){
                overviewFragment = new MainInterfaceOverviewFragment();
            }
            fm.beginTransaction()
                    .add(R.id.main_interface_frameLayout,overviewFragment)
                    .add(R.id.main_interface_frameLayout,messageFragment)
                    .add(R.id.main_interface_frameLayout,emergencyFragment)
                    .add(R.id.main_interface_frameLayout,detailPageFragment)
                    .add(R.id.main_interface_frameLayout,homepageFragment)
                    .hide(overviewFragment)
                    .hide(messageFragment)
                    .hide(emergencyFragment)
                    .hide(detailPageFragment)
                    .show(homepageFragment)
                    .commit();
            from = homepageFragment;
        }
//-----------------------------调用fragment---------------------//
//-----------------------------底部导航栏设置--------------------//
        BottomNavigationBar bottomNavigationBar = (BottomNavigationBar)findViewById(R.id.main_interface_bottomNavigationBar);
        bottomNavigationBar
                .setInActiveColor("#FFFFFF")
                .setBarBackgroundColor("#111111")
                .addItem(new BottomNavigationItem(R.drawable.ic_backup,"backup"))
                .addItem(new BottomNavigationItem(R.drawable.ic_comment,"comment"))
                .addItem(new BottomNavigationItem(R.drawable.ic_delete,"delete"))
                .addItem(new BottomNavigationItem(R.drawable.ic_done,"done"))
                .addItem(new BottomNavigationItem(R.drawable.ic_menu,"menu"))
                .initialise();

        //------------------------底部导航栏按钮监听----------------//
        bottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
                switch(position){
                    case 0:
                        to = homepageFragment;
                        break;
                    case 1:
                        to = detailPageFragment;
                        break;
                    case 2:
                        to = emergencyFragment;
                        break;
                    case 3:
                        to = overviewFragment;
                        break;
                    case 4:
                        to = messageFragment;
                        break;
                }
                switchFragment(from,to);
                switch(position){
                    case 0:
                        from = homepageFragment;
                        break;
                    case 1:
                        from = detailPageFragment;
                        break;
                    case 2:
                        from = emergencyFragment;
                        break;
                    case 3:
                        from = overviewFragment;
                        break;
                    case 4:
                        from = messageFragment;
                        break;
                }
               // Toast.makeText(MainInterfaceActivity.this,position+"",Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onTabUnselected(int position) {

                //Toast.makeText(MainActivity.this,position+"选中",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTabReselected(int position) {
                // Toast.makeText(MainActivity.this,"恒定",Toast.LENGTH_SHORT).show();
            }
        });

//----------------------侧滑菜单栏的设置---------------------------------------------------//
        drawerLayout = (DrawerLayout)findViewById(R.id.main_interface_drawer_layout);
        NavigationView navView = (NavigationView)findViewById(R.id.main_interface_nav_view);

        ActionBar actionBar =getSupportActionBar();
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        }


        navView.setCheckedItem(R.id.nav_call);
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                drawerLayout.closeDrawers();
                return true;
            }
        });
    }

    //------------------用于切换主活动即主页的不同的fragment---------------------------------//
    private void switchFragment(Fragment from,Fragment to){
        if(!to.isAdded()){
            fm.beginTransaction()
                    .hide(from)
                    .add(R.id.main_interface_frameLayout,to)
                    .show(to)
                    .commit();
        }
        else{
            fm.beginTransaction()
                    .hide(from)
                    .show(to)
                    .commit();
        }
    }
}
