package com.stcodesapp.quotes_einstein.ui.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBarDrawerToggle;
import android.widget.FrameLayout;
import com.stcodesapp.quotes_einstein.R;
import com.stcodesapp.quotes_einstein.controllers.commons.FragmentFrameWrapper;
import com.stcodesapp.quotes_einstein.controllers.commons.NavigationDrawerController;
import com.stcodesapp.quotes_einstein.factory.ControllerFactory;
import com.stcodesapp.quotes_einstein.factory.ViewFactory;
import com.stcodesapp.quotes_einstein.ui.commons.NavigationDrawerView;

import javax.inject.Inject;

public class BaseNavigationDrawerActivity extends BaseActivity implements FragmentFrameWrapper {

    @Inject ViewFactory viewFactory;
    @Inject ControllerFactory controllerFactory;


    private NavigationDrawerView navigationDrawerView;
    private NavigationDrawerController navigationDrawerController;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initNavigationDrawerLayout();
    }

    private void initNavigationDrawerLayout()
    {
        getPresentationComponent().inject(this);
        navigationDrawerView = viewFactory.getNavigationDrawerView(null);
        navigationDrawerController = controllerFactory.getNavigationDrawerController();
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
        navigationDrawerController.onPostCreate();
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
            navigationDrawerController.onBackPressed();
        }
    }

    @Override
    public FrameLayout getFragmentFrame() {
        return navigationDrawerView.getFragmentFrame();
    }
}
