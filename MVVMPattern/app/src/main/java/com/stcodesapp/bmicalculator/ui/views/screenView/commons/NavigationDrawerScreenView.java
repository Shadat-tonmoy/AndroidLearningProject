package com.stcodesapp.bmicalculator.ui.views.screenView.commons;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.stcodesapp.bmicalculator.R;
import com.stcodesapp.bmicalculator.ui.views.screen.commons.NavigationDrawerScreen;

public class NavigationDrawerScreenView extends BaseObservableScreenView<NavigationDrawerScreen.Listener> implements NavigationDrawerScreen {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolbar;
    private FrameLayout frameLayout;

    public NavigationDrawerScreenView(LayoutInflater layoutInflater, @Nullable ViewGroup parent)
    {
        super.setRootView(layoutInflater.inflate(R.layout.navigation_drawer_layout,parent,false));
        inflateUIElements();
        initUserInteractions();
    }


    @Override
    public void initUserInteractions() {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                drawerLayout.closeDrawers();
                for(Listener listener : getListeners())
                {
                    listener.onNavigationDrawerItemClicked(menuItem.getItemId());
                }
                return true;
            }
        });

    }

    @Override
    public void inflateUIElements() {
        toolbar = findViewById(R.id.app_toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        frameLayout = findViewById(R.id.frame_content);

    }

    public void checkMenuItem(int itemId)
    {
        navigationView.setCheckedItem(itemId);
    }

    public void closeNavDrawer() {
        drawerLayout.closeDrawers();
    }

    public boolean isDrawerOpen() {
        return drawerLayout.isDrawerOpen(GravityCompat.START);
    }

    public Toolbar getToolbar() {
        return toolbar;
    }

    public DrawerLayout getDrawerLayout() {
        return drawerLayout;
    }

    public FrameLayout getFrameLayout() {
        return frameLayout;
    }
}
