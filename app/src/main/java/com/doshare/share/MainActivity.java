package com.doshare.share;

import android.graphics.Color;
import android.os.Bundle;
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

import com.doshare.share.ui.act.base.BaseActivity;
import com.doshare.share.ui.fra.ForumFragment;
import com.doshare.share.ui.fra.HomeFragment;
import com.doshare.share.ui.fra.HotFragment;
import com.doshare.share.ui.fra.RightChatFragment;
import com.doshare.share.ui.fra.ShareBookFragment;
import com.doshare.share.ui.fra.base.FragmentFactory;
import com.nineoldandroids.view.ViewHelper;

import java.util.HashMap;
import java.util.Map;


public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {

    public final int FRAGMENT_RIGHT = 0;// 右菜单
    public final int FRAGMENT_HOME = 1;// 主页
    public final int FRAGMENT_SHAREBOOK = 2;// 阅享
    public final int FRAGMENT_HOT = 3;// 精选
    public final int FRAGMENT_FORUM = 4;// 论坛
    private final int FRAGMENT_NICKNAME = 5;
    private final int FRAGMENT_INSTRUCTIONS = 7;
    private final int FRAGMENT_ABOUT = 8;

    private DrawerLayout mDrawer;
    private Toolbar toolbar;

    private Map<Integer, Class> fraClazzs = new HashMap<Integer, Class>();
    private FragmentFactory fragmentFactory;

    private FragmentManager fm;
    private int currentFragment = 0;

    @Override
    public void initView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        toolbar.setTitle(R.string.menu_home);
        setSupportActionBar(toolbar);

        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDrawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawer.setDrawerListener(toggle);
        mDrawer.setScrimColor(Color.TRANSPARENT);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.l_nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemTextColor(null);
        navigationView.setItemIconTintList(null);
        /***************右菜单*****************/
    }

    @Override
    protected void initData() {
        super.initData();
        fraClazzs.put(FRAGMENT_RIGHT, RightChatFragment.class);
        fraClazzs.put(FRAGMENT_HOME, HomeFragment.class);
        fraClazzs.put(FRAGMENT_SHAREBOOK, ShareBookFragment.class);
        fraClazzs.put(FRAGMENT_HOT, HotFragment.class);
        fraClazzs.put(FRAGMENT_FORUM, ForumFragment.class);
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
                    ViewHelper.setTranslationX(mContent, mMenu.getMeasuredWidth() * (1 - scale));
                    mContent.invalidate();
                } else {
                    ViewHelper.setTranslationX(mContent, -mMenu.getMeasuredWidth() * slideOffset);
                    mContent.invalidate();
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

        if (id == R.id.nav_home) {
            setCurrentFragmentById(FRAGMENT_HOME);
            toolbar.setTitle(R.string.menu_home);
        } else if (id == R.id.nav_book) {
            setCurrentFragmentById(FRAGMENT_SHAREBOOK);
            toolbar.setTitle(R.string.menu_book);
        } else if (id == R.id.nav_hot) {
            setCurrentFragmentById(FRAGMENT_HOT);
            toolbar.setTitle(R.string.menu_hot);
        } else if (id == R.id.nav_forum) {
            setCurrentFragmentById(FRAGMENT_FORUM);
            toolbar.setTitle(R.string.menu_forum);
        } else if (id == R.id.nav_help) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_about_us) {

        } else if (id == R.id.nav_setting) {

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
}
