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

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.stcodesapp.bmicalculator.R;
import com.stcodesapp.bmicalculator.ui.views.screen.commons.BottomNavigationScreen;
import com.stcodesapp.bmicalculator.ui.views.screen.commons.NavigationDrawerScreen;

public class BottomNavigationScreenView extends BaseObservableScreenView<BottomNavigationScreen.Listener> implements BottomNavigationScreen
{

    private BottomNavigationView bottomNavigationView;
    private Toolbar toolbar;
    private FrameLayout frameLayout;

    public BottomNavigationScreenView(LayoutInflater layoutInflater, @Nullable ViewGroup parent)
    {
        super.setRootView(layoutInflater.inflate(R.layout.bottom_navigation_layout,parent,false));
        inflateUIElements();
        initUserInteractions();
    }


    @Override
    public void initUserInteractions() {
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)
            {
                for(Listener listener : getListeners())
                {
                    listener.onBottomNavigationItemClicked(menuItem.getItemId());
                }
                return true;
            }
        });

    }

    @Override
    public void inflateUIElements() {
        toolbar = findViewById(R.id.app_toolbar);
        bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        frameLayout = findViewById(R.id.frame_content);

    }


    public Toolbar getToolbar() {
        return toolbar;
    }

    public BottomNavigationView getBottomNavigationView() {
        return bottomNavigationView;
    }

    public FrameLayout getFrameLayout() {
        return frameLayout;
    }
}
