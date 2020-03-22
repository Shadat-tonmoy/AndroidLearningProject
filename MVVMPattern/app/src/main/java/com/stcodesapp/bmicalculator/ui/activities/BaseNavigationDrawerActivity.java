package com.stcodesapp.bmicalculator.ui.activities;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;

import com.stcodesapp.bmicalculator.R;
import com.stcodesapp.bmicalculator.common.BaseActivity;
import com.stcodesapp.bmicalculator.controller.activityController.NavigationDrawerController;
import com.stcodesapp.bmicalculator.factory.ViewFactory;
import com.stcodesapp.bmicalculator.ui.views.screenView.commons.NavigationDrawerView;

import javax.inject.Inject;

public class BaseNavigationDrawerActivity extends BaseActivity {


    @Inject NavigationDrawerController navigationDrawerController;
    @Inject ViewFactory viewFactory;
    private NavigationDrawerView navigationDrawerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initNavigationDrawerLayout();
    }

    private void initNavigationDrawerLayout()
    {
        getPresentationComponent().inject(this);
        navigationDrawerView = viewFactory.getNavigationDrawerView(null);
        navigationDrawerController.bindView(navigationDrawerView);
        setActionBar();
        setContentView(navigationDrawerView.getRootView());

    }

    private void setActionBar()
    {
        setSupportActionBar(navigationDrawerView.getToolbar());
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,navigationDrawerView.getDrawerLayout(),navigationDrawerView.getToolbar(),R.string.drawer_open, R.string.drawer_close);
        navigationDrawerView.getDrawerLayout().setDrawerListener(actionBarDrawerToggle);
        if(getSupportActionBar()!=null)
        {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
        }
        actionBarDrawerToggle.syncState();

    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        navigationDrawerController.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        navigationDrawerController.onStop();
    }

    @Override
    public void onBackPressed() {
        if(navigationDrawerView.isDrawerOpen())
        {
            navigationDrawerView.closeNavDrawer();
        }
        else
        {
            super.onBackPressed();
        }
    }
}
