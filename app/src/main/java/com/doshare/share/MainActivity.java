package com.doshare.share;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.doshare.share.ui.act.base.BaseActivity;
import com.doshare.share.ui.fra.HomeFragment;
import com.doshare.share.ui.fra.MenuRightFragment;
import com.doshare.share.ui.fra.base.FragmentFactory;
import com.doshare.share.utils.ToolUI;
import com.doshare.share.widget.WaveSwipeRefreshLayout.WaveSwipeRefreshLayout;
import com.nineoldandroids.view.ViewHelper;

import java.util.HashMap;
import java.util.Map;


public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener, WaveSwipeRefreshLayout.OnRefreshListener {

    public final int FRAGMENT_RIGHT = 0;// 右菜单
    public final int FRAGMENT_HOME = 1;// 主页
    public final int FRAGMENT_FIND = 2;
    public final int FRAGMENT_ME = 4;
    private final int FRAGMENT_NICKNAME = 5;
    private final int FRAGMENT_INSTRUCTIONS = 7;
    private final int FRAGMENT_ABOUT = 8;

    private DrawerLayout mDrawer;

    private WaveSwipeRefreshLayout mWaveSwipeRefreshLayout;
    private ListView mListView;

    private Map<Integer, Class> fraClazzs = new HashMap<Integer, Class>();
    private FragmentFactory fragmentFactory;

    private FragmentManager fm;
    private int currentFragment = 0;

    @Override
    public void initView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        toolbar.setTitle("首页");setSupportActionBar(toolbar);

        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDrawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawer.setDrawerListener(toggle);
        mDrawer.setScrimColor(Color.TRANSPARENT);
        toggle.syncState();

        /************* 下拉控件*************/
        mWaveSwipeRefreshLayout = (WaveSwipeRefreshLayout) findViewById(R.id.main_wave);
        mWaveSwipeRefreshLayout.setColorSchemeColors(Color.GRAY);
        mWaveSwipeRefreshLayout.setOnRefreshListener(this);
        mWaveSwipeRefreshLayout.setWaveColor(ToolUI.getColor(R.color.orange));
        /**************************/

//        mListView = (ListView) findViewById(R.id.main_list);

//        findViewById(R.id.button_of_wave_color).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                mWaveSwipeRefreshLayout.setWaveColor(0xFF000000+new Random().nextInt(0xFFFFFF)); // Random assign
//            }
//        });

        NavigationView navigationView = (NavigationView) findViewById(R.id.l_nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        /***************右菜单*****************/
    }

    @Override
    protected void initData() {
        super.initData();
        fraClazzs.put(FRAGMENT_RIGHT, MenuRightFragment.class);
        fraClazzs.put(FRAGMENT_HOME, HomeFragment.class);
        fm = getSupportFragmentManager();
        fragmentFactory = new FragmentFactory(fraClazzs);
        setCurrentFragmentById(FRAGMENT_HOME);

        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.main_right, fragmentFactory.getFragent(FRAGMENT_RIGHT)).commit();
    }

    private void setCurrentFragmentById(int index) {
            FragmentTransaction transaction = fm.beginTransaction();
            transaction.replace(R.id.main_fra, fragmentFactory.getFragent(index)).commit();
            currentFragment = index;
    }

    @Override
    protected void initEvent() {

        mDrawer.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                View mContent = mDrawer.getChildAt(0);
                View mMenu = drawerView;
                float scale = 1 - slideOffset;
                float rightScale = 0.8f + scale * 0.2f;

                if (drawerView.getTag().equals("LEFT")) {

                    float leftScale = 1 - 0.3f * scale;

                    //ViewHelper.setScaleX(mMenu, leftScale);
                    //ViewHelper.setScaleY(mMenu, leftScale);
                    //ViewHelper.setAlpha(mMenu, 0.6f + 0.4f * (1 - scale));
                    ViewHelper.setTranslationX(mContent, mMenu.getMeasuredWidth() * (1 - scale));
                    ViewHelper.setPivotX(mContent, 0);
                    ViewHelper.setPivotY(mContent, mContent.getMeasuredHeight() / 2);
                    mContent.invalidate();
                    ViewHelper.setScaleX(mContent, rightScale);
                    //ViewHelper.setScaleY(mDrawer.getChildAt(1), ToolUI.getStatusBarHeight(getBaseContext()));
                } else {
                    //ViewHelper.setAlpha(mMenu, 0.6f + 0.4f * (1 - scale));
                    ViewHelper.setTranslationX(mContent, -mMenu.getMeasuredWidth() * slideOffset);
                    //ViewHelper.setPivotX(mContent, mContent.getMeasuredWidth());
                    mContent.invalidate();
                   // ViewHelper.setScaleX(mContent, rightScale);
                    //ViewHelper.setScaleY(mContent, rightScale);

                }
            }

            @Override
            public void onDrawerOpened(View drawerView) {

            }

            @Override
            public void onDrawerClosed(View drawerView) {
                if (mDrawer.isDrawerOpen(GravityCompat.START)) {
                    mDrawer.closeDrawer(GravityCompat.START);
                } else if (mDrawer.isDrawerOpen(GravityCompat.END)) {
                    mDrawer.closeDrawer(GravityCompat.END);
                }
            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });

        super.initEvent();
    }

    public void openRightMenu() {
        if (mDrawer.isDrawerOpen(GravityCompat.END)) {
            mDrawer.closeDrawer(GravityCompat.END);
        } else {
            mDrawer.openDrawer(GravityCompat.END);
        }
    }

    @Override
    public void resume() {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void onBackPressed() {
        if (mDrawer.isDrawerOpen(GravityCompat.START)) {
            mDrawer.closeDrawer(GravityCompat.START);
        } else if (mDrawer.isDrawerOpen(GravityCompat.END)) {
            mDrawer.closeDrawer(GravityCompat.END);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        if (mDrawer.isDrawerOpen(GravityCompat.START)) {
            mDrawer.closeDrawer(GravityCompat.START);
        } else if (mDrawer.isDrawerOpen(GravityCompat.END)) {
            mDrawer.closeDrawer(GravityCompat.END);
        }

        return true;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_edit:
                openRightMenu();
                break;
        }
        return true;
    }

    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mWaveSwipeRefreshLayout.setRefreshing(false);
            }
        }, 3000);
    }
}
