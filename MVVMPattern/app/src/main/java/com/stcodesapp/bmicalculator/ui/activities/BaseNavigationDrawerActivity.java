package com.stcodesapp.bmicalculator.ui.activities;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;

import com.stcodesapp.bmicalculator.R;
import com.stcodesapp.bmicalculator.common.baseUI.BaseActivity;
import com.stcodesapp.bmicalculator.common.fragmentHelper.FragmentFrameWrapper;
import com.stcodesapp.bmicalculator.controller.activityController.NavigationDrawerController;
import com.stcodesapp.bmicalculator.factory.ViewFactory;
import com.stcodesapp.bmicalculator.ui.views.screenView.commons.NavigationDrawerView;

import javax.inject.Inject;

public class BaseNavigationDrawerActivity extends BaseActivity implements FragmentFrameWrapper {


    @Inject NavigationDrawerController controller;
    @Inject ViewFactory viewFactory;
    private NavigationDrawerView screenView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initNavigationDrawerLayout();
    }

    private void initNavigationDrawerLayout()
    {
        getPresentationComponent().inject(this);
        screenView = viewFactory.getNavigationDrawerView(null);
        controller.bindView(screenView);
        setActionBar();
        setContentView(screenView.getRootView());

    }

    private void setActionBar()
    {
        setSupportActionBar(screenView.getToolbar());
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, screenView.getDrawerLayout(), screenView.getToolbar(),R.string.drawer_open, R.string.drawer_close);
        screenView.getDrawerLayout().setDrawerListener(actionBarDrawerToggle);
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
        controller.onPostCreate();
    }

    @Override
    protected void onStart() {
        super.onStart();
        controller.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        controller.onStop();
    }

    @Override
    public void onBackPressed() {
        if(screenView.isDrawerOpen())
        {
            screenView.closeNavDrawer();
        }
        else
        {
            super.onBackPressed();
        }
    }

    @Override
    public FrameLayout getFragmentFrame() {
        return screenView.getFrameLayout();
    }
}
